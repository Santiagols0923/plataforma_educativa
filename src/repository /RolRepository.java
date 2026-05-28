package com.plataforma_educativa.educativa.repository;

import com.plataforma_educativa.educativa.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    // No necesitas escribir nada más, Spring se encarga del resto.
}
