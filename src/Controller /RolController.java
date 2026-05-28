package com.plataforma_educativa.educativa.controller;

import com.plataforma_educativa.educativa.model.Rol;
import com.plataforma_educativa.educativa.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles") // Esta será la URL en tu navegador
public class RolController {

    @Autowired
    private RolRepository rolRepository; // "Inyectamos" el mensajero

    @GetMapping
    public List<Rol> listarTodosLosRoles() {
        // Llama al repository para que traiga todo de la tabla ROL
        return rolRepository.findAll();
    }
}
