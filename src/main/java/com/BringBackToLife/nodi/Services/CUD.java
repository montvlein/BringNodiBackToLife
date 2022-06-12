package com.BringBackToLife.nodi.Services;

import java.util.Collection;

public interface CUD<T> {
    boolean agregarALaColeccion(Collection<T> c, T t);
    boolean eliminarDeLaColeccion(Collection<T> c, T t);
}
