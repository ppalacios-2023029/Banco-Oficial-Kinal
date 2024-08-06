<%-- 
    Document   : Empleado
    Created on : 3/08/2024, 10:39:38 PM
    Author     : neryd
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
                    <form action="Controlador?menu=TipoCuenta" method="POST">
                        <div class="header_table">
                            <input type="submit" name="accion" value="Buscar" href="Controlador?menu=TipoCuenta&accion=Buscar" class="btn-Buscar">
                            <input type="text" value="" name="txtBuscar" class="textSearch" placeholder="Buscar">
                        </div>
                    </form>
                    <table class="table" style="width: 100%; ">
                        <thead class="tTop">
                            <tr>
                                <th class="trTexto">Código</th>
                                <th class="trTexto">Tipo Cuenta</th>
                                <th class="trTexto">Saldo Minimo</th>
                                <th class="trTexto">Intereses</th>
                                <th class="trTexto">Impuestos</th>
                                <th class="trTexto">Estado</th>
                                <th class="trTexto_acciones">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tipoCuenta" items="${tipoCuentas}">
                                <tr class="filas">
                                    <td>${tipoCuenta.getCodigoTipoCuenta()}</td>
                                    <td>${tipoCuenta.getTipoCuenta()}</td>
                                    <td>${tipoCuenta.getSaldoMinimoRequerido()}</td>
                                    <td>${tipoCuenta.getTazaDeInteres()}</td>
                                    <td>${tipoCuenta.getTazaDeImpuestos()}</td>
                                    <td>${tipoCuenta.getEstado()}</td>
                                    <td class="controles_table">
                                        <a class="btn btnEditar" href="Controlador?menu=TipoCuenta&accion=Editar&codigoTipoCuenta=${tipoCuenta.getCodigoTipoCuenta()}">Editar</a>
                                        <a class="btn btnEliminar" href="Controlador?menu=TipoCuenta&accion=Eliminar&codigoTipoCuenta=${tipoCuenta.getCodigoTipoCuenta()}">Eliminar</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=TipoCuenta" method="POST">
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
                                <p class="TituloAgregar__subtitulos2">Tipo Cuenta</p>
                                <input type="text" value="${tipoCuenta.getTipoCuenta()}" name="txtTipoCuenta" class="form-control" placeholder="Tipo Cuenta">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Saldo Minimo</p>
                                <input type="number" id="quantity" name="txtSaldoMinimoRequerido" min="100" max="3000" value="${tipoCuenta.getSaldoMinimoRequerido()}" class="sl-foreign input-number">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Intereses</p>
                                <input type="text" value="${tipoCuenta.getTazaDeInteres()}" name="txtTazaDeInteres" class="form-control" placeholder="Intereses">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Impuestos</p>
                                <input type="text" value="${tipoCuenta.getTazaDeImpuestos()}" name="txtTazaDeImpuestos" class="form-control" placeholder="Impuestos">
                            </div>
                            <div class="form-group">
                                <p class="TituloAgregar__subtitulos2">Estado</p>
                                <select class="sl-foreign" name="txtEstado">
                                    <option selected>Elija una opción</option>
                                    <option value="A" ${tipoCuenta.getEstado() == 'A' ? 'selected' : ''}>Activo</option>
                                    <option value="I" ${tipoCuenta.getEstado() == 'I' ? 'selected' : ''}>Inactivo</option>
                                </select>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
