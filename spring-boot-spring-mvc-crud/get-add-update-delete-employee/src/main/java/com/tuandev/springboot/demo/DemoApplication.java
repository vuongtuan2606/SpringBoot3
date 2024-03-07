package com.tuandev.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 1. update db configs uin application.properties
* 2. create employee entity
* 3. create DAO interface
* 4. create DAO implementation
* 5. create REST controller to use DAO
*
* */
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
