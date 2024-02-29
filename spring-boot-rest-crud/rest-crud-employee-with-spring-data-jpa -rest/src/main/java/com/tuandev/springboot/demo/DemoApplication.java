package com.tuandev.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* Employee rest <---> EmployeeRepository < ---> db
*
* */

/*
* By default, Spring DATA REST will create endpoints based on entity type
* Single pluralized form
* Firt charater of Entity type is lowvercase
* Then just adds an "s" to the entity
* */

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
