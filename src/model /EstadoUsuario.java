package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTADO")
public class Estado {
    @Id
    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    // Getters y Setters
    public Integer getIdEstado() { return idEstado; }
    public void setIdEstado(Integer idEstado) { this.idEstado = idEstado; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
