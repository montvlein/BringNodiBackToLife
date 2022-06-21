package com.BringBackToLife.nodi.Persistence.DAO.implement;

import com.BringBackToLife.nodi.Models.Usuario;
import com.BringBackToLife.nodi.Persistence.DAO.iDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UsuarioDAO implements iDAO<Usuario> {

    private final HashMap<Long, Usuario> datosEnMemoria = new HashMap<>();

    @Override
    public boolean guardar(Usuario usuario) {
        datosEnMemoria.put(usuario.getId(), usuario);
        return true;
    }

    @Override
    public boolean eliminar(long id) {
        datosEnMemoria.remove(id);
        return true;
    }

    @Override
    public Usuario buscar(long id) {
        return datosEnMemoria.get(id);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        datosEnMemoria.remove(usuario.getId());
        datosEnMemoria.put(usuario.getId(), usuario);
        return buscar(usuario.getId());
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        return new ArrayList<>(datosEnMemoria.values());
    }
}
