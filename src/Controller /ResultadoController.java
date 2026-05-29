package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.plataforma_educativa.educativa.model.Resultado;
import com.plataforma_educativa.educativa.repository.ResultadoRepository;

@RestController
@RequestMapping("/resultados")
@CrossOrigin("*")
public class ResultadoController {

    // INYECCIÓN DEL REPOSITORY DE RESULTADOS
    @Autowired
    private ResultadoRepository repository;

    /*
     * CU-RESULTADO | RF-12.14 | E12
     * LISTAR TODOS LOS RESULTADOS
     */
    @GetMapping
    public List<Resultado> listar() {

        /*
         * CONSULTAR TODOS LOS RESULTADOS
         * REGISTRADOS EN LA BASE DE DATOS
         */
        return repository.findAll();
    }

    /*
     * CU-RESULTADO | RF-12.15 | E12
     * GUARDAR NUEVO RESULTADO
     */
    @PostMapping
    public Resultado guardar(

            // RECIBIR DATOS DEL RESULTADO
            @RequestBody Resultado resultado) {

        /*
         * GUARDAR RESULTADO
         * EN BASE DE DATOS
         */
        return repository.save(resultado);
    }

    /*
     * CU-RESULTADO | RF-12.16 | E12
     * BUSCAR RESULTADO POR ID
     */
    @GetMapping("/{id}")
    public Resultado buscar(

            // RECIBIR ID DEL RESULTADO
            @PathVariable Integer id) {

        /*
         * CONSULTAR RESULTADO
         * POR SU ID
         */
        return repository.findById(id).orElse(null);
    }

    /*
     * CU-RESULTADO | RF-12.17 | E12
     * ELIMINAR RESULTADO
     */
    @DeleteMapping("/{id}")
    public void eliminar(

            // RECIBIR ID DEL RESULTADO
            @PathVariable Integer id) {

        /*
         * ELIMINAR RESULTADO
         * DE LA BASE DE DATOS
         */
        repository.deleteById(id);
    }
}
