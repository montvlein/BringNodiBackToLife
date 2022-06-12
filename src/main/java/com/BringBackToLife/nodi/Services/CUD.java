package com.BringBackToLife.nodi.Services;

public interface CUD<T> {
    boolean agregarALaColeccion(T t);
    boolean eliminarDeLaColeccion(T t);
}
