
### FASE 1 → Estructura del Proyecto

| Artefacto de Diseño | Lo que genera en el Framework |
| :--- | :--- |
| **E5 - Diagrama de Componentes** | [cite_start]Define la estructura de carpetas y paquetes del proyecto Spring Boot, organizando el código en `controller`, `model` y `repository`. |
| **E6 - Diagrama de Despliegue** | [cite_start]Establece la configuración del entorno en `application.properties`, incluyendo la conexión al puerto 8080/8081 y las variables para el servidor SQL Server. |
| **E4 - Arquetipos** | [cite_start]Determina los nombres de las clases de entidad (`Usuario`, `Rol`, `Nivel`, `Curso`), así como la estructura de los modelos y servicios RESTful. |

### FASE 2 → Capa de Datos

| Artefacto de Diseño | Lo que genera en el Framework |
| :--- | :--- |
| **E11 - Script DDL** | [cite_start]Creación física de las 12 tablas en SQL Server, definiendo tipos de datos, llaves primarias y foráneas para la persistencia [cite: 18-112]. |
| **E9-E10 - Modelo Relacional** | [cite_start]Estructura lógica que se traduce en clases `@Entity` de Java, permitiendo la comunicación entre el objeto y la tabla mediante JPA [cite: 17, 48-112]. |
| **E7 - Diccionario de Datos** | [cite_start]Define las validaciones y restricciones técnicas (como `@Column`) y tipos de variables (String, Integer) en los modelos [cite: 1-15, 48-112]. |
| **E8 - MER** | [cite_start]Determina la cardinalidad y lógica de las relaciones que se implementan en el código mediante anotaciones como `@ManyToOne` [cite: 16, 48-112]. |

### FASE 3 → Lógica de Negocio

| Artefacto de Diseño | Lo que genera en el Framework |
| :--- | :--- |
| **E12 - Diagrama de Clases** | [cite_start]Estructura de Clases de Entidad, Interfaces de Repositorios y lógica de Servicios en el backend . |
| **E13 - Diagramas de Secuencia** | [cite_start]Define el flujo de los métodos en los Controladores y la interacción entre servicios para procesar peticiones . |
| **E14 - Diagrama de Estados** | [cite_start]Determina los campos de estado en la base de datos (como en `ESTADO_USUARIO`) y la lógica para transiciones de procesos . |
