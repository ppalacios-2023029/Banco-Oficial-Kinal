<%-- 
    Document   : Sucursal
    Created on : 6/08/2024, 02:18:08 PM
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
                    <form action="Controlador?menu=Sucursal" method="POST">
                        <div class="header_table">
                            <input type="submit" name="accion" value="Buscar" class="btn-Buscar">
                            <input type="text" value="" name="txtBuscar" class="textSearch" placeholder="Buscar">
                        </div>
                    </form>
                    <table class="table" style="width: 100%; ">
                        <thead class="tTop">
                            <tr>
                                <th class="trTexto">Código</th>
                                <th class="trTexto">Nombre</th>
                                <th class="trTexto">Direccion</th>
                                <th class="trTexto">Telefono</th>
                                <th class="trTexto">Correo</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="sucursal" items="${sucursales}">
                                <tr class="filas">
                                    <td>${sucursal.getCodigoSucursal()}</td>
                                    <td>${sucursal.getNombreSucursal()}</td>
                                    <td>${sucursal.getDireccionSucursal()}</td>
                                    <td>${sucursal.getTelefono()}</td>
                                    <td>${sucursal.getCorreoSucursal()}</td>
                                    <td>${sucursal.getEstado()}</td>
                                    <td>${sucursal.getCodigoEmpleado()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=Sucursal&accion=Editar&codigoSucursal=${sucursal.getCodigoSucursal()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=Sucursal&accion=Eliminar&codigoSucursal=${sucursal.getCodigoSucursal()}">Eliminar</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Sucursal" method="POST">
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
                                <p class="TituloAgregar__subtitulos2">Nombre Sucursal</p>
                                <input type="text" value="${sucursal.getNombreSucursal()}" name="txtNombreSucursal" class="form-control" placeholder="Nombre Sucursal">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Direccion Sucursal</p>
                                <input type="text" value="${sucursal.getDireccionSucursal()}" name="txtDireccionSucursal" class="form-control" placeholder="Direccion Sucursal">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Telefono</p>
                                <input type="text" value="${sucursal.getTelefono()}" name="txtTelefono" class="form-control" placeholder="Telefono">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Correo</p>
                                <input type="text" value="${sucursal.getCorreoSucursal()}" name="txtCorreoSucursal" class="form-control" placeholder="Correo">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" ${sucursal.getEstado() == '1' ? 'selected' : ''}>Activo</option>
                                    <option value="0" ${sucursal.getEstado() == '0' ? 'selected' : ''}>Inactivo</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Empleado</p>
                                <select class="sl-foreign" name="txtCodigoEmpleado">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="empleadoL" items="${empleadoLista}">
                                        <option value="${empleadoL.getCodigoEmpleado()}"
                                                ${empleadoL.getCodigoEmpleado() == sucursal.getCodigoEmpleado() ? 'selected' : ''}>
                                            ${empleadoL.getNombreEmpleado()}
                                            ${empleadoL.getApellidoEmpleado()}
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