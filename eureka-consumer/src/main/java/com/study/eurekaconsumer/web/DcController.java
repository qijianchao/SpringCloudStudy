package com.study.eurekaconsumer.web;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-SpringBoot-study-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/DeptMybatis/";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/consumer/deptNo/")
    public Object dcByDeptNo(@RequestParam Integer deptNo) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-SpringBoot-study-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/DeptMybatis/deptNo/";
        System.out.println(url);
        MultiValueMap<String, Integer> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("deptNo", deptNo);
        return restTemplate.postForObject(url, requestEntity, Object.class);
    }
}
