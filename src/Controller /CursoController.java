package com.plataforma_educativa.educativa.controller;

import com.plataforma_educativa.educativa.model.Curso;
import com.plataforma_educativa.educativa.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    // INYECCIÓN DEL REPOSITORY DE CURSOS
    @Autowired
    private CursoRepository cursoRepository;

    /*
     * CU-CURSO | RF-12.6 | E12
     * LISTAR TODOS LOS CURSOS
     */
    @GetMapping
    public List<Curso> listarCursos() {

        /*
         * CONSULTAR TODOS LOS CURSOS
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return cursoRepository.findAll();
    }

    /*
     * CU-CURSO | RF-12.7 | E12
     * GUARDAR NUEVO CURSO
     */
    @PostMapping
    public Curso guardarCurso(

            // RECIBIR DATOS DEL CURSO
            @RequestBody Curso curso) {

        /*
         * GUARDAR CURSO
         * EN BASE DE DATOS
         */
        return cursoRepository.save(curso);
    }
}
