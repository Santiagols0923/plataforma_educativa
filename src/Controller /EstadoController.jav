package com.plataforma_educativa.educativa.controller;

import com.plataforma_educativa.educativa.model.Estado;
import com.plataforma_educativa.educativa.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }
}

