package com.BringBackToLife.nodi.Services;

import com.BringBackToLife.nodi.Models.Entities.Usuario;
import com.BringBackToLife.nodi.Persistence.ORM.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicios {

    private user_repository repository;

    @Autowired
    public void setRepository(user_repository repository) {
        this.repository = repository;
    }

    public boolean guardar(Usuario usuario) {
        boolean res = false;
        Usuario nuevoUsuario = repository.save(usuario);
        if (nuevoUsuario != null) {
            res = true;
        }
        return res;
    }

    public boolean eliminar(Long id) {
        boolean res = false;
        Usuario usuario = buscar(id);
        if (usuario != null) {
            repository.deleteById(id);
            res = true;
        }
        return res;
    }

    public Usuario buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario res = usuario;
        Usuario usuarioAActualizar = buscar(id);
        if (usuarioAActualizar != null) {
            repository.save(usuario);
            res = usuarioAActualizar;
        }
        return res;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

}
