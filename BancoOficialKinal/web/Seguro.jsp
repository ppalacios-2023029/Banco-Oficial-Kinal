<%-- 
    Document   : Seguro
    Created on : 6/08/2024, 01:13:02 AM
    Author     : HP
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
                    <form action="Controlador?menu=Seguro" method="POST">
                        <div class="header_table">
                            <input type="submit" name="accion" value="Buscar" class="btn-Buscar">
                            <input type="text" value="" name="txtBuscar" class="textSearch" placeholder="Buscar">
                        </div>
                    </form>
                    <table class="table" style="width: 100%; ">
                        <thead class="tTop">
                            <tr>
                                <th class="trTexto">Numero</th>
                                <th class="trTexto">Poliza</th>
                                <th class="trTexto">Seguro</th>
                                <th class="trTexto">Monto</th>
                                <th class="trTexto">Prima M.</th>
                                <th class="trTexto">Fecha Ex.</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto">Cod Cliente</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="seguro" items="${seguros}">
                                <tr class="filas">
                                    <td>${seguro.getNumeroSeguro()}</td>
                                    <td>${seguro.getNumeroPoliza()}</td>
                                    <td>${seguro.getTipoSeguro()}</td>
                                    <td>${seguro.getMontoAsegurado()}</td>
                                    <td>${seguro.getPrimaMensual()}</td>
                                    <td>${seguro.getFechaExpiracion()}</td>
                                    <td>${seguro.getEstado()}</td>
                                    <td>${seguro.getCodigoCliente()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=Seguro&accion=Editar&numeroSeguro=${seguro.getNumeroSeguro()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=Seguro&accion=Eliminar&numeroSeguro=${seguro.getNumeroSeguro()}">Eliminar</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Seguro" method="POST">
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
                                <p class="TituloAgregar__subtitulos2">Numero Poliza</p>
                                <input type="text" value="${seguro.getNumeroPoliza()}" name="txtNumeroPoliza" class="form-control" placeholder="Numero Poliza">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Tipo Seguro</p>
                                <input type="text" value="${seguro.getTipoSeguro()}" name="txtTipoSeguro" class="form-control" placeholder="Tipo Seguro">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Monto Asegurado</p>
                                <input type="text" value="${seguro.getMontoAsegurado()}" name="txtMontoAsegurado" class="form-control" placeholder="Monto Asegurado">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Prima Mensual</p>
                                <input type="text" value="${seguro.getPrimaMensual()}" name="txtPrimaMensual" class="form-control" placeholder="Prima Mensual">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Fecha Expiracion</p>
                                <input type="text" value="${seguro.getFechaExpiracion()}" name="txtFechaExpiracion" class="form-control" placeholder="Fecha Expiracion">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" ${seguro.getEstado() == '1' ? 'selected' : ''}>Activo</option>
                                    <option value="0" ${seguro.getEstado() == '0' ? 'selected' : ''}>Inactivo</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Cliente</p>
                                <select class="sl-foreign" name="txtCodigoCliente">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="clientesL" items="${clientesLista}">
                                        <option value="${clientesL.getCodigoCliente()}"
                                                ${clientesL.getCodigoCliente() == seguro.getCodigoCliente() ? 'selected' : ''}>
                                            ${clientesL.getNombreCliente()}
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
