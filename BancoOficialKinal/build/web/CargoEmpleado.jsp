<%-- 
    Document   : CargoEmpleado
    Created on : 5/08/2024, 11:00:46 PM
    Author     : admin
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
                    <form action="Controlador?menu=CargoEmpleado" method="POST">
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
                                <th class="trTexto">Descripcion</th>
                                <th class="trTexto">Salario</th>
                                <th class="trTexto">Nivel Jerarquico</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="CargoEmpleado" items="${CargoEmpleado}">
                                <tr class="filas">
                                    <td>${CargoEmpleado.getCodigoCargoEmpleado()}</td>
                                    <td>${CargoEmpleado.getNombreCargo()}</td>
                                    <td>${CargoEmpleado.getDescripcion()}</td>
                                    <td>${CargoEmpleado.getSalarioBase()}</td>
                                    <td>${CargoEmpleado.getNivelJerarquico()}</td>
                                    <td>${CargoEmpleado.getEstado()}</td>
                                    <td class="controles_table">
                                         <a class="btn btnEditar" href="Controlador?menu=CargoEmpleado&accion=Editar&codigoCargoEmpleado=${CargoEmpleado.getCodigoCargoEmpleado()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=CargoEmpleado&accion=Eliminar&codigoCargoEmpleado=${CargoEmpleado.getCodigoCargoEmpleado()}">Eliminar</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=CargoEmpleado" method="POST">
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
                                <p class="TituloAgregar__subtitulos2">Nombre Cargo</p>
                                <input type="text" value="${Cargoempleado.getNombreCargo()}" name="txtNombreCargo" class="form-control" placeholder="Nombre Cargo">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Descripcion </p>
                                <input type="text" value="${Cargoempleado.getDescripcion()}" name="txtDescripcion" class="form-control" placeholder="Descripcion ">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Salario Base</p>
                                <input type="text" value="${Cargoempleado.getSalarioBase()}" name="txtSalarioBase" class="form-control" placeholder="Salario Base">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Nivel Jerarquico</p>
                                <input type="text" value="${Cargoempleado.getNivelJerarquico()}" name="txtNivelJerarquico" class="form-control" placeholder="Nivel Jerarquico">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="1" ${Cargoempleado.getEstado() == '1' ? 'selected' : ''}>Activo</option>
                                    <option value="0" ${Cargoempleado.getEstado() == '0' ? 'selected' : ''}>Inactivo</option>
                                </select>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
