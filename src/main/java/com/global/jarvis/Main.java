package com.global.jarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.global.jarvis.repository")
@EntityScan(basePackages = "com.global.jarvis.model")
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
