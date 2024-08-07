<%-- 
    Document   : DetalleCuenta
    Created on : 6/08/2024, 01:57:56 PM
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
                    <form action="Controlador?menu=DetalleCuenta" method="POST">
                        <div class="header_table">
                            <input type="submit" name="accion" value="Buscar" class="btn-Buscar">
                            <input type="text" value="" name="txtBuscar" class="textSearch" placeholder="Buscar">
                        </div>
                    </form>
                    <table class="table" style="width: 100%; ">
                        <thead class="tTop">
                            <tr>
                                <th class="trTexto">Código</th>
                                <th class="trTexto">Fecha</th>
                                <th class="trTexto">Tipo Op.</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto">Cod Cliente</th>
                                <th class="trTexto">Cod Empleado</th>
                                <th class="trTexto">Cod Sucursal</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="detalleCuenta" items="${detalleCuentas}">
                                <tr class="filas">
                                    <td>${detalleCuenta.getCodigoDetalleCuenta()}</td>
                                    <td>${detalleCuenta.getFechaDetalle()}</td>
                                    <td>${detalleCuenta.getTipoOperacion()}</td>
                                    <td>${detalleCuenta.getEstadoCuenta()}</td>
                                    <td>${detalleCuenta.getCodigoCliente()}</td>
                                    <td>${detalleCuenta.getCodigoEmpleado()}</td>
                                    <td>${detalleCuenta.getCodigoSucursal()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=DetalleCuenta&accion=Editar&codigoDetalleCuenta=${detalleCuenta.getCodigoDetalleCuenta()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=DetalleCuenta&accion=Eliminar&codigoDetalleCuenta=${detalleCuenta.getCodigoDetalleCuenta()}">Eliminar</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=DetalleCuenta" method="POST">
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
                                <p class="TituloAgregar__subtitulos2">Fecha Detalle</p>
                                <input type="text" value="${detalleCuenta.getFechaDetalle()}" name="txtFechaDetalle" class="form-control" placeholder="Fecha Detalle">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Tipo Operacion</p>
                                <input type="text" value="${detalleCuenta.getTipoOperacion()}" name="txtTipoOperacion" class="form-control" placeholder="Tipo Operacion">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" ${detalleCuenta.getEstadoCuenta() == '1' ? 'selected' : ''}>Confirmado</option>
                                    <option value="0" ${detalleCuenta.getEstadoCuenta() == '0' ? 'selected' : ''}>Pendiente</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Cliente</p>
                                <select class="sl-foreign" name="txtCodigoCliente">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="clienteL" items="${clienteLista}">
                                        <option value="${clienteL.getCodigoCliente()}"
                                                ${clienteL.getCodigoCliente() == detalleCuenta.getCodigoCliente() ? 'selected' : ''}>
                                            ${clienteL.getNombreCliente()}
                                            ${clienteL.getApellidoCliente()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div> 
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Empleado</p>
                                <select class="sl-foreign" name="txtCodigoEmpleado">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="empleadoL" items="${empleadoLista}">
                                        <option value="${empleadoL.getCodigoEmpleado()}"
                                                ${empleadoL.getCodigoEmpleado() == detalleCuenta.getCodigoEmpleado() ? 'selected' : ''}>
                                            ${empleadoL.getNombreEmpleado()}
                                            ${empleadoL.getApellidoEmpleado()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Sucursal</p>
                                <select class="sl-foreign" name="txtCodigoSucursal">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="sucursalL" items="${sucursalLista}">
                                        <option value="${sucursalL.getCodigoSucursal()}"
                                                ${sucursalL.getCodigoSucursal() == detalleCuenta.getCodigoSucursal() ? 'selected' : ''}>
                                            ${sucursalL.getNombreSucursal()}
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