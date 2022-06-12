package com.BringBackToLife.nodi.Persistence;

import java.util.ArrayList;

public interface iDAO<T> {

    boolean guardar(T t);
    boolean eliminar(long id);
    T buscar(long id);
    T actualizar(T t);
    ArrayList<T> listarTodos();
}
