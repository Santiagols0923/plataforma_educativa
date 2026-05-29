package com.plataforma_educativa.educativa.controller;

import com.plataforma_educativa.educativa.model.EstadoUsuario;
import com.plataforma_educativa.educativa.model.Rol;
import com.plataforma_educativa.educativa.model.Usuario;
import com.plataforma_educativa.educativa.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    // INYECCIÓN DEL REPOSITORY DE USUARIOS
    @Autowired
    private UsuarioRepository usuarioRepository;

    /*
     * CU-REGISTRO | RF-12.1 | E13
     * MOSTRAR VISTA DE REGISTRO
     */
    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {

        /*
         * OBJETO VACÍO PARA
         * EL FORMULARIO THYMELEAF
         */
        model.addAttribute(
                "usuario",
                new Usuario());

        // RETORNAR VISTA HTML
        return "registro";
    }

    /*
     * CU-REGISTRO | RF-12.2 | E13
     * GUARDAR NUEVO ESTUDIANTE
     */
    @PostMapping("/guardar-registro")
    public String guardarRegistro(

            // DATOS RECIBIDOS DESDE EL FORMULARIO
            @ModelAttribute Usuario usuario) {

        /*
         * CREAR ROL ESTUDIANTE
         * ID_ROL = 2
         */
        Rol rol = new Rol();
        rol.setIdRol(2);

        /*
         * CREAR ESTADO ACTIVO
         * ID_ESTADO = 1
         */
        EstadoUsuario estado = new EstadoUsuario();
        estado.setIdEstado(1);

        /*
         * ASIGNAR ROL Y ESTADO
         * AL NUEVO USUARIO
         */
        usuario.setRol(rol);
        usuario.setEstado(estado);

        /*
         * GUARDAR USUARIO
         * EN BASE DE DATOS
         */
        usuarioRepository.save(usuario);

        // REDIRECCIÓN AL LOGIN
        return "redirect:/registro-login";
    }
}
