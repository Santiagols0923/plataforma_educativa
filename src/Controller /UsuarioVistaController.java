package com.plataforma_educativa.educativa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.plataforma_educativa.educativa.model.EstadoUsuario;
import com.plataforma_educativa.educativa.model.Usuario;
import com.plataforma_educativa.educativa.repository.EstadoUsuarioRepository;
import com.plataforma_educativa.educativa.repository.RolRepository;
import com.plataforma_educativa.educativa.repository.UsuarioRepository;

@Controller
public class UsuarioVistaController {

    // INYECCIÓN DEL REPOSITORY DE USUARIOS
    @Autowired
    private UsuarioRepository usuarioRepository;

    // INYECCIÓN DEL REPOSITORY DE ROLES
    @Autowired
    private RolRepository rolRepository;

    // INYECCIÓN DEL REPOSITORY DE ESTADOS
    @Autowired
    private EstadoUsuarioRepository estadoUsuarioRepository;

    /*
     * CU-USUARIO | RF-CRUD | E12
     * MOSTRAR VISTA DE USUARIOS
     */
    @GetMapping("/usuarios-vista")
    public String mostrarVista(Model model) {

        /*
         * OBJETO VACÍO PARA
         * EL FORMULARIO THYMELEAF
         */
        model.addAttribute(
                "usuario",
                new Usuario());

        /*
         * LISTAR TODOS LOS USUARIOS
         */
        model.addAttribute(
                "usuarios",
                usuarioRepository.findAll());

        /*
         * LISTAR TODOS LOS ROLES
         */
        model.addAttribute(
                "roles",
                rolRepository.findAll());

        /*
         * LISTAR TODOS LOS ESTADOS
         */
        model.addAttribute(
                "estados",
                estadoUsuarioRepository.findAll());

        return "usuarios";
    }

    /*
     * CU-USUARIO | RF-GUARDAR | E12
     * GUARDAR O ACTUALIZAR USUARIO
     */
    @PostMapping("/guardar-usuario")
    public String guardarUsuario(

            // DATOS RECIBIDOS DEL FORMULARIO
            @ModelAttribute Usuario usuario) {

        /*
         * GUARDAR USUARIO
         * EN BASE DE DATOS
         */
        usuarioRepository.save(usuario);

        return "redirect:/usuarios-vista";
    }

    /*
     * CU-USUARIO | RF-ELIMINAR | E12
     * ELIMINAR USUARIO
     */
    @GetMapping("/eliminar-usuario/{id}")
    public String eliminarUsuario(

            // RECIBIR ID DEL USUARIO
            @PathVariable Integer id) {

        /*
         * ELIMINAR USUARIO
         * DE LA BASE DE DATOS
         */
        usuarioRepository.deleteById(id);

        return "redirect:/usuarios-vista";
    }

    /*
     * CU-USUARIO | RF-EDITAR | E12
     * CARGAR DATOS DEL USUARIO
     * EN EL FORMULARIO
     */
    @GetMapping("/editar-usuario/{id}")
    public String editarUsuario(

            @PathVariable Integer id,
            Model model) {

        /*
         * BUSCAR USUARIO
         * POR ID
         */
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElse(null);

        /*
         * ENVIAR USUARIO
         * AL FORMULARIO
         */
        model.addAttribute(
                "usuario",
                usuario);

        /*
         * LISTAR USUARIOS
         */
        model.addAttribute(
                "usuarios",
                usuarioRepository.findAll());

        /*
         * LISTAR ROLES
         */
        model.addAttribute(
                "roles",
                rolRepository.findAll());

        /*
         * LISTAR ESTADOS
         */
        model.addAttribute(
                "estados",
                estadoUsuarioRepository.findAll());

        return "usuarios";
    }

    /*
     * CU-USUARIO | RF-CAMBIAR-ESTADO | E12
     * ACTIVAR O DESACTIVAR USUARIO
     */
    @GetMapping("/cambiar-estado/{id}")
    public String cambiarEstado(

            @PathVariable Integer id) {

        /*
         * BUSCAR USUARIO
         * POR ID
         */
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElse(null);

        if (usuario != null) {

            /*
             * SI EL USUARIO ESTÁ ACTIVO
             * CAMBIAR A INACTIVO
             */
            if (usuario.getEstado()
                    .getIdEstado() == 1) {

                EstadoUsuario estado =
                        new EstadoUsuario();

                estado.setIdEstado(2);

                usuario.setEstado(estado);

            } else {

                /*
                 * SI ESTÁ INACTIVO
                 * CAMBIAR A ACTIVO
                 */
                EstadoUsuario estado =
                        new EstadoUsuario();

                estado.setIdEstado(1);

                usuario.setEstado(estado);
            }

            /*
             * ACTUALIZAR USUARIO
             * EN BASE DE DATOS
             */
            usuarioRepository.save(usuario);
        }

        return "redirect:/usuarios-vista";
    }
}
