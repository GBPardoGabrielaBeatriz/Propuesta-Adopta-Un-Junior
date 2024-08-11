package com.AdoptaUnJunior.demo.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosVillanos(@JsonAlias("name") String nombre) {
}
