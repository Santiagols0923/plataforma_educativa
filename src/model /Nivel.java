package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "NIVEL")
public class Nivel {
    @Id
    @Column(name = "id_nivel")
    private Integer idNivel;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Getters y Setters
    public Integer getIdNivel() { return idNivel; }
    public void setIdNivel(Integer idNivel) { this.idNivel = idNivel; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
