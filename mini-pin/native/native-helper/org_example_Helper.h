/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_example_Helper */

#ifndef _Included_org_example_Helper
#define _Included_org_example_Helper
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_example_Helper
 * Method:    forceGc0
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_example_Helper_forceGc0
  (JNIEnv *, jclass);

/*
 * Class:     org_example_Helper
 * Method:    getInstances0
 * Signature: (Ljava/lang/Class;I)[Ljava/lang/Object;
 */
JNIEXPORT jobjectArray JNICALL Java_org_example_Helper_getInstances0
  (JNIEnv *, jclass, jclass, jint);

/*
 * Class:     org_example_Helper
 * Method:    sumInstanceSize0
 * Signature: (Ljava/lang/Class;)J
 */
JNIEXPORT jlong JNICALL Java_org_example_Helper_sumInstanceSize0
  (JNIEnv *, jclass, jclass);

/*
 * Class:     org_example_Helper
 * Method:    getInstanceSize0
 * Signature: (Ljava/lang/Object;)J
 */
JNIEXPORT jlong JNICALL Java_org_example_Helper_getInstanceSize0
  (JNIEnv *, jclass, jobject);

/*
 * Class:     org_example_Helper
 * Method:    countInstances0
 * Signature: (Ljava/lang/Class;)J
 */
JNIEXPORT jlong JNICALL Java_org_example_Helper_countInstances0
  (JNIEnv *, jclass, jclass);

/*
 * Class:     org_example_Helper
 * Method:    getAllLoadedClasses0
 * Signature: (Ljava/lang/Class;)[Ljava/lang/Class;
 */
JNIEXPORT jobjectArray JNICALL Java_org_example_Helper_getAllLoadedClasses0
  (JNIEnv *, jclass, jclass);

/*
 * Class:     org_example_Helper
 * Method:    allocateMemory0
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_example_Helper_allocateMemory0
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_example_Helper
 * Method:    suspendThread0
 * Signature: (Ljava/lang/Thread;)V
 */
JNIEXPORT void JNICALL Java_org_example_Helper_suspendThread0
  (JNIEnv *, jclass, jobject);

#ifdef __cplusplus
}
#endif
#endif
