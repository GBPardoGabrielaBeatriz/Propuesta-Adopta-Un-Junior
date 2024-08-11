package com.AdoptaUnJunior.demo;

import com.AdoptaUnJunior.demo.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdoptaUnJuniorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdoptaUnJuniorApplication.class, args);
		Main principal=new Main();
		principal.mostrarMenu();
	}

}
