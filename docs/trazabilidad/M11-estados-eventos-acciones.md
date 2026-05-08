
# M11 - Estados, Eventos y Acciones (Usuario)

| Estado Inicial | Evento / Disparador | Acción Realizada | Estado Final |
| :--- | :--- | :--- | :--- |
| **Inicial** | Registro de datos | `registrarUsuario()` | [cite_start]**Registrado** [cite: 866] |
| **Registrado** | Verificar email | [cite_start]`activarCuenta()` [cite: 868] | [cite_start]**Activo** [cite: 866] |
| **Activo** | Fallos consecutivos | [cite_start]`bloquearCuenta()` [cite: 868] | [cite_start]**Bloqueado** [cite: 866] |
| **Activo** | Olvido de clave | [cite_start]`generarToken()` [cite: 868] | [cite_start]**Recuperación** [cite: 866] |
