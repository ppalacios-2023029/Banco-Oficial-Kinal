<%-- 
    Document   : Cliente
    Created on : 5/08/2024, 08:49:42 PM
    Author     : jgonz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
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
                    <form action="Controlador?menu=Cliente" method="POST">
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
                                <th class="trTexto">Apellido</th>
                                <th class="trTexto">Direccion</th>
                                <th class="trTexto">Celular</th>
                                <th class="trTexto">Correo</th>
                                <th class="trTexto">Descripcion</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto">Tipo de Cuenta</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr class="filas">
                                    <td>${cliente.getCodigoCliente()}</td>
                                    <td>${cliente.getNombreCliente()}</td>
                                    <td>${cliente.getApellidoCliente()}</td>
                                    <td>${cliente.getDireccionCliente()}</td>
                                    <td>${cliente.getTelefonoCliente()}</td>
                                    <td>${cliente.getCorreoCliente()}</td>
                                    <td>${cliente.getDescripcion()}</td>
                                    <td>${cliente.getCodigoTipoCuenta()}</td>
                                    <td>${cliente.getEstado()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=Cliente&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=Cliente&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="POST">
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
                                <p class="TituloAgregar__subtitulos2">Nombre</p>
                                <input type="text" value="${cliente.getNombreCliente()}" name="txtNombreCliente" class="form-control" placeholder="Nombre">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Apellido</p>
                                <input type="text" value="${cliente.getApellidoCliente()}" name="txtApellidoCliente" class="form-control" placeholder="Apellido">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Direccion</p>
                                <input type="text" value="${cliente.getDireccionCliente()}" name="txtDireccionCliente" class="form-control" placeholder="Direccion">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Celular</p>
                                <input type="text" value="${cliente.getTelefonoCliente()}" name="txtTelefonoCliente" class="form-control" placeholder="Celular">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Correo</p>
                                <input type="text" value="${cliente.getCorreoCliente()}" name="txtCorreoCliente" class="form-control" placeholder="Correo">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Descripcion</p>
                                <input type="text" value="${cliente.getDescripcion()}" name="txtDescripcionCliente" class="form-control" placeholder="Descripcion">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="A" ${cliente.getEstado() == 'A' ? 'selected' : ''}>Activo</option>
                                    <option value="I" ${cliente.getEstado() == 'I' ? 'selected' : ''}>Inactivo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Tipo de Cuenta</p>
                                <select class="sl-foreign" name="ddlCliente">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="listasTC" items="${tipoCuentas}">
                                        <option value="${listasTC.getCodigoTipoCuenta()}"
                                                ${listasTC.getCodigoTipoCuenta() == cliente.getCodigoTipoCuenta() ? 'selected' : ''}>
                                            ${listasTC.getTipoCuenta()}
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
