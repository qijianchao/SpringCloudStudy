package com.study.gatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient
@SpringBootApplication
public class GatewaydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaydemoApplication.class, args);
	}

}
