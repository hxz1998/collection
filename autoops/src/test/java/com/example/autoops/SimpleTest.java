/**
 * autoops
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/20
 **/
package com.example.autoops;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.*;
import io.kubernetes.client.proto.V1Apps;
import io.kubernetes.client.util.Config;

import java.io.IOException;
import java.util.List;

public class SimpleTest {

    static {
        ApiClient apiClient = null;
        try {
            apiClient = Config.fromConfig("./config.yaml");
            Configuration.setDefaultApiClient(apiClient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws ApiException, IOException {
        CoreV1Api api = new CoreV1Api();
        V1PodList podList = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null, null);
        AppsV1Api appsV1Api = new AppsV1Api();
        V1DeploymentList deploymentList = appsV1Api.listDeploymentForAllNamespaces(null, null, null, null, null
                , null, null, null, null, null);
        for (V1Pod pod : podList.getItems()) {
            System.out.println(pod.getMetadata().getName());
            List<V1Container> containers =  pod.getSpec().getContainers();
            for (V1Container container : containers) {
                System.out.println("--" + container.getName());
            }
        }
        System.out.println("=============================");
        for (V1Deployment deployment : deploymentList.getItems()) {
            System.out.println(deployment.getMetadata().getName());
        }
    }
}
