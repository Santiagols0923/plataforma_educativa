package com.plataforma_educativa.educativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataforma_educativa.educativa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByCorreoAndContrasena(
        String correo,
        String contrasena);

        
       
}
