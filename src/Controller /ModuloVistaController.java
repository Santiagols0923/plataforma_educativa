package com.plataforma_educativa.educativa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModuloVistaController {

    /*
     * CU-MODULO | RF-12.8 | E12
     * MOSTRAR VISTA DE MÓDULOS EDUCATIVOS
     */
    @GetMapping("/modulo")
    public String mostrarVistaModulo() {

        /*
         * RETORNAR VISTA HTML
         * DEL PANEL DEL ESTUDIANTE
         */
        return "modulo";
    }
}
