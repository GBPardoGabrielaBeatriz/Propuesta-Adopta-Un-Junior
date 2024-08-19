package com.AdoptaUnJunior.demo.repository;

import com.AdoptaUnJunior.demo.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String nombreLibro);


}
