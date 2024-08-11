package com.AdoptaUnJunior.demo.service;

public interface IConversorDatos {
    <T> T obtenerDatos(String json, Class <T> clase );
}
