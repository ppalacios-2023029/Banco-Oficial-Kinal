Drop database if exists DBBancoOficialKinal;
Drop database if exists DBBancoOficialKinal;
create database DBBancoOficialKinal;

use DBBancoOficialKinal;

create table TipoCuenta(
	codigoTipoCuenta int not null auto_increment,
    TipoCuenta varchar(45) not null,
    SaldoMinimoRequerido double(10,2) not null,
    TasaDeInteres double(10,2) not null,
    TazaDeImpuestos double(10,2) not null,
    estado varchar(1) not null,
    primary key PK_codigoTipoCuenta(codigoTipoCuenta)
);

create table Clientes(
	codigoCliente int not null auto_increment,
    nombreCliente varchar(20) not null,
    apellidoCliente varchar(20) not null,
    direccionCliente varchar(60) not null,
    telefonoCliente varchar(8) not null,
    correoCliente varchar(20) not null,
    descripcion varchar(100) not null,
    codigoTipoCuenta int not null,
    estado varchar(1) not null,
    primary key PK_codigoCliente(codigoCliente),
    constraint FK_Clientes_TipoCuenta foreign key(codigoTipoCuenta) references TipoCuenta(codigoTipoCuenta)
);

create table CargoEmpleado (
    codigoCargoEmpleado int not null auto_increment,
    nombreCargo varchar(50) not null,
    descripcion text,
    salarioBase decimal(10,2) default 0.00,
    nivelJerarquico int,
    estado varchar(1) not null,
    primary key PK_codigoCargoEmpleado(codigoCargoEmpleado)
);


create table Empleados (
    codigoEmpleado int not null auto_increment,
    nombreEmpleado varchar(50) not null,
    apellidoEmpleado varchar(50) not null,
    usuario varchar(10) not null,
    contrasena varchar(10) not null,
    cargo varchar(50) not null,
    salario DECIMAL(10, 2) NOT NULL,
    oficina VARCHAR(50) NOT NULL,
    estado varchar(1) not null,
    codigoCargoEmpleado int,
    primary key PK_codigoEmpleado(codigoEmpleado),
    constraint FK_Empleados_CargoEmpleado foreign key (codigoCargoEmpleado) references CargoEmpleado(codigoCargoEmpleado)
);

create table Sucursales (
    codigoSucursal int not null auto_increment,
    nombreSucursal varchar(100) not null,
    direccionSucursal varchar(255),
    telefono varchar(20),
    correoSucursal varchar(20) not null,
    estado varchar(1) not null,
    codigoEmpleado int,
    primary key PK_codigoSucursal(codigoSucursal),
    constraint FK_Sucursales_Empleados foreign key (codigoEmpleado) references Empleados(codigoEmpleado)
);

create table Transaccion(
	codigoTransaccion INT not null AUTO_INCREMENT,
    estadoTransaccion VARCHAR(20) NOT NULL,
    TipoTransaccion VARCHAR(20) NOT NULL,
    Monto DECIMAL(10, 2) NOT NULL,
    Fecha DATE NOT NULL,
    estado varchar(1) not null,
    codigoCliente int not null,
    primary key PK_codigoTransaccion(codigoTransaccion),
	constraint FK_Transaccion_Clientes foreign key(codigoCliente) references Clientes(codigoCliente)
);

create table Prestamos (
    codigoPrestamo int not null auto_increment,
    monto decimal(10,2) not null,
    tipoPrestamo varchar(50) not null, -- Personal, empresa, organisacion
    tasaInteres decimal(5, 2) not null,	-- Trigger dependiendo el tipo de prestamo
    fechaInicio date not null,
    fechaVencimiento date not null,
    estado varchar(1) not null,
    codigoCliente int not null,
    primary key PK_codigoPrestamo(codigoPrestamo),
    constraint FK_Prestamos_Clientes foreign key(codigoCliente) references Clientes(codigoCliente)
);

create table PagosPrestamos (
    codigoPagos int not null auto_increment,
    monto decimal(10,2) not null,
    fechaInicio date not null,
    fechaVencimiento date not null,
    estadoPago varchar(50) not null,
    codigoPrestamo int not null,
    primary key PK_codigoPagos(codigoPagos),
    constraint FK_PagosPrestamos_Prestamos foreign key(codigoPrestamo) references Prestamos(codigoPrestamo)
);

create table Tarjetas (
    numeroTarjeta varchar(19) not null, -- Crear una numero de cuenta falso de xxxx-xxxx-xxxx-xxxx
    tipoTarjeta varchar(50) not null,
    CVC varchar(3) not null,
    fechaVencimiento date not null,
    fechaEmision date not null,
    limiteDeCredito decimal(15, 2), -- Depende del tipo de tarjeta
    estado varchar(1) not null,
    codigoCliente int not null,
    primary key PK_numeroTarjeta(numeroTarjeta),
    constraint FK_Tarjetas_Clientes foreign key(codigoCliente) references Clientes(codigoCliente)
);

create table Seguro(
	numeroSeguro int not null auto_increment,
    numeroPoliza varchar(20) not null,
    tipoSeguro varchar(20) not null,
    montoAsegurado double(10, 2) not null,
    primaMensual double(10, 2) not null,
    fechaExpiracion varchar(20) not null,
    estado varchar(1) not null,
    codigoCliente int not null,
    primary key PK_numeroSeguro(numeroSeguro),
    constraint FK_Seguro_Clientes foreign key(codigoCliente) references Clientes(codigoCliente)
);

create table DetalleCuenta (
    codigoDetalleCuenta int not null auto_increment,
    fechaDetalle date not null,
    tipoOperacion varchar(20) not null,
    estadoCuenta varchar(20) not null,
    codigoCliente int,
    codigoEmpleado int,
    codigoSucursal int,
    primary key PK_codigoDetalleCuenta(codigoDetalleCuenta),
    constraint FK_DetalleCuenta_Clientes foreign key(codigoCliente) references Clientes(codigoCliente),
    constraint FK_DetalleCuenta_Empleados foreign key(codigoEmpleado) references Empleados(codigoEmpleado),
    constraint FK_DetalleCuenta_Sucursales foreign key(codigoSucursal) references Sucursales(codigoSucursal)
);

INSERT INTO TipoCuenta (TipoCuenta, SaldoMinimoRequerido, TasaDeInteres, TazaDeImpuestos, estado) VALUES ('Cuenta Corriente', 500.00, 0.50, 0.15, 'A');
INSERT INTO TipoCuenta (TipoCuenta, SaldoMinimoRequerido, TasaDeInteres, TazaDeImpuestos, estado) Values ('Cuenta de Ahorro', 200.00, 1.20, 0.10, 'A');
INSERT INTO TipoCuenta (TipoCuenta, SaldoMinimoRequerido, TasaDeInteres, TazaDeImpuestos, estado) Values ('Cuenta Empresarial', 1000.00, 0.80, 0.20, 'I');

INSERT INTO Clientes (nombreCliente, apellidoCliente, direccionCliente, telefonoCliente, correoCliente, descripcion, codigoTipoCuenta, estado) 
	VALUES ('Juan', 'Pérez', 'Calle Falsa 123', '12345678', 'jperez@email.com', 'Cliente interesado en cuentas de ahorro', 2, 'A');
INSERT INTO Clientes (nombreCliente, apellidoCliente, direccionCliente, telefonoCliente, correoCliente, descripcion, codigoTipoCuenta, estado) 
	VALUES ('María', 'González', 'Avenida Siempre Viva 456', '87654321', 'mgonzalez@email.com', 'Cliente empresarial', 3, 'A');
INSERT INTO Clientes (nombreCliente, apellidoCliente, direccionCliente, telefonoCliente, correoCliente, descripcion, codigoTipoCuenta, estado) 
	VALUES('Carlos', 'Ramírez', 'Boulevard de los Sueños 789', '11223344', 'cramirez@email.com', 'Cliente con cuenta corriente', 1, 'I');
    
INSERT INTO CargoEmpleado (nombreCargo, descripcion, salarioBase, nivelJerarquico, estado) VALUES ('Gerente General', 'Responsable de la gestión y dirección de la empresa.', 5000.00, 1, '0');
INSERT INTO CargoEmpleado (nombreCargo, descripcion, salarioBase, nivelJerarquico, estado) VALUES ('Analista Financiero', 'Encargado del análisis de datos financieros y preparación de informes.', 3000.00, 2, '1');
INSERT INTO CargoEmpleado (nombreCargo, descripcion, salarioBase, nivelJerarquico, estado) VALUES ('Asistente Administrativo', 'Soporte en tareas administrativas y gestión de documentos.', 1500.00, 3, '1');

INSERT INTO Empleados (nombreEmpleado, apellidoEmpleado, usuario, contrasena, cargo, salario, oficina, estado, codigoCargoEmpleado) VALUES ('Ana', 'Martínez', 'amartinez', 'password1', 'Gerente General', 5000.00, '101', '0', 1);
INSERT INTO Empleados (nombreEmpleado, apellidoEmpleado, usuario, contrasena, cargo, salario, oficina, estado, codigoCargoEmpleado) VALUES ('Luis', 'Gómez', 'lgomez', 'password2', 'Analista Financiero', 3000.00, '202', '1', 2);
INSERT INTO Empleados (nombreEmpleado, apellidoEmpleado, usuario, contrasena, cargo, salario, oficina, estado, codigoCargoEmpleado) VALUES ('Marta', 'Rodríguez', 'neryd', '1234', 'Asistente Administrativo', 1500.00, '303', '1', 3);

INSERT INTO Sucursales (nombreSucursal, direccionSucursal, telefono, correoSucursal, estado, codigoEmpleado) VALUES ('Sucursal Central', 'Avenida Principal 123', '123-456-7890', 'central@example.com', '0', 1);
INSERT INTO Sucursales (nombreSucursal, direccionSucursal, telefono, correoSucursal, estado, codigoEmpleado) VALUES ('Sucursal Norte', 'Calle Norte 456', '098-765-4321', 'norte@example.com', '1', 2);
INSERT INTO Sucursales (nombreSucursal, direccionSucursal, telefono, correoSucursal, estado, codigoEmpleado) VALUES('Sucursal Sur', 'Boulevard Sur 789', '567-890-1234', 'sur@example.com', '1', 3);

INSERT INTO Transaccion (estadoTransaccion, TipoTransaccion, Monto, Fecha, estado, codigoCliente) VALUES ('Completada', 'Depósito', 1500.00, '2024-07-01', '0', 1);
INSERT INTO Transaccion (estadoTransaccion, TipoTransaccion, Monto, Fecha, estado, codigoCliente) VALUES ('Pendiente', 'Retiro', 500.00, '2024-07-02', '1', 2);
INSERT INTO Transaccion (estadoTransaccion, TipoTransaccion, Monto, Fecha, estado, codigoCliente) VALUES ('Completada', 'Transferencia', 250.00, '2024-07-03', '1', 3);

INSERT INTO Prestamos (monto, tipoPrestamo, tasaInteres, fechaInicio, fechaVencimiento, estado, codigoCliente) VALUES (5000.00, 'Personal', 5.00, '2024-01-01', '2025-01-01', '0', 1);
INSERT INTO Prestamos (monto, tipoPrestamo, tasaInteres, fechaInicio, fechaVencimiento, estado, codigoCliente) VALUES (10000.00, 'Empresa', 4.50, '2024-02-01', '2025-02-01', '1', 2);
INSERT INTO Prestamos (monto, tipoPrestamo, tasaInteres, fechaInicio, fechaVencimiento, estado, codigoCliente) VALUES (7500.00, 'Organizacion', 3.75, '2024-03-01', '2025-03-01', '1', 3);

INSERT INTO PagosPrestamos (monto, fechaInicio, fechaVencimiento, estadoPago, codigoPrestamo) VALUES (1000.00, '2024-01-15', '2024-02-15', 'Completado', 1);
INSERT INTO PagosPrestamos (monto, fechaInicio, fechaVencimiento, estadoPago, codigoPrestamo) VALUES (2000.00, '2024-02-15', '2024-03-15', 'Pendiente', 2);
INSERT INTO PagosPrestamos (monto, fechaInicio, fechaVencimiento, estadoPago, codigoPrestamo) VALUES (1500.00, '2024-03-15', '2024-04-15', 'Atrasado', 3);

INSERT INTO Tarjetas (numeroTarjeta, tipoTarjeta, CVC, fechaVencimiento, fechaEmision, limiteDeCredito, estado, codigoCliente)
	VALUES ('1234-5678-9012-3456', 'Tarjeta de Crédito', '123', '2026-12-31', '2023-01-01', 5000.00, '0', 1);
INSERT INTO Tarjetas (numeroTarjeta, tipoTarjeta, CVC, fechaVencimiento, fechaEmision, limiteDeCredito, estado, codigoCliente)
	VALUES ('2345-6789-0123-4567', 'Tarjeta de Débito', '456', '2025-11-30', '2022-02-01', 0.00, '1', 2);
INSERT INTO Tarjetas (numeroTarjeta, tipoTarjeta, CVC, fechaVencimiento, fechaEmision, limiteDeCredito, estado, codigoCliente)
	VALUES ('3456-7890-1234-5678', 'Tarjeta de Crédito Empresarial', '789', '2024-10-31', '2021-03-01', 10000.00, '1', 3);

INSERT INTO Seguro ( numeroPoliza, tipoSeguro, montoAsegurado, primaMensual, fechaExpiracion, estado, codigoCliente)
	VALUES ('POL1234567890', 'Salud', 100000.00, 150.00, '2025-12-31', '0', 1);
INSERT INTO Seguro (numeroPoliza, tipoSeguro, montoAsegurado, primaMensual, fechaExpiracion, estado, codigoCliente)
	VALUES ('POL2345678901', 'Automóvil', 50000.00, 80.00, '2024-11-30', '1', 2);
INSERT INTO Seguro (numeroPoliza, tipoSeguro, montoAsegurado, primaMensual, fechaExpiracion, estado, codigoCliente)
	VALUES ('POL3456789012', 'Vida', 200000.00, 200.00, '2026-10-31', '1', 3);
    
INSERT INTO DetalleCuenta (fechaDetalle, tipoOperacion, estadoCuenta, codigoCliente, codigoEmpleado, codigoSucursal) VALUES ('2024-07-10', 'Depósito', 'Confirmado', 1, 1, 1);
INSERT INTO DetalleCuenta (fechaDetalle, tipoOperacion, estadoCuenta, codigoCliente, codigoEmpleado, codigoSucursal) VALUES ('2024-07-12', 'Retiro', 'Pendiente', 2, 2, 2);
INSERT INTO DetalleCuenta (fechaDetalle, tipoOperacion, estadoCuenta, codigoCliente, codigoEmpleado, codigoSucursal) VALUES ('2024-07-15', 'Transferencia', 'Completado', 3, 3, 3);


select * from Empleados where usuario='neryd' and contrasena = '1234';
select * from CargoEmpleado;
select * from seguro;

Select * from Empleados where nombreEmpleado like '' or apellidoEmpleado like '' or usuario like 'neryd' or contrasena like '' or cargo like '' or salario like 0.0 or oficina like '' or estado like '' or codigoCargoEmpleado like 1 ;
Select * from Seguro where numeroPoliza like '' or tipoSeguro like '' or montoAsegurado like 0.00 or primaMensual like 0.00 or fechaExpiracion like '' or  estado like '' or codigoCliente like 1 ;
Select * from Sucursales where nombreSucursal like '' or direccionSucursal like '' or telefono like '' or correoSucursal like ''  or  estado like '' or codigoEmpleado like 1 ;

Select * from Seguro where numeroSeguro = 1;
