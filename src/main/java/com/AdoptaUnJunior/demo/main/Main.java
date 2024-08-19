package com.AdoptaUnJunior.demo.main;
import com.AdoptaUnJunior.demo.modelo.DatosApi;
import com.AdoptaUnJunior.demo.modelo.DatosLibro;
import com.AdoptaUnJunior.demo.service.ConsumoApi;
import com.AdoptaUnJunior.demo.service.ConversorDatos;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Main {
    private Scanner tipeo = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    // private final String URL_BASE="https://stephen-king-api.onrender.com/api/book/";
    private static final String URL_BASE = "https://stephen-king-api.onrender.com/api/books";
    //private static final String URL_BASE="https://stephen-king-api.onrender.com/api/book/";
    private ConversorDatos conversor = new ConversorDatos();
    public Main() {
    }


    public void mostrarMenu(){
        var opcion = -1;
        while (opcion != 0) {
            var menu =
         """
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

        private DatosLibro getDatosLibro() {
            System.out.println("Escribe el nombre del libro de Stephen King que deseas buscar");
            var nombreLibro = tipeo.nextLine();
            var json=consumoApi.obtenerDatos(URL_BASE );
            var datosBusqueda=conversor.obtenerDatos(json, DatosApi.class);
        // System.out.println(datosBusqueda);
        Optional<DatosLibro> libroBuscado=datosBusqueda.libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            DatosLibro libro = libroBuscado.get();
            //Libro libroEntidad = new Libro(libroBuscado); Lo usaremos para mas adelante guardar las busquedas realizadas

            System.out.println("Aca lo encontramos! ");

            System.out.println("+++++++++ LIBRO +++++++++" +
                    "\nTítulo: " + libro.titulo() +
                    "\nAño de lanzamiento: " + libro.fechaLanzamiento() +
                    "\nCantidad de Paginas: " + libro.cantPaginas()+
                    "\n");
        }else{
            System.out.println("Libro no encontrado");
    }
            return null;
        }

    private void mostrarLibrosBuscados() {
    }

    private void buscarLibro() {
    }}

