package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.Progreso;
import com.plataforma_educativa.educativa.repository.ProgresoRepository;

@RestController
@RequestMapping("/progresos")
@CrossOrigin("*")
public class ProgresoController {

    // INYECCIÓN DEL REPOSITORY DE PROGRESOS
    @Autowired
    private ProgresoRepository repository;

    /*
     * CU-PROGRESO | RF-12.33 | E12
     * LISTAR TODOS LOS PROGRESOS
     */
    @GetMapping
    public List<Progreso> listar() {

        /*
         * CONSULTAR TODOS LOS PROGRESOS
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-PROGRESO | RF-12.34 | E12
     * GUARDAR NUEVO PROGRESO
     */
    @PostMapping
    public Progreso guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody Progreso progreso) {

        /*
         * GUARDAR PROGRESO
         * EN BASE DE DATOS
         */
        return repository.save(progreso);
    }

    /*
     * CU-PROGRESO | RF-12.35 | E12
     * BUSCAR PROGRESO POR ID
     */
    @GetMapping("/{id}")
    public Progreso buscar(

            // RECIBIR ID DEL PROGRESO
            @PathVariable Integer id) {

        /*
         * CONSULTAR PROGRESO
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-PROGRESO | RF-12.36 | E12
     * ELIMINAR PROGRESO
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL PROGRESO
            @PathVariable Integer id) {

        /*
         * ELIMINAR PROGRESO
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
