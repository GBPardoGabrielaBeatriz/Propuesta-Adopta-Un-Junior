package com.AdoptaUnJunior.demo.controller;

import com.AdoptaUnJunior.demo.libroDTO.LibroDTO;
import com.AdoptaUnJunior.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class LibroController {
    @Autowired
    private LibroService servicio;

        @GetMapping()
        public List<LibroDTO> obtenerTodosLosLibros () {
            return servicio.obtenerTodosLosLibros();
        }
    @Autowired
    public LibroController(LibroService libroService) {
        this.servicio = servicio;
    }}
