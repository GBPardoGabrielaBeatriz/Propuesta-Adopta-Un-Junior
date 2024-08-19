package com.AdoptaUnJunior.demo.main;
import com.AdoptaUnJunior.demo.modelo.DatosApi;
import com.AdoptaUnJunior.demo.modelo.DatosLibro;
import com.AdoptaUnJunior.demo.modelo.Libro;
import com.AdoptaUnJunior.demo.repository.LibroRepository;
import com.AdoptaUnJunior.demo.service.ConsumoApi;
import com.AdoptaUnJunior.demo.service.ConversorDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;
@Service
public class Main {
    private Scanner tipeo = new Scanner(System.in);
    private ConsumoApi consumoApi ;
    private static final String URL_BASE = "https://stephen-king-api.onrender.com/api/books";
    private ConversorDatos conversor;
    private LibroRepository libroRepository;

    @Autowired
    public Main(LibroRepository libroRepository, ConsumoApi consumoApi, ConversorDatos conversor) {
        this.libroRepository = libroRepository;
        this.consumoApi = consumoApi;
        this.conversor = conversor;
    }
    public void mostrarMenu(){
        var opcion = -1;
        while (opcion != 0) {
            var menu =
         """
         ************************
         Hola! Aca podras consultar toda la bibliografia de Stephen King.
         A continuacion elige una opcion de nuestro menu ...
        
         
         ***********************
         1 - Buscar Libro
         2 - Mostrar libros buscados
                        
         0 - Salir
         """;
        System.out.println(menu);
        opcion = tipeo.nextInt();
        tipeo.nextLine();
            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibrosBuscados();
                    break;
                case 0:
                    System.out.println("Gracias! vuelva prontos!");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }}}
    private DatosApi getDatosLibro(String nombreLibro) {
     var json=consumoApi.obtenerDatos(URL_BASE );
     return  conversor.obtenerDatos(json, DatosApi.class);
        }
    private void buscarLibro() {
        System.out.println("Escribe el nombre del libro de Stephen King que deseas buscar");
        var nombreLibro = tipeo.nextLine();
        DatosApi datos=getDatosLibro(nombreLibro);
        System.out.println(datos);

        Optional<DatosLibro> libroBuscado=datos.libros().stream()
            .filter(l -> l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
            .findFirst();

        if(libroBuscado.isPresent()){
            DatosLibro datosLibro = libroBuscado.get();
            Libro libro = new Libro(datosLibro);
            libroRepository.save(libro);
            System.out.println("Aca lo encontramos! ");

            System.out.println("+++++++++ LIBRO +++++++++" +
                    "\nTítulo: " + datosLibro.titulo() +
                    "\nAño de lanzamiento: " + datosLibro.fechaLanzamiento() +
                    "\nCantidad de Paginas: " + datosLibro.cantPaginas()+
                    "\n");
        }else{
            System.out.println("Libro no encontrado");
        }
    }
    private void mostrarLibrosBuscados() {
    }}

