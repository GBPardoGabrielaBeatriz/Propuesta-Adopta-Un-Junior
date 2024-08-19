package com.AdoptaUnJunior.demo;

import com.AdoptaUnJunior.demo.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.AdoptaUnJunior.demo.service")
public class AdoptaUnJuniorApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdoptaUnJuniorApplication.class, args);

	}

}
