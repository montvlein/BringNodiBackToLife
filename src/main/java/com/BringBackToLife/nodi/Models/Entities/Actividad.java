package com.BringBackToLife.nodi.Models.Entities;

import java.util.Collection;
import java.util.ArrayList;

// Esta clase se penso en un momento primer momento para agrupar eventos y encapsularse en los Grupos.
// Pero por una cuestion de simplicidad, los Grupos guardan tienen una coleccion de Eventos. Dejando a esta clase sin uso.
public class Actividad {
    private long ID;
    private String nombre;
    private long ID_interes;
    protected Collection<Evento> eventos = new ArrayList<>();

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setID_interes(long ID_interes) {
        this.ID_interes = ID_interes;
    }

    public long getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public long getID_interes() {
        return ID_interes;
    }

}
