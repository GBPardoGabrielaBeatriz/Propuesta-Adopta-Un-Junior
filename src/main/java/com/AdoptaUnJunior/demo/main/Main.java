package com.AdoptaUnJunior.demo.main;

import com.AdoptaUnJunior.demo.modelo.DatosApi;
import com.AdoptaUnJunior.demo.modelo.DatosLibro;
import com.AdoptaUnJunior.demo.service.ConsumoApi;
import com.AdoptaUnJunior.demo.service.ConversorDatos;

import java.util.Optional;
import java.util.Scanner;
public class Main {
    private Scanner tipeo = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    // private final String URL_BASE="https://stephen-king-api.onrender.com/api/book/";
    private static final String URL_BASE = "https://stephen-king-api.onrender.com/api/books";
    //private static final String URL_BASE="https://stephen-king-api.onrender.com/api/book/";
    private ConversorDatos conversor = new ConversorDatos();


    public void mostrarMenu(){
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro=tipeo.nextLine();
        var json=consumoApi.obtenerDatos(URL_BASE );
        var datosBusqueda=conversor.obtenerDatos(json, DatosApi.class);
        // System.out.println(datosBusqueda);
        Optional<DatosLibro> libroBuscado=datosBusqueda.libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado!");
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("Libro no encontrado");
        }
    }
}

