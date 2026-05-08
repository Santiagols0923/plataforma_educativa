

# M8 - Script DDL vs Modelo Relacional vs Restricciones

| Tabla / Objeto DDL | Restricción Técnica | Justificación en el Modelo |
| :--- | :--- | :--- |
| **USUARIO** | [cite_start]NOT NULL [cite: 1190] | [cite_start]Integridad de datos obligatorios[cite: 647]. |
| **CREDENCIALES** | [cite_start]UNIQUE [cite: 1190] | [cite_start]Evitar duplicidad de cuentas de acceso[cite: 1190]. |
| **PROGRESO** | [cite_start]FOREIGN KEY válida [cite: 1190] | [cite_start]Garantizar que el avance pertenezca a un usuario real[cite: 700]. |
| **ROL** | NOT NULL / UNIQUE | [cite_start]Control estricto de tipos de usuario[cite: 621]. |
