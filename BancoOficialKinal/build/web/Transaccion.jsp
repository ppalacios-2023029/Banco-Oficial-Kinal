<%-- 
    Document   : Transaccion
    Created on : 6/08/2024, 01:14:25 PM
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
                    <form action="Controlador?menu=Transaccion" method="POST">
                        <div class="header_table">
                            <input type="submit" name="accion" value="Buscar" class="btn-Buscar">
                            <input type="text" value="" name="txtBuscar" class="textSearch" placeholder="Buscar">
                        </div>
                    </form>
                    <table class="table" style="width: 100%; ">
                        <thead class="tTop">
                            <tr>
                                <th class="trTexto">Código</th>
                                <th class="trTexto">Estado Transaccion</th>
                                <th class="trTexto">Tipo</th>
                                <th class="trTexto">Monto</th>
                                <th class="trTexto">Fecha</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto">Cod Cliente</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="transaccion" items="${transacciones}">
                                <tr class="filas">
                                    <td>${transaccion.getCodigoTransaccion()}</td>
                                    <td>${transaccion.getEstadoTransaccion()}</td>
                                    <td>${transaccion.getTipoTransaccion()}</td>
                                    <td>Q${transaccion.getMonto()}</td>
                                    <td>${transaccion.getFecha()}</td>
                                    <td>${transaccion.getEstado()}</td>
                                    <td>${transaccion.getCodigoCliente()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=Transaccion&accion=Editar&codigoTransaccion=${transaccion.getCodigoTransaccion()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=Transaccion&accion=Eliminar&codigoTransaccion=${transaccion.getCodigoTransaccion()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Transaccion" method="POST">
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
                                <p class="TituloAgregar__subtitulos2">Estado de la Transacción</p>
                                <input type="text" value="${transaccion.getEstadoTransaccion()}" name="txtEstadoTransaccion" class="form-control" placeholder="Estado de la Transacción">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Tipo de la Transacción</p>
                                <input type="text" value="${transaccion.getTipoTransaccion()}" name="txtTipoTransaccion" class="form-control" placeholder="Tipo de la Transacción">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Monto</p>
                                <input type="text" value="${transaccion.getMonto()}" name="txtMonto" class="form-control" placeholder="Monto">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Fecha</p>
                                <input type="text" value="${transaccion.getFecha()}" name="txtFecha" class="form-control" placeholder="Fecha">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" ${transaccion.getEstado() == '1' ? 'selected' : ''}>Activo</option>
                                    <option value="0" ${transaccion.getEstado() == '0' ? 'selected' : ''}>Inactivo</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Cliente</p>
                                <select class="sl-foreign" name="ddlCliente">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="clienteL" items="${clienteLista}">
                                        <option value="${clienteL.getCodigoCliente()}"
                                                ${clienteL.getCodigoCliente() == transaccion.getCodigoCliente() ? 'selected' : ''}>
                                            ${clienteL.getNombreCliente()}
                                            ${clienteL.getApellidoCliente()}
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
