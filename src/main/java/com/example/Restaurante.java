package com.example;

public class Restaurante {

    private String nombre;
    private String direccion;

    public Restaurante(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString(){
        return String.format("El restaurante %s se encuentra en %s", nombre, direccion);
    }
    
}
