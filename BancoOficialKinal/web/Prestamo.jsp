<%-- 
    Document   : Prestamo
    Created on : 6/08/2024, 02:38:28 PM
    Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tabla</title>
        <link rel="stylesheet" href="./css/system.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap" rel="stylesheet">
    </head>
    <body class="fondo">
        <div class="d-flex">
            <div class="col-sm-8">
                <div class="TablaCont">
                    <form action="Controlador?menu=Prestamo" method="POST">
                        <div class="header_table">
                            <input type="submit" name="accion" value="Buscar" class="btn-Buscar">
                            <input type="text" value="" name="txtBuscar" class="textSearch" placeholder="Buscar">
                        </div>
                    </form>
                    <table class="table" style="width: 100%; ">
                        <thead class="tTop">
                            <tr>
                                <th class="trTexto">Código</th>
                                <th class="trTexto">Monto</th>
                                <th class="trTexto">Tipo Prestamo</th>
                                <th class="trTexto">Tasa Interes</th>
                                <th class="trTexto">Fecha Inicio</th>
                                <th class="trTexto">Fecha Vancimiento</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto">Cod Cliente</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="prestamo" items="${prestamos}">
                                <tr class="filas">
                                    <td>${prestamo.getCodigoPrestamo()}</td>
                                    <td>${prestamo.getMonto()}</td>
                                    <td>${prestamo.getTipoPrestamo()}</td>
                                    <td>${prestamo.getTasaInteres()}</td>
                                    <td>${prestamo.getFechaInicio()}</td>
                                    <td>${prestamo.getFechaVencimiento()}</td>
                                    <td>${prestamo.getEstado()}</td>
                                    <td>${prestamo.getCodigoCliente()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=Prestamo&accion=Editar&codigoPrestamo=${prestamo.getCodigoPrestamo()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=Prestamo&accion=Eliminar&codigoPrestamo=${prestamo.getCodigoPrestamo()}">Eliminar</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Prestamo" method="POST">
                        <div class="botones">
                            <div class="btn-group">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-agregar">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-actualizar">
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-cancelar">
                            </div>
                        </div>
                        <div class="containerInputs">
                            <div class="TituloAgregar">
                                <p class="TituloAgregar__subtitulos1">Agregar</p>
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Monto</p>
                                <input type="text" value="${prestamo.getMonto()}" name="txtMonto" class="form-control" placeholder="Monto">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Tipo Prestamo</p>
                                <input type="text" value="${prestamo.getTipoPrestamo()}" name="txtTipoPrestamo" class="form-control" placeholder="Tipo Prestamo">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Tasa Interes</p>
                                <input type="text" value="${prestamo.getTasaInteres()}" name="txtTasaInteres" class="form-control" placeholder="Tasa Interes">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Fecha Inicio</p>
                                <input type="text" value="${prestamo.getFechaInicio()}" name="txtFechaInicio" class="form-control" placeholder="Fecha Inicio">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Fecha Vencimiento</p>
                                <input type="text" value="${prestamo.getFechaVencimiento()}" name="txtFechaVencimiento" class="form-control" placeholder="Fecha Vencimiento">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" ${prestamo.getEstado() == '1' ? 'selected' : ''}>Activo</option>
                                    <option value="0" ${prestamo.getEstado() == '0' ? 'selected' : ''}>Inactivo</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Cliente</p>
                                <select class="sl-foreign" name="ddlCliente">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="cliente" items="${clientes}">
                                        <option value="${cliente.getCodigoCliente()}"
                                                ${cliente.getCodigoCliente() == prestamo.getCodigoCliente() ? 'selected' : ''}>
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
