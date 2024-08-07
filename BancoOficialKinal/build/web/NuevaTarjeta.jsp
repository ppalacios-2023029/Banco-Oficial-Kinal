<%-- 
    Document   : NuevaTarjeta
    Created on : 6/08/2024, 06:01:03 AM
    Author     : neryd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario con Bootstrap 4.6</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <form action="Controlador?menu=NuevaTarjeta&accion=Guardar" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="texto1">Titulo de la Tarjeta:</label>
                <input type="text" class="form-control" name="txtTitulo" placeholder="Ingresa el primer texto" required>
            </div>

            <div class="form-group">
                <label for="imagen">Imagen:</label>
                <input type="file"  name="imagen" >
            </div>

            <div class="form-group">
                <label >Descripción</label>
                <input type="text" class="form-control"  name="txtDescripcion" placeholder="Ingresa el segundo texto" required>
            </div>
            <div class="form-group">
                <label >Monto Por Uso</label>
                <input type="text" class="form-control"  name="txtMonto" placeholder="Ingresa el segundo texto" required>
            </div>

            <input type="submit" class="btn btn-primary" value="Nuevo" name="acccion">
            <input type="submit" class="btn btn-primary" value="Guardar" name="acccion">
        </form>
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

