package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.OpcionRespuesta;
import com.plataforma_educativa.educativa.repository.OpcionRespuestaRepository;

@RestController
@RequestMapping("/opciones-respuesta")
@CrossOrigin("*")
public class OpcionRespuestaController {

    // INYECCIÓN DEL REPOSITORY DE OPCIONES DE RESPUESTA
    @Autowired
    private OpcionRespuestaRepository repository;

    /*
     * CU-OPCION-RESPUESTA | RF-12.29 | E12
     * LISTAR TODAS LAS OPCIONES DE RESPUESTA
     */
    @GetMapping
    public List<OpcionRespuesta> listar() {

        /*
         * CONSULTAR TODAS LAS OPCIONES
         * REGISTRADAS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-OPCION-RESPUESTA | RF-12.30 | E12
     * GUARDAR NUEVA OPCIÓN DE RESPUESTA
     */
    @PostMapping
    public OpcionRespuesta guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody OpcionRespuesta opcionRespuesta) {

        /*
         * GUARDAR OPCIÓN DE RESPUESTA
         * EN BASE DE DATOS
         */
        return repository.save(opcionRespuesta);
    }

    /*
     * CU-OPCION-RESPUESTA | RF-12.31 | E12
     * BUSCAR OPCIÓN DE RESPUESTA POR ID
     */
    @GetMapping("/{id}")
    public OpcionRespuesta buscar(

            // RECIBIR ID DE LA OPCIÓN
            @PathVariable Integer id) {

        /*
         * CONSULTAR OPCIÓN DE RESPUESTA
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-OPCION-RESPUESTA | RF-12.32 | E12
     * ELIMINAR OPCIÓN DE RESPUESTA
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DE LA OPCIÓN
            @PathVariable Integer id) {

        /*
         * ELIMINAR OPCIÓN DE RESPUESTA
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
