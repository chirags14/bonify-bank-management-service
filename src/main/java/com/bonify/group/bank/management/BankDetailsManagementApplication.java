package com.bonify.group.bank.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * /**
 * @author Chirag Suthar
 * 
 * Main class for BankDetailsManagementApplication
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.bonify.group.bank.management"})
public class BankDetailsManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BankDetailsManagementApplication.class, args);
	}
}
