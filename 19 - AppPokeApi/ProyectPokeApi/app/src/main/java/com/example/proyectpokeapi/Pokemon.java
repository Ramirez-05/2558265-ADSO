package com.example.proyectpokeapi;

public class Pokemon {

    String nombre;
    String url;
    String id;

    public Pokemon(String nombre, String url, String id ) {
        this.nombre = nombre;
        this.url = url;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
