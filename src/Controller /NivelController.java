package com.plataforma_educativa.educativa.controller;

import com.plataforma_educativa.educativa.model.Nivel;
import com.plataforma_educativa.educativa.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/niveles")
public class NivelController {
    @Autowired
    private NivelRepository nivelRepository;

    @GetMapping
    public List<Nivel> listar() {
        return nivelRepository.findAll();
    }
}
