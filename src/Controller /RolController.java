package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.Rol;
import com.plataforma_educativa.educativa.repository.RolRepository;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RolController {

    // INYECCIÓN DEL REPOSITORY DE ROLES
    @Autowired
    private RolRepository repository;

    /*
     * CU-ROL | RF-12.18 | E12
     * LISTAR TODOS LOS ROLES
     */
    @GetMapping
    public List<Rol> listar() {

        /*
         * CONSULTAR TODOS LOS ROLES
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-ROL | RF-12.19 | E12
     * GUARDAR NUEVO ROL
     */
    @PostMapping
    public Rol guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody Rol rol) {

        /*
         * GUARDAR ROL
         * EN BASE DE DATOS
         */
        return repository.save(rol);
    }

    /*
     * CU-ROL | RF-12.20 | E12
     * BUSCAR ROL POR ID
     */
    @GetMapping("/{id}")
    public Rol buscar(

            // RECIBIR ID DEL ROL
            @PathVariable Integer id) {

        /*
         * CONSULTAR ROL
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-ROL | RF-12.21 | E12
     * ELIMINAR ROL
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL ROL
            @PathVariable Integer id) {

        /*
         * ELIMINAR ROL
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
