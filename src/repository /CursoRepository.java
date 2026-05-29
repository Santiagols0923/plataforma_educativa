package com.plataforma_educativa.educativa.repository;

import com.plataforma_educativa.educativa.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Aquí puedes agregar métodos de búsqueda personalizados si los necesitas
}
