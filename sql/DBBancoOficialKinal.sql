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