#include <iostream>
#include <jni.h>
#include <jni_md.h>
#include <jvmti.h>
#include "org_example_Helper.h"

static jvmtiEnv* jvmti;
static jlong tagCounter = 0;

struct LimitCounter {
	jint currentCounter;
	jint limitValue;

	void init(jint limit) {
		currentCounter = 0;
		limitValue = limit;
	}

	void countDown() {
		currentCounter++;
	}

	bool allow() {
		if (limitValue < 0) {
			return true;
		}
		return limitValue > currentCounter;
	}
};

// 每次 IterateOverInstancesOfClass 调用前需要先 init
static LimitCounter limitCounter = { 0, 0 };

extern "C"
int init_agent(JavaVM * vm, void* reserved) {
	jint rc;
	/* Get JVMTI environment */
	rc = vm->GetEnv((void**)&jvmti, JVMTI_VERSION_1_2);
	if (rc != JNI_OK) {
		fprintf(stderr, "ERROR: arthas vmtool Unable to create jvmtiEnv, GetEnv failed, error=%d\n", rc);
		return -1;
	}

	jvmtiCapabilities capabilities = { 0 };
	capabilities.can_tag_objects = 1;
	jvmtiError error = jvmti->AddCapabilities(&capabilities);
	if (error) {
		fprintf(stderr, "ERROR: arthas vmtool JVMTI AddCapabilities failed!%u\n", error);
		return JNI_FALSE;
	}

	return JNI_OK;
}

extern "C" JNIEXPORT jint JNICALL
Agent_OnLoad(JavaVM * vm, char* options, void* reserved) {
	return init_agent(vm, reserved);
}

extern "C" JNIEXPORT jint JNICALL
Agent_OnAttach(JavaVM * vm, char* options, void* reserved) {
	return init_agent(vm, reserved);
}

extern "C" JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM * vm, void* reserved) {
	init_agent(vm, reserved);
	return JNI_VERSION_1_6;
}

extern "C"
JNIEXPORT void JNICALL
Java_org_example_Helper_forceGc0(JNIEnv*, jclass) {
	jvmti->ForceGarbageCollection();
}

extern "C"
jlong getTag() {
	return ++tagCounter;
}

extern "C"
jvmtiIterationControl JNICALL
HeapObjectCallback(jlong class_tag, jlong size, jlong * tag_ptr, void* user_data) {
	jlong* data = static_cast<jlong*>(user_data);
	*tag_ptr = *data;

	limitCounter.countDown();
	if (limitCounter.allow()) {
		return JVMTI_ITERATION_CONTINUE;
	}
	else {
		return JVMTI_ITERATION_ABORT;
	}
}

extern "C"
JNIEXPORT jobjectArray JNICALL
Java_org_example_Helper_getInstances0(JNIEnv * env, jclass thisClass, jclass klass, jint limit) {
	jlong tag = getTag();
	limitCounter.init(limit);
	jvmtiError error = jvmti->IterateOverInstancesOfClass(klass, JVMTI_HEAP_OBJECT_EITHER,
		HeapObjectCallback, &tag);
	if (error) {
		printf("ERROR: JVMTI IterateOverInstancesOfClass failed!%u\n", error);
		return NULL;
	}

	jint count = 0;
	jobject* instances;
	error = jvmti->GetObjectsWithTags(1, &tag, &count, &instances, NULL);
	if (error) {
		printf("ERROR: JVMTI GetObjectsWithTags failed!%u\n", error);
		return NULL;
	}

	jobjectArray array = env->NewObjectArray(count, klass, NULL);
	int i = 0;
	for (i = 0; i < count; i++) {
		env->SetObjectArrayElement(array, i, instances[i]);
	}
	jvmti->Deallocate(reinterpret_cast<unsigned char*>(instances));
	return array;
}

extern "C"
JNIEXPORT jlong JNICALL
Java_org_example_Helper_sumInstanceSize0(JNIEnv * env, jclass thisClass, jclass klass) {
	jlong tag = getTag();
	limitCounter.init(-1);
	jvmtiError error = jvmti->IterateOverInstancesOfClass(klass, JVMTI_HEAP_OBJECT_EITHER,
		HeapObjectCallback, &tag);
	if (error) {
		printf("ERROR: JVMTI IterateOverInstancesOfClass failed!%u\n", error);
		return -1;
	}

	jint count = 0;
	jobject* instances;
	error = jvmti->GetObjectsWithTags(1, &tag, &count, &instances, NULL);
	if (error) {
		printf("ERROR: JVMTI GetObjectsWithTags failed!%u\n", error);
		return -1;
	}

	jlong sum = 0;
	for (int i = 0; i < count; i++) {
		jlong size = 0;
		jvmti->GetObjectSize(instances[i], &size);
		sum = sum + size;
	}
	jvmti->Deallocate(reinterpret_cast<unsigned char*>(instances));
	return sum;
}

extern "C"
JNIEXPORT jlong JNICALL Java_org_example_Helper_getInstanceSize0
(JNIEnv * env, jclass thisClass, jobject instance) {
	jlong size = -1;
	jvmtiError error = jvmti->GetObjectSize(instance, &size);
	if (error) {
		printf("ERROR: JVMTI GetObjectSize failed!%u\n", error);
	}
	return size;
}

extern "C"
JNIEXPORT jlong JNICALL
Java_org_example_Helper_countInstances0(JNIEnv * env, jclass thisClass, jclass klass) {
	jlong tag = getTag();
	limitCounter.init(-1);
	jvmtiError error = jvmti->IterateOverInstancesOfClass(klass, JVMTI_HEAP_OBJECT_EITHER,
		HeapObjectCallback, &tag);
	if (error) {
		printf("ERROR: JVMTI IterateOverInstancesOfClass failed!%u\n", error);
		return -1;
	}

	jint count = 0;
	error = jvmti->GetObjectsWithTags(1, &tag, &count, NULL, NULL);
	if (error) {
		printf("ERROR: JVMTI GetObjectsWithTags failed!%u\n", error);
		return -1;
	}
	return count;
}

extern "C"
JNIEXPORT jobjectArray JNICALL Java_org_example_Helper_getAllLoadedClasses0
(JNIEnv * env, jclass thisClass, jclass kclass) {
	jclass* classes;
	jint count = 0;

	jvmtiError error = jvmti->GetLoadedClasses(&count, &classes);
	if (error) {
		printf("ERROR: JVMTI GetLoadedClasses failed!\n");
		return NULL;
	}

	jobjectArray array = env->NewObjectArray(count, kclass, NULL);
	for (int i = 0; i < count; i++) {
		env->SetObjectArrayElement(array, i, classes[i]);
	}
	jvmti->Deallocate(reinterpret_cast<unsigned char*>(classes));
	return array;
}

extern "C"
JNIEXPORT jboolean JNICALL Java_org_example_Helper_allocateMemory0
(JNIEnv * env, jclass thisClass, jlong size) {
	unsigned char** mem_ptr = (unsigned char**)malloc(size * sizeof(unsigned char*));
	jboolean ret = 0;
	for (jlong i = 0; i < size; ++i) {
		unsigned char* buf = (unsigned char*)malloc(sizeof(unsigned char));
		if (buf == NULL) {
			printf("allocate failure");
			return ret;
		}
		mem_ptr[i] = buf;
	}
	jvmtiError error = jvmti->Allocate(size, mem_ptr);
	if (error) {
		printf("allocate failure, %d", error);
		return ret;
	}
	printf("allocate success!\n");
	fflush(stdout);
	ret = 1;
	return ret;
}

/*
 * Class:     org_example_Helper
 * Method:    suspendThread0
 * Signature: (Ljava/lang/Thread;)V
 */
JNIEXPORT void JNICALL Java_org_example_Helper_suspendThread0
(JNIEnv*, jclass, jobject target) {
	jvmtiCapabilities* cap = (jvmtiCapabilities*)malloc(sizeof(jvmtiCapabilities));
	jvmti->GetCapabilities(cap);
	if (cap) {
		cap->can_suspend = true;
		jvmti->AddCapabilities(cap);
		if (cap->can_suspend) {
			printf("can suspend!\n");
		}
	}

	jint* count = (jint*)malloc(sizeof(count));
	jthread** threads = (jthread**)malloc(sizeof(jthread*));
	if (jvmtiError er = jvmti->GetAllThreads(count, threads)) {
		printf("get all threads failed. %d\n", (int)er);
	}
	if (count) {
		for (int i = 0; i < *count; ++i) {
			jvmtiThreadInfo* thread_info = (jvmtiThreadInfo*)malloc(sizeof(jvmtiThreadInfo));
			if (thread_info && threads) {
				jvmtiError err = jvmti->GetThreadInfo((*threads)[i], thread_info);
				printf("thread : %s, info\tis daemon? %d\tpriority: %d\n", thread_info->name, thread_info->is_daemon, thread_info->priority);
			}
		}
	}
	jthread thread = (jthread)target;
	jint* thread_state_ptr = (jint*)malloc(sizeof(jint));
	jvmtiError error = jvmti->GetThreadState(thread, thread_state_ptr);
	if (error) {
		printf("state is error %d\n", error);
	}
	else {
		if (thread_state_ptr)
			printf("thread state is %ld %x\n", (long)*thread_state_ptr, (long)thread_state_ptr);
		printf("next? ");
		fflush(stdout);
		int next = 0;
		scanf_s("%d", &next);
		if (!next) {
			fflush(stdout);
			return;
		}
		jvmtiThreadInfo* info = (jvmtiThreadInfo*)malloc(sizeof(jvmtiThreadInfo));

		error = jvmti->GetThreadInfo(thread, info);
		if (error) {
			printf("get info error %d \n", error);
		}
		printf("%s", info->name);
		free(thread_state_ptr);
		error = jvmti->SuspendThread(thread);
		if (error) {
			printf("some thing wrong! %d\n", error);
		}
		else {
			printf("suspend success!\n");
		}
	}
	fflush(stdout);
}