package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.Nivel;
import com.plataforma_educativa.educativa.repository.NivelRepository;

@RestController
@RequestMapping("/niveles")
@CrossOrigin("*")
public class NivelController {

    // INYECCIÓN DEL REPOSITORY DE NIVELES
    @Autowired
    private NivelRepository repository;

    /*
     * CU-NIVEL | RF-12.25 | E12
     * LISTAR TODOS LOS NIVELES
     */
    @GetMapping
    public List<Nivel> listar() {

        /*
         * CONSULTAR TODOS LOS NIVELES
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-NIVEL | RF-12.26 | E12
     * GUARDAR NUEVO NIVEL
     */
    @PostMapping
    public Nivel guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody Nivel nivel) {

        /*
         * GUARDAR NIVEL
         * EN BASE DE DATOS
         */
        return repository.save(nivel);
    }

    /*
     * CU-NIVEL | RF-12.27 | E12
     * BUSCAR NIVEL POR ID
     */
    @GetMapping("/{id}")
    public Nivel buscar(

            // RECIBIR ID DEL NIVEL
            @PathVariable Integer id) {

        /*
         * CONSULTAR NIVEL
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-NIVEL | RF-12.28 | E12
     * ELIMINAR NIVEL
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL NIVEL
            @PathVariable Integer id) {

        /*
         * ELIMINAR NIVEL
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
