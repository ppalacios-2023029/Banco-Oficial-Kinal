<%-- 
    Document   : BancoTargetas
    Created on : 6/08/2024, 08:47:19 AM
    Author     : neryd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>

<body>
    
    <div class="container mt-4">
        <div class="row">
            <c:forEach var="p" items="${nuevaTarjeta}">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-header">
                        <label>${p.getTitulo()}</label>
                    </div>
                    <div class="card-body">
                        <i>${p.getMonto()}</i>
                        <img src="ControladorNuevaTarjeta?id=${p.getCodigoNuevaTarjeta()}" width="200" height="180">
                    </div>
                    <div class="card-footer text-center">
                        <label for="">${p.getDescripcion()}</label>
                        <div >
                            <a href="" class="btn  btn-outline-info">Agregar Carrito</a>
                            <a href="" class=" btn btn-danger">Comprar</a>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>

    </div>


    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
        crossorigin="anonymous"></script>
</body>

</html>
