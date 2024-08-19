package com.AdoptaUnJunior.demo.service;

import com.AdoptaUnJunior.demo.libroDTO.LibroDTO;
import com.AdoptaUnJunior.demo.modelo.Libro;
import com.AdoptaUnJunior.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

@Autowired
public LibroService(LibroRepository libroRepository) {
    this.libroRepository = libroRepository;
}
    private LibroRepository libroRepository;
    public List<LibroDTO> obtenerTodosLosLibros() {

        return convierteDatos(libroRepository.findAll());}

    private List<LibroDTO> convierteDatos(List<Libro> libro) {
            return libro.stream()
                    .map(l -> new LibroDTO(l.getId(), l.getAñoLanzamiento(), l.getTitulo(), l.getCantPaginas()))
                    .collect(Collectors.toList());
        }
    }



