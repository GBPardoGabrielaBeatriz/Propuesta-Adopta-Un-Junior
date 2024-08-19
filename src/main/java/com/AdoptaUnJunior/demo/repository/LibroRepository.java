package com.AdoptaUnJunior.demo.repository;

import com.AdoptaUnJunior.demo.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
