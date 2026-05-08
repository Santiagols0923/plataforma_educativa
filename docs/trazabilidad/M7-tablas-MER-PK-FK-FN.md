

# M7 - Trazabilidad de Tablas y Normalización (3FN)

| Tabla | Clave Primaria (PK) | Clave Foránea (FK) | Nivel Normalización |
| :--- | :--- | :--- | :--- |
| [cite_start]**USUARIO** | id_usuario [cite: 648] [cite_start]| id_rol, id_estado [cite: 656, 657] | [cite_start]3FN (Sin dependencias transitivas) [cite: 609] |
| [cite_start]**EJERCICIO** | id_ejercicio [cite: 668] [cite_start]| id_nivel, id_modulo [cite: 673, 674] | [cite_start]3FN (Puntaje extraído a NIVEL) [cite: 610] |
| [cite_start]**RESULTADO** | id_resultado [cite: 686] [cite_start]| id_usuario, id_ejercicio [cite: 691, 692] | [cite_start]3FN (Validación dinámica) [cite: 613] |
| [cite_start]**PROGRESO** | id_progreso [cite: 696] [cite_start]| id_usuario, id_modulo [cite: 700, 701] | [cite_start]3FN (Dato calculado fuera) [cite: 614] |
