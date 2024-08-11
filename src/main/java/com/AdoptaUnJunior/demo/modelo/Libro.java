package com.AdoptaUnJunior.demo.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int añoLanzamiento;
    @Column(unique = true)
    private String titulo;
    private int cantPaginas;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Villano> villanos;



}
