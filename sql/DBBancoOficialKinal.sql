Drop database if exists DBBancoOficialKinal;
create database DBBancoOficialKinal;

use DBBancoOficialKinal;

create table TipoCuenta(
	codigoTipoCuenta int not null auto_increment,
    tipoCuenta varchar(45) not null,
    saldoMinimoRequerido double(10,2) not null,
    tazaDeInteres double(10,2) not null,
    tazaDeImpuestos double(10,2) not null,
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
    primary key PK_codigoCliente(codigoCliente),
    constraint FK_Clientes_TipoCuenta foreign key(codigoTipoCuenta) references TipoCuenta(codigoTipoCuenta)
);

create table CargoEmpleado(
	codigoCargoEmpleado int not null auto_increment,
    nombreCargo varchar(50) not null,
    descripcion text,
    salarioBase decimal(10,2) default 0.00,
    nivelJerarquico int,
    primary key PK_codigoCargoEmpleado(codigoCargoEmpleado)
);

create table Empleados (
    codigoEmpleado int not null auto_increment,
    nombreEmpleado varchar(50) not null,
    apellidoEmpleado varchar(50) not null,
    cargo varchar(50) not null,
    salario DECIMAL(10, 2) NOT NULL,
    oficina VARCHAR(50) NOT NULL,
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
    codigoEmpleado int,
    primary key PK_codigoSucursal(codigoSucursal),
    constraint FK_Sucursales_Empleados foreign key (codigoEmpleado) references Empleados(codigoEmpleado)
);

create table Transaccion(
	codigoTransaccion int not null auto_increment,
    estadoTransaccion varchar(20) not null,
    tipoTransaccion varchar(20) not null,
    monto decimal(10, 2) not null,
    fecha date not null,
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
    codigoCliente int not null,
    primary key PK_codigoPrestamo(codigoPrestamo),
    constraint FK_Prestamos_Clientes foreign key(codigoCliente) references Clientes(codigoCliente)
);