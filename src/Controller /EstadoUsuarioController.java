package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.EstadoUsuario;
import com.plataforma_educativa.educativa.repository.EstadoUsuarioRepository;

@RestController
@RequestMapping("/estado-usuarios")
@CrossOrigin("*")
public class EstadoUsuarioController {

    // INYECCIÓN DEL REPOSITORY DE ESTADOS DE USUARIO
    @Autowired
    private EstadoUsuarioRepository repository;

    /*
     * CU-ESTADO-USUARIO | RF-12.21 | E12
     * LISTAR TODOS LOS ESTADOS DE USUARIO
     */
    @GetMapping
    public List<EstadoUsuario> listar() {

        /*
         * CONSULTAR TODOS LOS ESTADOS
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-ESTADO-USUARIO | RF-12.22 | E12
     * GUARDAR NUEVO ESTADO DE USUARIO
     */
    @PostMapping
    public EstadoUsuario guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody EstadoUsuario estadoUsuario) {

        /*
         * GUARDAR ESTADO DE USUARIO
         * EN BASE DE DATOS
         */
        return repository.save(estadoUsuario);
    }

    /*
     * CU-ESTADO-USUARIO | RF-12.23 | E12
     * BUSCAR ESTADO DE USUARIO POR ID
     */
    @GetMapping("/{id}")
    public EstadoUsuario buscar(

            // RECIBIR ID DEL ESTADO
            @PathVariable Integer id) {

        /*
         * CONSULTAR ESTADO DE USUARIO
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-ESTADO-USUARIO | RF-12.24 | E12
     * ELIMINAR ESTADO DE USUARIO
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL ESTADO
            @PathVariable Integer id) {

        /*
         * ELIMINAR ESTADO DE USUARIO
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
