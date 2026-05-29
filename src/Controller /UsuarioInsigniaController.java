package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.UsuarioInsignia;
import com.plataforma_educativa.educativa.repository.UsuarioInsigniaRepository;

@RestController
@RequestMapping("/usuario-insignia")
@CrossOrigin("*")
public class UsuarioInsigniaController {

    // INYECCIÓN DEL REPOSITORY DE USUARIO INSIGNIA
    @Autowired
    private UsuarioInsigniaRepository repository;

    /*
     * CU-USUARIO-INSIGNIA | RF-12.37 | E12
     * LISTAR TODOS LOS REGISTROS DE INSIGNIAS
     */
    @GetMapping
    public List<UsuarioInsignia> listar() {

        /*
         * CONSULTAR TODOS LOS REGISTROS
         * DE USUARIO INSIGNIA
         */
        return repository.findAll();
    }

    /*
     * CU-USUARIO-INSIGNIA | RF-12.38 | E12
     * GUARDAR NUEVA INSIGNIA DE USUARIO
     */
    @PostMapping
    public UsuarioInsignia guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody UsuarioInsignia usuarioInsignia) {

        /*
         * GUARDAR REGISTRO
         * EN BASE DE DATOS
         */
        return repository.save(usuarioInsignia);
    }

    /*
     * CU-USUARIO-INSIGNIA | RF-12.39 | E12
     * BUSCAR REGISTRO POR ID
     */
    @GetMapping("/{id}")
    public UsuarioInsignia buscar(

            // RECIBIR ID DEL REGISTRO
            @PathVariable Integer id) {

        /*
         * CONSULTAR REGISTRO
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-USUARIO-INSIGNIA | RF-12.40 | E12
     * ELIMINAR REGISTRO DE INSIGNIA
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL REGISTRO
            @PathVariable Integer id) {

        /*
         * ELIMINAR REGISTRO
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
