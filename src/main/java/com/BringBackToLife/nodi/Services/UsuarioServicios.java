package com.BringBackToLife.nodi.Services;

import com.BringBackToLife.nodi.Models.Usuario;
import com.BringBackToLife.nodi.Persistence.DAO.iDAO;
import com.BringBackToLife.nodi.Persistence.DAO.implement.UsuarioDAO;

import java.util.ArrayList;
import java.util.Collection;

public class UsuarioServicios implements CUD, iDAO<Usuario>{

    iDAO<Usuario> dao = new UsuarioDAO();

    @Override
    public boolean guardar(Usuario usuario) {
        return dao.guardar(usuario);
    }

    @Override
    public boolean eliminar(long id) {
        return dao.eliminar(id);
    }

    @Override
    public Usuario buscar(long id) {
        return dao.buscar(id);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return dao.actualizar(usuario);
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean agregarALaColeccion(Collection c, Object o) {
        return false;
    }

    @Override
    public boolean eliminarDeLaColeccion(Collection c, Object o) {
        return false;
    }

}
