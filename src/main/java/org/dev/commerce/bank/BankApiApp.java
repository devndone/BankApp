package org.dev.commerce.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"org.dev.commerce.bank"})
public class BankApiApp {

	public static void main(String[] args) {
		SpringApplication.run(BankApiApp.class, args);
	}
}
