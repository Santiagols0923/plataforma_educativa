package com.plataforma_educativa.educativa.controller;

import com.plataforma_educativa.educativa.model.Usuario;
import com.plataforma_educativa.educativa.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    // INYECCIÓN DEL REPOSITORY DE USUARIOS
    @Autowired
    private UsuarioRepository usuarioRepository;

    /*
     * CU-LOGIN | RF-12.1 | E13
     * MOSTRAR VISTA LOGIN Y REGISTRO
     */
    @GetMapping("/registro-login")
    public String mostrarLogin() {

        return "login";
    }

    /*
     * CU-LOGIN | RF-12.2 | E13
     * VALIDAR INICIO DE SESIÓN
     */
    @PostMapping("/login")
    public String iniciarSesion(

            // DATOS RECIBIDOS DESDE EL FORMULARIO
            @RequestParam String correo,
            @RequestParam String contrasena,

            // ENVÍO DE MENSAJES A LA VISTA
            Model model) {

        /*
         * CONSULTA DE USUARIO POR
         * CORREO Y CONTRASEÑA
         */
        Usuario usuario = usuarioRepository
                .findByCorreoAndContrasena(
                        correo,
                        contrasena);

        // VALIDACIÓN DE EXISTENCIA DEL USUARIO
        if (usuario != null) {

            /*
             * VALIDACIÓN DE ROL ADMINISTRADOR
             * ROL = 1
             */
            if (usuario.getRol().getIdRol() == 1) {

                // REDIRECCIÓN A CRUD DE USUARIOS
                return "redirect:/usuarios-vista";
            }

            /*
             * VALIDACIÓN DE ROL ESTUDIANTE
             * ROL = 2
             */
            else if (usuario.getRol().getIdRol() == 2) {

                // REDIRECCIÓN A MÓDULOS EDUCATIVOS
                return "redirect:/modulo";
            }
        }

        /*
         * MENSAJE DE ERROR SI
         * LAS CREDENCIALES SON INCORRECTAS
         */
        model.addAttribute(
                "error",
                "Correo o contraseña incorrectos");

        // RETORNAR NUEVAMENTE AL LOGIN
        return "login";
    }
}


