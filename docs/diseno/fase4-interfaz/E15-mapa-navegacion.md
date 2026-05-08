graph TD %% Inicio y Seguridad Inicio([Inicio / Landing Page]) --> Login[Inicio de Sesión] Login --> Auth{¿Qué Rol tiene?}

%% Flujo del Administrador
Auth -- Administrador --> DashAdmin[Panel de Administración]
DashAdmin --> GestionUsers[Gestión de Usuarios y Roles]
DashAdmin --> GestionContenido[Gestión de Contenido]

GestionUsers --> TablasMaestras[Maestras: Roles / Estados]
GestionContenido --> Cursos[Gestión de Cursos]
Cursos --> Modulos[Gestión de Módulos]
Modulos --> Ejercicios[Gestión de Ejercicios y Niveles]

%% Flujo del Estudiante
Auth -- Estudiante --> DashEst[Panel del Estudiante]
DashEst --> Perfil[Mi Perfil e Insignias]
DashEst --> MisCursos[Explorar Cursos Disponibles]

MisCursos --> VerModulos[Seleccionar Módulo]
VerModulos --> ResolverEj[Resolver Ejercicios]

ResolverEj --> Validacion{¿Respuesta Correcta?}
Validacion -- Sí --> Progreso[Actualizar Progreso y Resultados]
Progreso --> CheckInsignia{¿Logro Alcanzado?}
CheckInsignia -- Sí --> GanaInsignia[Asignar Nueva Insignia]

Validacion -- No --> Reintento[Ver Retroalimentación]

%% Estilos
style Inicio fill:#f9f,stroke:#333,stroke-width:4px
style Login fill:#bbf,stroke:#333,stroke-width:2px
style DashAdmin fill:#f96,stroke:#333,stroke-width:2px
style DashEst fill:#9f9,stroke:#333,stroke-width:2px
