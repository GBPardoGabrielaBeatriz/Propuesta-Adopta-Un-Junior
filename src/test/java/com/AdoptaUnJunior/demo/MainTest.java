package com.AdoptaUnJunior.demo;


import com.AdoptaUnJunior.demo.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    @SpringBootTest
    public class MainTest {

   @Autowired
   private LibroRepository libroRepository;

        @Test
        public void testLibroRepositoryInjection() {
            assertNotNull(libroRepository);
        }
    }


