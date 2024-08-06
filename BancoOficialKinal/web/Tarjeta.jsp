<%-- 
    Document   : Tarjeta
    Created on : 6/08/2024, 01:07:39 PM
    Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<!DOCTYPE html> 
<html lang="en"> 
    <head> 
        <meta charset="UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Tarjetas</title> 
        <link rel="stylesheet" href="./css/system.css"> 
        <link rel="preconnect" href="https://fonts.googleapis.com"> 
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap" rel="stylesheet"> 
    </head> 
    <body class="fondo"> 
        <div class="d-flex"> 
            <div class="col-sm-8"> 
                <div class="TablaCont"> 
                    <form action="Controlador?menu=Tarjeta" method="POST"> 
                        <div class="header_table"> 
                            <input type="submit" name="accion" value="Buscar" class="btn-Buscar"> 
                            <input type="text" value="" name="txtBuscar" class="textSearch" placeholder="Buscar"> 
                        </div> 
                    </form> 
                    <table class="table" style="width: 100%;"> 
                        <thead class="tTop"> 
                            <tr> 
                                <th class="trTexto">Número de Tarjeta</th> 
                                <th class="trTexto">Tipo de Tarjeta</th> 
                                <th class="trTexto">CVC</th> 
                                <th class="trTexto">Fecha de Vencimiento</th> 
                                <th class="trTexto">Fecha de Emisión</th> 
                                <th class="trTexto">Límite de Crédito</th> 
                                <th class="trTexto">Estado</th> 
                                <th class="trTexto">Código de Cliente</th> 
                                <th class="trTexto_acciones">ACCIONES</th> 
                            </tr> 
                        </thead> 
                        <tbody> 
                            <c:forEach var="tarjeta" items="${tarjetas}"> 
                                <tr class="filas"> 
                                    <td>${tarjeta.getNumeroTarjeta()}</td> 
                                    <td>${tarjeta.getTipoTarjeta()}</td> 
                                    <td>${tarjeta.getCVC()}</td> 
                                    <td>${tarjeta.getFechaVencimiento()}</td> 
                                    <td>${tarjeta.getFechaEmision()}</td> 
                                    <td>${tarjeta.getLimiteDeCredito()}</td> 
                                    <td>${tarjeta.getEstado()}</td> 
                                    <td>${tarjeta.getCodigoCliente()}</td> 
                                    <td class="controles_table"> 
                                        <a class="btn btnEditar" href="Controlador?menu=Tarjeta&accion=Editar&numeroTarjeta=${tarjeta.getNumeroTarjeta()}">Editar</a> 
                                        <a class="btn btnEliminar" href="Controlador?menu=Tarjeta&accion=Eliminar&numeroTarjeta=${tarjeta.getNumeroTarjeta()}">Eliminar</a> 
                                    </td> 
                                </tr> 
                            </c:forEach> 
                        </tbody> 
                    </table> 
                </div> 
                <div class="card-body"> 
                    <form action="Controlador?menu=Tarjeta" method="POST"> 
                        <div class="botones"> 
                            <div class="btn-group"> 
                                <input type="submit" name="accion" value="Agregar" class="btn btn-agregar"> 
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-actualizar"> 
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-cancelar"> 
                            </div> 
                        </div> 
                        <div class="containerInputs"> 
                            <div class="TituloAgregar"> 
                                <p class="TituloAgregar__subtitulos1">Agregar Tarjeta</p> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">Número de Tarjeta</p> 
                                <input type="text" value="${tarjeta.getNumeroTarjeta()}" name="txtNumeroTarjeta" class="form-control" placeholder="Número de Tarjeta"> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">Tipo de Tarjeta</p> 
                                <input type="text" value="${tarjeta.getTipoTarjeta()}" name="txtTipoTarjeta" class="form-control" placeholder="Tipo de Tarjeta"> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">CVC</p> 
                                <input type="text" value="${tarjeta.getCVC()}" name="txtCVC" class="form-control" placeholder="CVC"> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">Fecha de Vencimiento</p> 
                                <input type="date" value="${tarjeta.getFechaVencimiento()}" name="txtFechaVencimiento" class="form-control"> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">Fecha de Emisión</p> 
                                <input type="date" value="${tarjeta.getFechaEmision()}" name="txtFechaEmision" class="form-control"> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">Límite de Crédito</p> 
                                <input type="text" value="${tarjeta.getLimiteDeCredito()}" name="txtLimiteDeCredito" class="form-control" placeholder="Límite de Crédito"> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">Estado</p> 
                                <select class="sl-foreign" name="txtEstado"> 
                                    <option selected>Elija una opción</option> 
                                    <option value="1" ${tarjeta.getEstado() == '1' ? 'selected' : ''}>Activo</option> 
                                    <option value="0" ${tarjeta.getEstado() == '0' ? 'selected' : ''}>Inactivo</option> 
                                </select> 
                            </div> 
                            <div class="form-group"> 
                                <p class="TituloAgregar__subtitulos2">Código de Cliente</p> 
                                <select class="sl-foreign" name="ddlCodigoCliente"> 
                                    <option selected>Elija una opción</option> 
                                    <c:forEach var="cliente" items="${clientes}"> 
                                        <option value="${cliente.getCodigoCliente()}" ${cliente.getCodigoCliente() == tarjeta.getCodigoCliente() ? 'selected' : ''}> 
                                            ${cliente.getNombreCliente()} 
                                        </option> 
                                    </c:forEach> 
                                </select> 
                            </div> 
                        </div> 
                    </form> 
                </div> 
            </div> 
        </div> 
    </body> 
</html>

