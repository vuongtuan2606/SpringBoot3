package com.tuandev.springboot.aopdemo;

import com.tuandev.springboot.aopdemo.dao.AccountDAO;
import com.tuandev.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO,membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {

		// call the business method
		// will only match on addAccount for AccountDAO
		theAccountDAO.addAccount();

		// call the membership business method
		membershipDAO.addAccount();
	}
}
