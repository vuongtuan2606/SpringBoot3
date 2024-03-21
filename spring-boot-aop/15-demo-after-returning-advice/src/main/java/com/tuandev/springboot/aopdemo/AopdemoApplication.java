package com.tuandev.springboot.aopdemo;

import com.tuandev.springboot.aopdemo.dao.AccountDAO;
import com.tuandev.springboot.aopdemo.dao.MembershipDAO;
import com.tuandev.springboot.aopdemo.model.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/* Developent Process - @AfterReturning
* 1. Prep Work: Add constructors to model Account class
* 2. Add new method: findAccounts() in Account class
* 3. Update main app to call the new method: findAccounts()
* 4. Add @AfterReturning advice
* */
@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {

		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO,membershipDAO);
			demoTheAfterReturningAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nDemoTheAfterReturningAdvice ");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {

		// call the business method

		Account myAccount = new Account();
		myAccount.setName("tuan");
		myAccount.setLevel("quoc");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();


		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}
}
