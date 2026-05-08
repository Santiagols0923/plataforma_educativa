
# Registro de Decisiones Arquitectónicas (ADR) - Plataforma Educativa






## 1. Motor de Base de Datos y Driver de Conexión
**Decisión:** Uso de **Microsoft SQL Server 2022** y driver **JDBC (mssql-jdbc)**.
**Sustentación:** Se eligió por su capacidad para manejar integridad referencial compleja y su compatibilidad con entornos empresariales. Se tomó la decisión técnica de habilitar protocolos TCP/IP estáticos en el puerto 1433 para garantizar que el framework Spring Boot localice la instancia de forma determinista.

## 2. Gestión de Dependencias
**Decisión:** Uso de **Maven**.
**Sustentación:** Se seleccionó Maven para automatizar la descarga de librerías y la construcción del proyecto (Build). El archivo `pom.xml` centraliza las dependencias de Spring Data JPA, Spring Web y el driver de SQL Server, asegurando que el entorno sea replicable en otros equipos.

## 3. Mapeo Objeto-Relacional (ORM)
**Decisión:** Implementación de **Spring Data JPA / Hibernate**.
**Sustentación:** Para optimizar el tiempo de desarrollo, se decidió abstraer las consultas SQL manuales. Mediante el uso de `@Entity`, las tablas `ROL`, `NIVEL` y `ESTADO` se manejan como objetos Java, delegando a Hibernate la creación y actualización de esquemas.

## 4. Seguridad de Acceso a Datos
**Decisión:** Configuración de **Autenticación Mixta** y usuario de servicio.
**Sustentación:** Se descartó el uso de Autenticación de Windows para evitar problemas de permisos de sistema operativo. Se habilitó el usuario `sa` con una política de contraseñas específica para permitir que la aplicación se autentique de forma independiente.
