stateDiagram-v2
    [*] --> No_Autenticado
    No_Autenticado --> Autenticado: Login Exitoso (id_estado = 2)
    
    state Autenticado {
        [*] --> Explorando: Navega por CURSO / MODULO
        Explorando --> En_Ejercicio: Selecciona EJERCICIO
        
        state En_Ejercicio {
            [*] --> Esperando_Respuesta
            Esperando_Respuesta --> Evaluando: Envía OPCION_RESPUESTA
            Evaluando --> Fallido: es_correcta = false
            Fallido --> Esperando_Respuesta: Reintento
            Evaluando --> Exitoso: es_correcta = true
        }
        
        Exitoso --> Actualizando_Progreso: Registra en RESULTADO
        Actualizando_Progreso --> Verificando_Insignia
        Verificando_Insignia --> Premiado: Se crea registro en USUARIO_INSIGNIA
        Verificando_Insignia --> Explorando: Aún no cumple meta
        Premiado --> Explorando
    }
    
    Autenticado --> [*]: Logout

    
    ------------------------------------------------------------------------------------------------


    
    stateDiagram-v2
    [*] --> Admin_Autenticado: Login (id_rol = 1)
    
    state "Gestión de Usuarios" as Users {
        [*] --> Lista_Usuarios
        Lista_Usuarios --> Suspendiendo: Cambia id_estado a 'Inactivo'
        Suspendiendo --> Lista_Usuarios: Update USUARIO
        Lista_Usuarios --> Activando: Cambia id_estado a 'Activo'
        Activando --> Lista_Usuarios: Update USUARIO
    }
    
    state "Gestión de Contenido" as Content {
        [*] --> Creando_Curso: Inserta en CURSO
        Creando_Curso --> Agregando_Modulo: Inserta en MODULO
        Agregando_Modulo --> Configurando_Ejercicio: Define EJERCICIO y NIVEL
        Configurando_Ejercicio --> Publicado: estado = true
        Publicado --> Editando: Ajusta enunciado o puntaje_nivel
    }
    
    Admin_Autenticado --> Users
    Admin_Autenticado --> Content
    
    Users --> Admin_Autenticado: Regresar al Panel
    Content --> Admin_Autenticado: Regresar al Panel



# E14 - DIAGRAMA DE ESTADOS

## Plataforma Educativa Web - Aprendiendo a Dividir

---

# Tabla de Estados del Sistema

| Estado Actual         | Evento / Acción                 | Validación o Proceso                    | Nuevo Estado          |
| --------------------- | ------------------------------- | --------------------------------------- | --------------------- |
| Inicio del Sistema    | Usuario ingresa a la plataforma | Carga inicial del sistema               | No Registrado         |
| No Registrado         | Seleccionar “Registrarse”       | Mostrar formulario de registro          | Registrando Usuario   |
| Registrando Usuario   | Completar formulario            | Validar datos obligatorios              | Validando Registro    |
| Validando Registro    | Correo duplicado                | Mostrar error                           | Error Registro        |
| Validando Registro    | Datos válidos                   | Guardar usuario con rol estudiante (2)  | Usuario Registrado    |
| Error Registro        | Corregir datos                  | Nueva validación                        | Registrando Usuario   |
| Usuario Registrado    | Seleccionar “Iniciar sesión”    | Mostrar login                           | Iniciando Sesión      |
| Iniciando Sesión      | Ingresar correo y contraseña    | Validar credenciales                    | Validación de Rol     |
| Iniciando Sesión      | Credenciales incorrectas        | Mostrar mensaje de error                | Error Login           |
| Error Login           | Reintentar login                | Validar nuevamente                      | Iniciando Sesión      |
| Validación de Rol     | id_rol = 1                      | Redirección administrador               | Panel Administrador   |
| Validación de Rol     | id_rol = 2                      | Redirección estudiante                  | Panel Estudiante      |
| Panel Estudiante      | Seleccionar módulo              | Cargar contenido educativo              | Visualizando Módulo   |
| Visualizando Módulo   | Seleccionar ejercicio           | Mostrar ejercicio                       | Resolviendo Ejercicio |
| Resolviendo Ejercicio | Enviar respuesta                | Comparar con respuesta correcta         | Evaluando Resultado   |
| Evaluando Resultado   | Respuesta correcta              | Guardar resultado y actualizar progreso | Resultado Correcto    |
| Evaluando Resultado   | Respuesta incorrecta            | Guardar intento y retroalimentar        | Resultado Incorrecto  |
| Resultado Correcto    | Continuar                       | Mostrar siguiente actividad             | Panel Estudiante      |
| Resultado Incorrecto  | Reintentar                      | Mostrar nuevamente el ejercicio         | Resolviendo Ejercicio |
| Panel Administrador   | Gestionar usuarios              | CRUD visual usuarios                    | Gestión Usuarios      |
| Panel Administrador   | Gestionar resultados            | CRUD visual resultados                  | Gestión Resultados    |
| Gestión Usuarios      | Guardar cambios                 | Actualizar base de datos                | Panel Administrador   |
| Gestión Resultados    | Eliminar resultado              | Actualizar registros                    | Panel Administrador   |
| Panel Estudiante      | Cerrar sesión                   | Finalizar sesión                        | Fin Sesión            |
| Panel Administrador   | Cerrar sesión                   | Finalizar sesión                        | Fin Sesión            |
| Fin Sesión            | Salir del sistema               | Redirección al login                    | Estado Final          |

---

# Tabla de Relación con Casos de Uso

| Caso de Uso | Descripción                   | Estados Relacionados                                          |
| ----------- | ----------------------------- | ------------------------------------------------------------- |
| CU-16.1     | Registrar Usuario             | Registrando Usuario, Validando Registro                       |
| CU-16.6     | Acceder a contenido educativo | Panel Estudiante, Visualizando Módulo                         |
| CU-16.8     | Resolver ejercicios           | Resolviendo Ejercicio                                         |
| CU-16.9     | Evaluar resultados            | Evaluando Resultado, Resultado Correcto, Resultado Incorrecto |
| CU-16.12    | Gestionar usuarios            | Panel Administrador, Gestión Usuarios                         |

---

# Tabla de Relación con Requisitos Funcionales

| Requisito Funcional | Descripción                  | Estados Relacionados                     |
| ------------------- | ---------------------------- | ---------------------------------------- |
| RF-12.1             | Registro de usuarios         | Registrando Usuario                      |
| RF-12.8             | Acceso a contenido educativo | Panel Estudiante                         |
| RF-12.14            | Resolución de ejercicios     | Resolviendo Ejercicio                    |
| RF-12.15            | Retroalimentación inmediata  | Resultado Correcto, Resultado Incorrecto |
| RF-12.16            | Evaluación automática        | Evaluando Resultado                      |

---

# Tabla de Relación con la Base de Datos

| Tabla     | Función dentro del sistema             | Estados relacionados                     |
| --------- | -------------------------------------- | ---------------------------------------- |
| USUARIO   | Almacena estudiantes y administradores | Registro, Login                          |
| ROL       | Define permisos del usuario            | Validación de Rol                        |
| RESULTADO | Guarda respuestas y puntuaciones       | Resultado Correcto, Resultado Incorrecto |
| EJERCICIO | Contiene preguntas y respuestas        | Resolviendo Ejercicio                    |
| PROGRESO  | Registra avance del estudiante         | Resultado Correcto                       |
| MODULO    | Organiza contenidos educativos         | Visualizando Módulo                      |

---

# Tecnologías Relacionadas

| Tecnología     | Uso dentro del proyecto  |
| -------------- | ------------------------ |
| Spring Boot    | Backend y controladores  |
| Thymeleaf      | Vistas dinámicas         |
| SQL Server     | Base de datos            |
| JPA Repository | Persistencia de datos    |
| HTML/CSS       | Diseño visual            |
| MVC            | Arquitectura del sistema |

