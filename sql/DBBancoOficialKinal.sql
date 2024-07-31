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

create table CargoEmpleado (
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
    usuario varchar(10) not null,
    contrasena varchar(10) not null,
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
	codigoTransaccion INT not null AUTO_INCREMENT,
    estadoTransaccion VARCHAR(20) NOT NULL,
    TipoTransaccion VARCHAR(20) NOT NULL,
    Monto DECIMAL(10, 2) NOT NULL,
    Fecha DATE NOT NULL,
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
    codigoCliente int not null,
    primary key PK_numeroTarjeta(numeroTarjeta),
    constraint FK_Tarjetas_Clientes foreign key(codigoCliente) references Clientes(codigoCliente)
);

create table Seguro(
	numeroSeguro int not null,
    numeroPoliza varchar(20) not null,
    tipoSeguro varchar(20) not null,
    montoAsegurado double(10, 2) not null,
    primaMensual double(10, 2) not null,
    fechaExpiracion date not null,
    codigoCliente int not null,
    primary key PK_numeroSeguro(numeroSeguro),
    constraint FK_Seguro_Clientes foreign key(codigoCliente) references Clientes(codigoCliente)
);

create table DetalleCuenta (
    codigoDetalleCuenta int not null auto_increment,
    fechaDetalle date not null,
    tipoOperacion varchar(20) not null,
    EstadoCuenta varchar(20) not null,
    codigoCliente int,
    codigoEmpleado int,
    codigoSucursal int,
    primary key PK_codigoDetalleCuenta(codigoDetalleCuenta),
    constraint FK_DetalleCuenta_Clientes foreign key(codigoCliente) references Clientes(codigoCliente),
    constraint FK_DetalleCuenta_Empleados foreign key(codigoEmpleado) references Empleados(codigoEmpleado),
    constraint FK_DetalleCuenta_Sucursales foreign key(codigoSucursal) references Sucursales(codigoSucursal)
);

insert into CargoEmpleado(nombreCargo, descripcion, salarioBase, nivelJerarquico) values('Gerente','Dirige todo el Banco','12000.00',1);
insert into Empleados(nombreEmpleado, apellidoEmpleado,usuario, contrasena, cargo, salario, oficina, codigoCargoEmpleado) values('nery','de la Cruz','neryd','1234','Gerente','12000.0','A-100',1);

select * from Empleados where usuario='neryd' and contrasena = '1234';