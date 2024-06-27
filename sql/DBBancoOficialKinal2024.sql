DROP DATABASE IF EXISTS BancoOficialKinal;
CREATE DATABASE BancoOficialKinal;

USE BancoOficialKinal;

-- Tabla Clientes
CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    correo_electronico VARCHAR(100) UNIQUE
);

-- Tabla Cuentas
CREATE TABLE Cuentas (
    id_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(20) UNIQUE NOT NULL,
    tipo_cuenta ENUM('Ahorros', 'Corriente', 'Plazo Fijo') NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL,
    fecha_apertura DATE NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Tabla Transacciones
CREATE TABLE Transacciones (
    id_transaccion INT AUTO_INCREMENT PRIMARY KEY,
    fecha_transaccion DATETIME NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    tipo_transaccion ENUM('Deposito', 'Retiro', 'Transferencia') NOT NULL,
    descripcion TEXT,
    id_cuenta INT,
    FOREIGN KEY (id_cuenta) REFERENCES Cuentas(id_cuenta)
);

-- Tabla Empleados
CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL
);

-- Tabla Sucursales
CREATE TABLE Sucursales (
    id_sucursal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    codigo_postal VARCHAR(10)
);

-- Tabla Préstamos
CREATE TABLE Prestamos (
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    monto DECIMAL(10, 2) NOT NULL,
    tasa_interes DECIMAL(5, 2) NOT NULL,
    fecha_aprobacion DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Tabla Pagos de Préstamos
CREATE TABLE PagosPrestamos (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    fecha_pago DATE NOT NULL,
    monto_pagado DECIMAL(10, 2) NOT NULL,
    metodo_pago VARCHAR(50) NOT NULL,
    numero_recibo VARCHAR(50) UNIQUE NOT NULL,
    id_prestamo INT,
    FOREIGN KEY (id_prestamo) REFERENCES Prestamos(id_prestamo)
);

-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(100) NOT NULL,
    apellido_usuario VARCHAR(100) NOT NULL,
    usuario_login VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

-- Tabla Proveedores
CREATE TABLE Proveedores (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nit VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15)
);

-- Tabla Productos
CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

-- Índices para optimizar las búsquedas
CREATE INDEX idx_id_cliente ON Clientes(id_cliente);
CREATE INDEX idx_id_cuenta ON Cuentas(id_cuenta);
CREATE INDEX idx_id_transaccion ON Transacciones(id_transaccion);
CREATE INDEX idx_id_empleado ON Empleados(id_empleado);
CREATE INDEX idx_id_sucursal ON Sucursales(id_sucursal);
CREATE INDEX idx_id_prestamo ON Prestamos(id_prestamo);
CREATE INDEX idx_id_pago ON PagosPrestamos(id_pago);
CREATE INDEX idx_id_usuario ON Usuarios(id_usuario);
CREATE INDEX idx_id_proveedor ON Proveedores(id_proveedor);
CREATE INDEX idx_id_producto ON Productos(id_producto);

DELIMITER //
CREATE PROCEDURE sp_AgregarCliente(
    IN nombre VARCHAR(100), 
    IN direccion VARCHAR(255), 
    IN telefono VARCHAR(15), 
    IN correo_electronico VARCHAR(100)
)
BEGIN
    INSERT INTO Clientes(nombre, direccion, telefono, correo_electronico) 
    VALUES (nombre, direccion, telefono, correo_electronico);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarClientes()
BEGIN
    SELECT * FROM Clientes;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarCliente(IN id INT)
BEGIN
    SELECT * FROM Clientes WHERE id_cliente = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarCliente(IN id INT)
BEGIN
    DELETE FROM Clientes WHERE id_cliente = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarCliente(
    IN id INT, 
    IN nombre VARCHAR(100), 
    IN direccion VARCHAR(255), 
    IN telefono VARCHAR(15), 
    IN correo_electronico VARCHAR(100)
)
BEGIN
    UPDATE Clientes 
    SET nombre = nombre, direccion = direccion, telefono = telefono, correo_electronico = correo_electronico
    WHERE id_cliente = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarCuenta(
    IN numero_cuenta VARCHAR(20), 
    IN tipo_cuenta ENUM('Ahorros', 'Corriente', 'Plazo Fijo'), 
    IN saldo DECIMAL(10, 2), 
    IN fecha_apertura DATE, 
    IN id_cliente INT
)
BEGIN
    INSERT INTO Cuentas(numero_cuenta, tipo_cuenta, saldo, fecha_apertura, id_cliente) 
    VALUES (numero_cuenta, tipo_cuenta, saldo, fecha_apertura, id_cliente);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarCuentas()
BEGIN
    SELECT * FROM Cuentas;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarCuenta(IN id INT)
BEGIN
    SELECT * FROM Cuentas WHERE id_cuenta = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarCuenta(IN id INT)
BEGIN
    DELETE FROM Cuentas WHERE id_cuenta = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarCuenta(
    IN id INT, 
    IN numero_cuenta VARCHAR(20), 
    IN tipo_cuenta ENUM('Ahorros', 'Corriente', 'Plazo Fijo'), 
    IN saldo DECIMAL(10, 2), 
    IN fecha_apertura DATE
)
BEGIN
    UPDATE Cuentas 
    SET numero_cuenta = numero_cuenta, tipo_cuenta = tipo_cuenta, saldo = saldo, fecha_apertura = fecha_apertura
    WHERE id_cuenta = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarTransaccion(
    IN fecha_transaccion DATETIME, 
    IN monto DECIMAL(10, 2), 
    IN tipo_transaccion ENUM('Deposito', 'Retiro', 'Transferencia'), 
    IN descripcion TEXT, 
    IN id_cuenta INT
)
BEGIN
    INSERT INTO Transacciones(fecha_transaccion, monto, tipo_transaccion, descripcion, id_cuenta) 
    VALUES (fecha_transaccion, monto, tipo_transaccion, descripcion, id_cuenta);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarTransacciones()
BEGIN
    SELECT * FROM Transacciones;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarTransaccion(IN id INT)
BEGIN
    SELECT * FROM Transacciones WHERE id_transaccion = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarTransaccion(IN id INT)
BEGIN
    DELETE FROM Transacciones WHERE id_transaccion = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarTransaccion(
    IN id INT, 
    IN fecha_transaccion DATETIME, 
    IN monto DECIMAL(10, 2), 
    IN tipo_transaccion ENUM('Deposito', 'Retiro', 'Transferencia'), 
    IN descripcion TEXT
)
BEGIN
    UPDATE Transacciones 
    SET fecha_transaccion = fecha_transaccion, monto = monto, tipo_transaccion = tipo_transaccion, descripcion = descripcion
    WHERE id_transaccion = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarEmpleado(
    IN nombre VARCHAR(100), 
    IN puesto VARCHAR(50), 
    IN fecha_contratacion DATE, 
    IN salario DECIMAL(10, 2)
)
BEGIN
    INSERT INTO Empleados(nombre, puesto, fecha_contratacion, salario) 
    VALUES (nombre, puesto, fecha_contratacion, salario);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarEmpleados()
BEGIN
    SELECT * FROM Empleados;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarEmpleado(IN id INT)
BEGIN
    SELECT * FROM Empleados WHERE id_empleado = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarEmpleado(IN id INT)
BEGIN
    DELETE FROM Empleados WHERE id_empleado = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarEmpleado(
    IN id INT, 
    IN nombre VARCHAR(100), 
    IN puesto VARCHAR(50), 
    IN fecha_contratacion DATE, 
    IN salario DECIMAL(10, 2)
)
BEGIN
    UPDATE Empleados 
    SET nombre = nombre, puesto = puesto, fecha_contratacion = fecha_contratacion, salario = salario
    WHERE id_empleado = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarSucursal(
    IN nombre VARCHAR(100), 
    IN direccion VARCHAR(255), 
    IN telefono VARCHAR(15), 
    IN codigo_postal VARCHAR(10)
)
BEGIN
    INSERT INTO Sucursales(nombre, direccion, telefono, codigo_postal) 
    VALUES (nombre, direccion, telefono, codigo_postal);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarSucursales()
BEGIN
    SELECT * FROM Sucursales;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarSucursal(IN id INT)
BEGIN
    SELECT * FROM Sucursales WHERE id_sucursal = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarSucursal(IN id INT)
BEGIN
    DELETE FROM Sucursales WHERE id_sucursal = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarSucursal(
    IN id INT, 
    IN nombre VARCHAR(100), 
    IN direccion VARCHAR(255), 
    IN telefono VARCHAR(15), 
    IN codigo_postal VARCHAR(10)
)
BEGIN
    UPDATE Sucursales 
    SET nombre = nombre, direccion = direccion, telefono = telefono, codigo_postal = codigo_postal
    WHERE id_sucursal = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarPrestamo(
    IN monto DECIMAL(10, 2), 
    IN tasa_interes DECIMAL(5, 2), 
    IN fecha_aprobacion DATE, 
    IN fecha_vencimiento DATE, 
    IN id_cliente INT
)
BEGIN
    INSERT INTO Prestamos(monto, tasa_interes, fecha_aprobacion, fecha_vencimiento, id_cliente) 
    VALUES (monto, tasa_interes, fecha_aprobacion, fecha_vencimiento, id_cliente);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarPrestamos()
BEGIN
    SELECT * FROM Prestamos;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarPrestamo(IN id INT)
BEGIN
    SELECT * FROM Prestamos WHERE id_prestamo = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarPrestamo(IN id INT)
BEGIN
    DELETE FROM Prestamos WHERE id_prestamo = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarPrestamo(
    IN id INT, 
    IN monto DECIMAL(10, 2), 
    IN tasa_interes DECIMAL(5, 2), 
    IN fecha_aprobacion DATE, 
    IN fecha_vencimiento DATE
)
BEGIN
    UPDATE Prestamos 
    SET monto = monto, tasa_interes = tasa_interes, fecha_aprobacion = fecha_aprobacion, fecha_vencimiento = fecha_vencimiento
    WHERE id_prestamo = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarPagoPrestamo(
    IN fecha_pago DATE, 
    IN monto_pagado DECIMAL(10, 2), 
    IN metodo_pago VARCHAR(50), 
    IN numero_recibo VARCHAR(50), 
    IN id_prestamo INT
)
BEGIN
    INSERT INTO PagosPrestamos(fecha_pago, monto_pagado, metodo_pago, numero_recibo, id_prestamo) 
    VALUES (fecha_pago, monto_pagado, metodo_pago, numero_recibo, id_prestamo);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarPagosPrestamos()
BEGIN
    SELECT * FROM PagosPrestamos;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarPagoPrestamo(IN id INT)
BEGIN
    SELECT * FROM PagosPrestamos WHERE id_pago = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarPagoPrestamo(IN id INT)
BEGIN
    DELETE FROM PagosPrestamos WHERE id_pago = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarPagoPrestamo(
    IN id INT, 
    IN fecha_pago DATE, 
    IN monto_pagado DECIMAL(10, 2), 
    IN metodo_pago VARCHAR(50), 
    IN numero_recibo VARCHAR(50)
)
BEGIN
    UPDATE PagosPrestamos 
    SET fecha_pago = fecha_pago, monto_pagado = monto_pagado, metodo_pago = metodo_pago, numero_recibo = numero_recibo
    WHERE id_pago = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarUsuario(
    IN nombre_usuario VARCHAR(100), 
    IN apellido_usuario VARCHAR(100), 
    IN usuario_login VARCHAR(50), 
    IN contrasena VARCHAR(50)
)
BEGIN
    INSERT INTO Usuarios(nombre_usuario, apellido_usuario, usuario_login, contrasena) 
    VALUES (nombre_usuario, apellido_usuario, usuario_login, SHA2(contrasena, 256));
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarUsuarios()
BEGIN
    SELECT * FROM Usuarios;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarUsuario(IN id INT)
BEGIN
    SELECT * FROM Usuarios WHERE id_usuario = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarUsuario(IN id INT)
BEGIN
    DELETE FROM Usuarios WHERE id_usuario = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarUsuario(
    IN id INT, 
    IN nombre_usuario VARCHAR(100), 
    IN apellido_usuario VARCHAR(100), 
    IN usuario_login VARCHAR(50), 
    IN contrasena VARCHAR(50)
)
BEGIN
    UPDATE Usuarios 
    SET nombre_usuario = nombre_usuario, apellido_usuario = apellido_usuario, usuario_login = usuario_login, contrasena = SHA2(contrasena, 256)
    WHERE id_usuario = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarProveedor(
    IN nit VARCHAR(10), 
    IN nombre VARCHAR(100), 
    IN direccion VARCHAR(255), 
    IN telefono VARCHAR(15)
)
BEGIN
    INSERT INTO Proveedores(nit, nombre, direccion, telefono) 
    VALUES (nit, nombre, direccion, telefono);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarProveedores()
BEGIN
    SELECT * FROM Proveedores;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarProveedor(IN id INT)
BEGIN
    SELECT * FROM Proveedores WHERE id_proveedor = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarProveedor(IN id INT)
BEGIN
    DELETE FROM Proveedores WHERE id_proveedor = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarProveedor(
    IN id INT, 
    IN nit VARCHAR(10), 
    IN nombre VARCHAR(100), 
    IN direccion VARCHAR(255), 
    IN telefono VARCHAR(15)
)
BEGIN
    UPDATE Proveedores 
    SET nit = nit, nombre = nombre, direccion = direccion, telefono = telefono
    WHERE id_proveedor = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_AgregarProducto(
    IN nombre_producto VARCHAR(100), 
    IN precio_unitario DECIMAL(10, 2), 
    IN stock INT, 
    IN categoria VARCHAR(100)
)
BEGIN
    INSERT INTO Productos(nombre_producto, precio_unitario, stock, categoria) 
    VALUES (nombre_producto, precio_unitario, stock, categoria);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ListarProductos()
BEGIN
    SELECT * FROM Productos;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_BuscarProducto(IN id INT)
BEGIN
    SELECT * FROM Productos WHERE id_producto = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_EliminarProducto(IN id INT)
BEGIN
    DELETE FROM Productos WHERE id_producto = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_ActualizarProducto(
    IN id INT, 
    IN nombre_producto VARCHAR(100), 
    IN precio_unitario DECIMAL(10, 2), 
    IN stock INT, 
    IN categoria VARCHAR(100)
)
BEGIN
    UPDATE Productos 
    SET nombre_producto = nombre_producto, precio_unitario = precio_unitario, stock = stock, categoria = categoria
    WHERE id_producto = id;
END//
DELIMITER ;

