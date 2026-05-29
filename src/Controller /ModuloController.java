package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.Modulo;
import com.plataforma_educativa.educativa.repository.ModuloRepository;

@RestController
@RequestMapping("/modulos")
@CrossOrigin("*")
public class ModuloController {

    // INYECCIÓN DEL REPOSITORY DE MÓDULOS
    @Autowired
    private ModuloRepository repository;

    /*
     * CU-MODULO | RF-12.8 | E12
     * LISTAR TODOS LOS MÓDULOS
     */
    @GetMapping
    public List<Modulo> listar() {

        /*
         * CONSULTAR TODOS LOS MÓDULOS
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-MODULO | RF-12.9 | E12
     * GUARDAR NUEVO MÓDULO
     */
    @PostMapping
    public Modulo guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody Modulo modulo) {

        /*
         * GUARDAR MÓDULO
         * EN BASE DE DATOS
         */
        return repository.save(modulo);
    }

    /*
     * CU-MODULO | RF-12.10 | E12
     * BUSCAR MÓDULO POR ID
     */
    @GetMapping("/{id}")
    public Modulo buscar(

            // RECIBIR ID DEL MÓDULO
            @PathVariable Integer id) {

        /*
         * CONSULTAR MÓDULO
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-MODULO | RF-12.11 | E12
     * ELIMINAR MÓDULO
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL MÓDULO
            @PathVariable Integer id) {

        /*
         * ELIMINAR MÓDULO
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
