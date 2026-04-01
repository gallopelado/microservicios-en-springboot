package com.juan.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EnrollmentMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentMsApplication.class, args);
	}

}
