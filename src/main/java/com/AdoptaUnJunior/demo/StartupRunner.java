 package com.AdoptaUnJunior.demo;

import com.AdoptaUnJunior.demo.main.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

    @Component
    public class StartupRunner implements CommandLineRunner {

        private final Main main;

        @Autowired
        public StartupRunner(Main main) {
            this.main = main;
        }

        @Override
        public void run(String... args) throws Exception {
            main.mostrarMenu();
        }
    }


