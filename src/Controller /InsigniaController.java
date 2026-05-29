package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.Insignia;
import com.plataforma_educativa.educativa.repository.InsigniaRepository;

@RestController
@RequestMapping("/insignias")
@CrossOrigin("*")
public class InsigniaController {

    // INYECCIÓN DEL REPOSITORY DE INSIGNIAS
    @Autowired
    private InsigniaRepository repository;

    /*
     * CU-INSIGNIA | RF-12.17 | E12
     * LISTAR TODAS LAS INSIGNIAS
     */
    @GetMapping
    public List<Insignia> listar() {

        /*
         * CONSULTAR TODAS LAS INSIGNIAS
         * REGISTRADAS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-INSIGNIA | RF-12.18 | E12
     * GUARDAR NUEVA INSIGNIA
     */
    @PostMapping
    public Insignia guardar(

            // VALIDAR DATOS RECIBIDOS
            @Valid @RequestBody Insignia insignia) {

        /*
         * GUARDAR INSIGNIA
         * EN BASE DE DATOS
         */
        return repository.save(insignia);
    }

    /*
     * CU-INSIGNIA | RF-12.19 | E12
     * BUSCAR INSIGNIA POR ID
     */
    @GetMapping("/{id}")
    public Insignia buscar(

            // RECIBIR ID DE LA INSIGNIA
            @PathVariable Integer id) {

        /*
         * CONSULTAR INSIGNIA
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-INSIGNIA | RF-12.20 | E12
     * ELIMINAR INSIGNIA
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DE LA INSIGNIA
            @PathVariable Integer id) {

        /*
         * ELIMINAR INSIGNIA
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
