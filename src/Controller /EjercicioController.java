package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.Ejercicio;
import com.plataforma_educativa.educativa.repository.EjercicioRepository;

@RestController
@RequestMapping("/ejercicios")
@CrossOrigin("*")
public class EjercicioController {

    // INYECCIÓN DEL REPOSITORY DE EJERCICIOS
    @Autowired
    private EjercicioRepository repository;

    /*
     * CU-EJERCICIO | RF-12.12 | E12
     * LISTAR TODOS LOS EJERCICIOS
     */
    @GetMapping
    public List<Ejercicio> listar() {

        /*
         * CONSULTAR TODOS LOS EJERCICIOS
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-EJERCICIO | RF-12.13 | E12
     * GUARDAR NUEVO EJERCICIO
     */
    @PostMapping
    public Ejercicio guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody Ejercicio ejercicio) {

        /*
         * GUARDAR EJERCICIO
         * EN BASE DE DATOS
         */
        return repository.save(ejercicio);
    }

    /*
     * CU-EJERCICIO | RF-12.14 | E12
     * BUSCAR EJERCICIO POR ID
     */
    @GetMapping("/{id}")
    public Ejercicio buscar(

            // RECIBIR ID DEL EJERCICIO
            @PathVariable Integer id) {

        /*
         * CONSULTAR EJERCICIO
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-EJERCICIO | RF-12.15 | E12
     * ELIMINAR EJERCICIO
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL EJERCICIO
            @PathVariable Integer id) {

        /*
         * ELIMINAR EJERCICIO
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
