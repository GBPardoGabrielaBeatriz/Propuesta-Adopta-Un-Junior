package com.AdoptaUnJunior.demo.modelo;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

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

    //@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List<Villano> villanos;

    public Libro() {
    }

    public Libro(DatosLibro datos) {
        this.añoLanzamiento = datos.fechaLanzamiento();
        this.titulo = datos.titulo();
        this.cantPaginas = datos.cantPaginas();
    }

    public Libro(DatosApi datos) {
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", añoLanzamiento=" + añoLanzamiento +
                ", titulo='" + titulo + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }

    public Libro(Optional<DatosLibro> libroBuscado) {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }
    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getCantPaginas() {
        return cantPaginas;
    }
    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

}
