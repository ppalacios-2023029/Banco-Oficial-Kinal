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
                            <c:forEach var="empleado" items="${empleados}">
                                <tr class="filas">
                                    <td>${empleado.getCodigoEmpleado()}</td>
                                    <td>${empleado.getNombreEmpleado()}</td>
                                    <td>${empleado.getApellidoEmpleado()}</td>
                                    <td>${empleado.getUsuario()}</td>
                                    <td>${empleado.getContrasena()}</td>
                                    <td>${empleado.getCargo()}</td>
                                    <td>${empleado.getSalario()}</td>
                                    <td>Oficina ${empleado.getOficina()}</td>
                                    <td>${empleado.getEstado()}</td>
                                    <td>${empleado.getCodigoCargoEmpleado()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=Empleado&accion=Editar&codigoEmpleado=${empleado.getCodigoEmpleado()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=Empleado&accion=Eliminar&codigoEmpleado=${empleado.getCodigoEmpleado()}">Eliminar</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
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
                                <input type="text" value="${empleado.getNombreEmpleado()}" name="txtNombreEmpleado" class="form-control" placeholder="Nombre Empleado">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Apellido Empleado</p>
                                <input type="text" value="${empleado.getApellidoEmpleado()}" name="txtApellidoEmpleado" class="form-control" placeholder="Apellido Empleado">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Usuario</p>
                                <input type="text" value="${empleado.getUsuario()}" name="txtUsuario" class="form-control" placeholder="Usuario">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Contraseña</p>
                                <input type="text" value="${empleado.getContrasena()}" name="txtContrasena" class="form-control" placeholder="Contraseña">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Cargo</p>
                                <input type="text" value="${empleado.getCargo()}" name="txtCargo" class="form-control" placeholder="Cargo">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Salario</p>
                                <input type="text" value="${empleado.getSalario()}" name="txtSalario" class="form-control" placeholder="Salario">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Oficina</p>
                                <input type="number" id="quantity" name="txtOficina" min="100" max="765" value="${empleado.getOficina()}" class="sl-foreign input-number">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" ${empleado.getEstado() == '1' ? 'selected' : ''}>Activo</option>
                                    <option value="0" ${empleado.getEstado() == '0' ? 'selected' : ''}>Inactivo</option>
                                </select>

                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Cargo Empleado</p>
                                <select class="sl-foreign" name="ddlCargoEmpleado">
                                    <option selected>Elija una opción</option> <!-- Mantén la opción predeterminada deshabilitada -->
                                    <c:forEach var="cargoEmpleado" items="${cargoEmpleados}">
                                        <option value="${cargoEmpleado.getCodigoCargoEmpleado()}"
                                                ${cargoEmpleado.getCodigoCargoEmpleado() == empleado.getCodigoCargoEmpleado() ? 'selected' : ''}>
                                            ${cargoEmpleado.getNombreCargo()}
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