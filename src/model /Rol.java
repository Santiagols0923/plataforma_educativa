package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ROL") // Nombre exacto de la tabla en SQL Server
public class Rol {

    @Id
    @Column(name = "id_rol") // Nombre exacto de la columna PK en SQL
    private Integer idRol;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    // Getters y Setters
    public Integer getIdRol() { return idRol; }
    public void setIdRol(Integer idRol) { this.idRol = idRol; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
