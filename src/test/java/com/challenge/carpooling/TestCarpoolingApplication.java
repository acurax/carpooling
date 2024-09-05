package com.challenge.carpooling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TestCarpoolingApplication {

	public static void main(String[] args) {
		SpringApplication.from(CarpoolingApplication::main).with(IntegrationTestContainer.class).run(args);
	}

}
