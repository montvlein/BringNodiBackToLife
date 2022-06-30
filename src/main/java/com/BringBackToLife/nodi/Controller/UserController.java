package com.BringBackToLife.nodi.Controller;

import com.BringBackToLife.nodi.Models.Entities.Usuario;
import com.BringBackToLife.nodi.Services.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/user/")
public class UserController {

    private UsuarioServicios servicio;

    @Autowired
    public void setServicio(UsuarioServicios servicio) {
        this.servicio = servicio;
    }

    @GetMapping("{userID}")
    @ResponseBody
    public ResponseEntity<Usuario> perfilDeUsuario(@PathVariable long userID) {
        ResponseEntity<Usuario> response;
        Usuario user = servicio.buscar(userID);
        if (user != null) {
            try {
                response = ResponseEntity.ok(user);
            } catch (Exception ex) {
                response = ResponseEntity.badRequest().body(null);
            }
        }
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario user) {
        ResponseEntity<Usuario> response;
        if (servicio.guardar(user)) {
            try {
                response = ResponseEntity.ok(servicio.buscar(user.getId()));
            } catch (Exception ex) {
                response = ResponseEntity.badRequest().body(null);
            }
        }
        else
            response = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

        return response;
    }

    @PutMapping("{userID}")
    @ResponseBody
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario u) {
        ResponseEntity<Usuario> response;
        Usuario user = servicio.actualizar(u);
        if (user != null) {
            try {
                response = ResponseEntity.ok(user);
            } catch (Exception ex) {
                response = ResponseEntity.badRequest().body(null);
            }
        }
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("{userID}")
    @ResponseBody
    public ResponseEntity<String> eliminarUsuario(@PathVariable long userID) {
        ResponseEntity<String> response;

        if (servicio.buscar(userID) != null) {
            servicio.eliminar(userID);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Usuario>> listar(){
        return ResponseEntity.ok(servicio.listarTodos());
    }

}
