Drop database if exists DBBancoOficialKinal;
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