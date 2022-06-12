package com.BringBackToLife.nodi.Models;

import java.util.ArrayList;
import java.util.Collection;

public class Grupo {
    private long ID;
    private String nombre;
    protected Collection<Evento> fechasImportantes = new ArrayList<>();
    protected Collection<Usuario> participantes = new ArrayList<>();

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
