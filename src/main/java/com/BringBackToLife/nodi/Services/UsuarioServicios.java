package com.BringBackToLife.nodi.Services;

import com.BringBackToLife.nodi.Models.Entities.Usuario;
import com.BringBackToLife.nodi.Persistence.DAO.iDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioServicios {

    private iDAO<Usuario> dao;

    @Autowired
    public void setDao(iDAO<Usuario> dao) {
        this.dao = dao;
    }

    public boolean guardar(Usuario usuario) {
        return dao.guardar(usuario);
    }

    public boolean eliminar(long id) {
        return dao.eliminar(id);
    }

    public Usuario buscar(long id) {
        return dao.buscar(id);
    }

    public Usuario actualizar(Usuario usuario) {
        return dao.actualizar(usuario);
    }

    public ArrayList<Usuario> listarTodos() {
        return dao.listarTodos();
    }

}
