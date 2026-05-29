package com.plataforma_educativa.educativa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.plataforma_educativa.educativa.model.EstadoUsuario;
import com.plataforma_educativa.educativa.repository.EstadoUsuarioRepository;

@RestController
@RequestMapping("/estado-usuarios")
@CrossOrigin("*")
public class EstadoUsuarioController {

    @Autowired
    private EstadoUsuarioRepository repository;

    @GetMapping
    public List<EstadoUsuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public EstadoUsuario guardar(@Valid @RequestBody EstadoUsuario estadoUsuario) {
        return repository.save(estadoUsuario);
    }

    @GetMapping("/{id}")
    public EstadoUsuario buscar(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
