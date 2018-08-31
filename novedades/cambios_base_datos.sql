-- Agregar una nueva columna de estado para manejar los clientes
ALTER TABLE cliente ADD COLUMN estado VARCHAR(1);
-- Modificar todos los clientes que fueron creados el campo estado con la palabra A de activo
UPDATE cliente SET estado='A' WHERE estado IS NULL;
