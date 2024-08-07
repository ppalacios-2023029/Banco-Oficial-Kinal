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
                                <th class="trTexto">Usuario</th>
                                <th class="trTexto">Contraseña</th>
                                <th class="trTexto">Cargo</th>
                                <th class="trTexto">Salario</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto">Cod Cargo</th>
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
                                <p class="TituloAgregar__subtitulos2">Nombre Empleado</p>
                                <input type="text" value="" name="txtNombreEmpleado" class="form-control" placeholder="Nombre Empleado">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Apellido Empleado</p>
                                <input type="text" value="" name="txtApellidoEmpleado" class="form-control" placeholder="Apellido Empleado">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Usuario</p>
                                <input type="text" value="" name="txtUsuario" class="form-control" placeholder="Usuario">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Contraseña</p>
                                <input type="text" value="" name="txtContrasena" class="form-control" placeholder="Contraseña">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Cargo</p>
                                <input type="text" value="" name="txtCargo" class="form-control" placeholder="Cargo">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Salario</p>
                                <input type="text" value="" name="txtSalario" class="form-control" placeholder="Salario">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Oficina</p>
                                <input type="number" id="quantity" name="txtOficina" min="100" max="765" value="" class="sl-foreign input-number">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" >Activo</option>
                                    <option value="0" >Inactivo</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Tipo Cliente</p>
                                <select class="sl-foreign" name="ddlCargoEmpleado">
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
