package com.bh.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTransactionServiceApplication.class, args);
	}

}
