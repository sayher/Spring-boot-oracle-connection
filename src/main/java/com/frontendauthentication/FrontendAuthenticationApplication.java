package com.frontendauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication

@EnableDiscoveryClient
public class FrontendAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendAuthenticationApplication.class, args);
	}

}
