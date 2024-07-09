-- PRIMERO ESTO
CREATE DATABASE adpcionmascotas;

USE adpcionmascotas;

-- UNA VEZ EJECUTADO, ESTO

INSERT INTO refugios (nombre, correo_electronico, telefono)
VALUES ('Refugio ian', 'refugioian@example.com', 123456789);

INSERT INTO refugios (nombre, correo_electronico, telefono)
VALUES ('Refugio Betsy', 'refugiobetsy@example.com', 987654321);

INSERT INTO refugios (nombre, correo_electronico, telefono)
VALUES ('Refugiooo', 'refugiooo@example.com', 934134152);

-- Insertar Mascota 1
INSERT INTO mascotas (nombre, especie, raza, descripcion, fecha_registro, refugio_id)
VALUES ('Bobby', 'Perro', 'Labrador', 'Perro juguetón y amigable', 20240623, 1);
