package com.plataforma_educativa.educativa.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.plataforma_educativa.educativa.model.Resultado;
import com.plataforma_educativa.educativa.repository.EjercicioRepository;
import com.plataforma_educativa.educativa.repository.ResultadoRepository;
import com.plataforma_educativa.educativa.repository.UsuarioRepository;

@Controller
public class ResultadoVistaController {

    // INYECCIÓN DEL REPOSITORY DE RESULTADOS
    @Autowired
    private ResultadoRepository resultadoRepository;

    // INYECCIÓN DEL REPOSITORY DE USUARIOS
    @Autowired
    private UsuarioRepository usuarioRepository;

    // INYECCIÓN DEL REPOSITORY DE EJERCICIOS
    @Autowired
    private EjercicioRepository ejercicioRepository;

    /*
     * CU-RESULTADO | RF-12.14 | E12
     * MOSTRAR CRUD VISUAL DE RESULTADOS
     */
    @GetMapping("/resultado-vista")
    public String mostrarVista(Model model) {

        /*
         * OBJETO VACÍO PARA
         * EL FORMULARIO THYMELEAF
         */
        model.addAttribute(
                "resultado",
                new Resultado());

        /*
         * LISTAR TODOS LOS RESULTADOS
         */
        model.addAttribute(
                "resultados",
                resultadoRepository.findAll());

        /*
         * LISTAR USUARIOS
         * PARA EL SELECT DEL FORMULARIO
         */
        model.addAttribute(
                "usuarios",
                usuarioRepository.findAll());

        /*
         * LISTAR EJERCICIOS
         * PARA EL SELECT DEL FORMULARIO
         */
        model.addAttribute(
                "ejercicios",
                ejercicioRepository.findAll());

        // RETORNAR VISTA HTML
        return "resultado";
    }

    /*
     * CU-RESULTADO | RF-12.15 | E12
     * GUARDAR RESULTADO DEL EJERCICIO
     */
    @PostMapping("/guardar-resultado")
    public String guardarResultado(

            // DATOS RECIBIDOS DESDE EL FORMULARIO
            @ModelAttribute Resultado resultado) {

        /*
         * GENERAR FECHA AUTOMÁTICA
         * DEL RESULTADO
         */
        resultado.setFecha(LocalDateTime.now());

        /*
         * GUARDAR RESULTADO
         * EN BASE DE DATOS
         */
        resultadoRepository.save(resultado);

        // REDIRECCIÓN A LA VISTA PRINCIPAL
        return "redirect:/resultado-vista";
    }

    /*
     * CU-RESULTADO | RF-12.16 | E12
     * ELIMINAR RESULTADO
     */
    @GetMapping("/eliminar-resultado/{id}")
    public String eliminarResultado(

            // RECIBIR ID DEL RESULTADO
            @PathVariable Integer id) {

        /*
         * ELIMINAR RESULTADO
         * POR ID
         */
        resultadoRepository.deleteById(id);

        // REDIRECCIÓN A LA VISTA PRINCIPAL
        return "redirect:/resultado-vista";
    }
}
