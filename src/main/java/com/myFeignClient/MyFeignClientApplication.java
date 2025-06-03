package com.myFeignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFeignClientApplication.class, args);
	}

}
