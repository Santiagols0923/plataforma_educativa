package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.Usuario;
import com.plataforma_educativa.educativa.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    // INYECCIÓN DEL REPOSITORY DE USUARIOS
    @Autowired
    private UsuarioRepository repository;

    /*
     * CU-USUARIO | RF-12.3 | E12
     * LISTAR TODOS LOS USUARIOS
     */
    @GetMapping
    public List<Usuario> listar() {

        /*
         * CONSULTAR TODOS LOS USUARIOS
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-USUARIO | RF-12.4 | E12
     * GUARDAR NUEVO USUARIO
     */
    @PostMapping
    public Usuario guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody Usuario usuario) {

        /*
         * GUARDAR USUARIO
         * EN BASE DE DATOS
         */
        return repository.save(usuario);
    }

    /*
     * CU-USUARIO | RF-12.5 | E12
     * BUSCAR USUARIO POR ID
     */
    @GetMapping("/{id}")
    public Usuario buscar(

            // RECIBIR ID DEL USUARIO
            @PathVariable Integer id) {

        /*
         * CONSULTAR USUARIO
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-USUARIO | RF-12.6 | E12
     * ELIMINAR USUARIO
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL USUARIO
            @PathVariable Integer id) {

        /*
         * ELIMINAR USUARIO
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
