-- Agregar una nueva columna de estado para manejar los clientes
ALTER TABLE cliente ADD COLUMN estado VARCHAR(1);
-- Modificar todos los clientes que fueron creados el campo estado con la palabra A de activo
UPDATE cliente SET estado='A' WHERE estado IS NULL;

-- Agregar campo para grabar el usuario que ingreso el dato 
ALTER TABLE poliza ADD COLUMN USUARIO_INGRESO VARCHAR(64);
-- Modificar todos los usuario de ingreso  con valores vacios
UPDATE poliza SET USUARIO_INGRESO='' WHERE USUARIO_INGRESO IS NULL;