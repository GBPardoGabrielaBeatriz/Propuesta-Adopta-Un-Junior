package com.AdoptaUnJunior.demo.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("Year") Integer fechaLanzamiento,
        @JsonAlias("Title") String titulo,
        @JsonAlias("Pages") int cantPaginas

) {
}
