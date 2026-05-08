DDL

-- 1. Tabla ROL (Independiente)
CREATE TABLE ROL (
    id_rol INT(10) NOT NULL  PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- 2. ESTADO_USUARIO (Para control de valores)
CREATE TABLE ESTADO_USUARIO (
    id_estado INT(10) NOT NULL PRIMARY KEY,
    nombre_estado VARCHAR(25) NOT NULL
);

-- 3. Tabla CURSO
CREATE TABLE CURSO (
    id_curso INT(10) NOT NULL  PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);

-- 4. Tabla NIVEL (Ahora incluye el puntaje por 3FN)
CREATE TABLE NIVEL (
    id_nivel INT(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(25) NOT NULL,
    descripcion VARCHAR(50),
    puntaje_nivel INT(10) NOT NULL
);

-- 5. Tabla INSIGNIA
CREATE TABLE INSIGNIA (
    id_insignia INT(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- 6. Tabla USUARIO (Corregida: identificacion única y id_estado FK)
CREATE TABLE USUARIO (
    id_usuario INT(10) NOT NULL  PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    identificacion VARCHAR(20) NULL, 
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    id_rol INT(10) NOT NULL,
    id_estado INT(10) NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES ROL(id_rol),
    FOREIGN KEY (id_estado) REFERENCES ESTADO_USUARIO(id_estado)
);
-- 7. Tabla MODULO
CREATE TABLE MODULO (
    id_modulo INT(10) NOT NULL  PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_curso INT(10) NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES CURSO(id_curso)
);

-- 8. Tabla EJERCICIO (Sin puntaje_otorgado por redundancia)
CREATE TABLE EJERCICIO (
    id_ejercicio INT(10) NOT NULL PRIMARY KEY,
    enunciado varchar(50) NOT NULL,
    id_nivel INT(10) NOT NULL,
    estado BOOLEAN NOT NULL,
    id_modulo INT(10) NOT NULL,
    FOREIGN KEY (id_nivel) REFERENCES NIVEL(id_nivel),
    FOREIGN KEY (id_modulo) REFERENCES MODULO(id_modulo)
);

-- 9. Tabla OPCION_RESPUESTA
CREATE TABLE OPCION_RESPUESTA (
    id_opcion INT(10) NOT NULL PRIMARY KEY,
    id_ejercicio INT(10) NOT NULL,
   respuesta_opcion INT(3) NOT NULL,
    es_correcta BOOLEAN NOT NULL,
    FOREIGN KEY (id_ejercicio) REFERENCES EJERCICIO(id_ejercicio)
);

-- 10. Tabla RESULTADO (Sin es_correcta por redundancia)
CREATE TABLE RESULTADO (
    id_resultado INT(10) NOT NULL PRIMARY KEY,
    id_usuario INT(10) NOT NULL,
    id_ejercicio INT(10) NOT NULL,
    respuesta_usuario  INT(3) NOT NULL,
    fecha DATETIME NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (id_ejercicio) REFERENCES EJERCICIO(id_ejercicio)
);

-- 11. Tabla PROGRESO (Sin campo porcentaje por ser dato calculado)
CREATE TABLE PROGRESO (
    id_progreso INT(10) NOT NULL PRIMARY KEY,
    id_usuario INT(10) NOT NULL,
    id_modulo INT(10) NOT NULL,
    fecha_actualizacion DATETIME NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (id_modulo) REFERENCES MODULO(id_modulo)
);

-- 12. Tabla USUARIO_INSIGNIA
CREATE TABLE USUARIO_INSIGNIA (
    id_usuario_insignia INT(10) NOT NULL PRIMARY KEY,
    id_usuario INT(10) NOT NULL,
    id_insignia INT(10) NOT NULL,
    fecha_optenida DATETIME NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (id_insignia) REFERENCES INSIGNIA(id_insignia)
);
