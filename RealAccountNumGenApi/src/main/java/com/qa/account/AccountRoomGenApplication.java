package com.qa.account;

import com.qa.account.util.generators.AbstractAccountGen;
import com.qa.account.util.generators.CreateAccount;
import com.qa.account.util.generators.EightAccountGen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountRoomGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountRoomGenApplication.class, args);
	}


	@Bean
	public CreateAccount createAccount(){
		return new CreateAccount();
	}

	@Bean
	public AbstractAccountGen accountGenerator(){
		return new EightAccountGen();
	}


}


