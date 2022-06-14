package com.BringBackToLife.nodi.Persistence.DAO.implement;

import com.BringBackToLife.nodi.Models.Usuario;
import com.BringBackToLife.nodi.Persistence.DAO.iDAO;

import java.util.ArrayList;

public class UsuarioDAO implements iDAO<Usuario> {

    @Override
    public boolean guardar(Usuario usuario) {
        return false;
    }

    @Override
    public boolean eliminar(long id) {
        return false;
    }

    @Override
    public Usuario buscar(long id) {
        return new Usuario();
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return new Usuario();
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        return null;
    }
}
