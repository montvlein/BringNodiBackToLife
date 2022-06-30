package com.BringBackToLife.nodi.Models.Entities;

public class TipoDeEvento {

    private long id;
    private String nombre;

    public TipoDeEvento() {
    }

    public TipoDeEvento(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
