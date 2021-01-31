package com.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
@SpringBootApplication
public class PosWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosWebAppApplication.class, args);		
	}
}
