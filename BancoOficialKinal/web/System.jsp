<%-- 
    Document   : system
    Created on : 3/08/2024, 10:20:37 PM
    Author     : neryd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Atencion al cliente</title>
  <!--=============== FAVICON ===============-->
  <link rel="icon" href="./assets/img/fav-icon.png" type="image/x-icon">

  <!--=============== REMIXICONS ===============-->
  <link href="https://cdn.jsdelivr.net/npm/remixicon@4.3.0/fonts/remixicon.css" rel="stylesheet"/>
  
  <!--=============== CSS ===============-->

  <link rel="stylesheet" href="./assets/css/Gerencia.css">
</head>

<body>
  <nav>
    <div class="logo-name">
      <div class="logo-image">
        <img src="assets/img/fav-icon.png" alt=""> 
      </div> 

      <a href="#" class="nav__logo">
        BANCO<span> KINAL</span> 
     </a>
      
    </div>

    <div class="menu-items">
      <ul class="nav-links">
        <li id="principal">
          <a href="#">
            <i class="ri-home-4-fill"></i>
            <span class="link_name">Pricipal</span>
          </a>
          <div class="sub-menu blank">
            <span><a aria-current="page" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Principal</a></span>
          </div>
        </li>

        <li id="aperturaCuenta">
          <a href="Controlador?menu=Cliente&accion=Listar" target="myframe">
            <i class="ri-account-circle-fill"></i>
            <span class="link_name">Apertura de cuenta</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" href="Controlador?menu=Cliente&accion=Listar" target="myframe">Apertura de cuenta</a></span>
          </div>
        </li>
        
        

        <li id="prestamoNuevo">
          <a aria-current="page" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">
            <i class="ri-money-dollar-circle-fill"></i>
            <span class="link_name">Solicitar prestamo</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" href="#">Solicitar prestamo</a></span>
          </div>
        </li>

        <li id="tarjetaNueva">
          <div class="iocn-link">
            <a aria-current="page" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">
              <i class="ri-bank-card-fill"></i>
              <span class="link_name">Admin Clientes</span>
            </a>
            <i class="ri-arrow-down-s-line arrow"></i>
          </div>
          <ul class="sub-menu">
            <span><a class="link_name" href="#">Tipo</a></span>
            <span><a href="#">Seguros</a></span>
            <span><a href="#">Targetas</a></span>
            <span><a href="#">Transacciones</a></span>
            <span><a href="#">Tipos de Cuentas</a></span>
          </ul>
        </li>
        
        <li id="prestamoNuevo">
          <a aria-current="page" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">
            <i class="ri-money-dollar-circle-fill"></i>
            <span class="link_name">Pagos de Prestamos</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" href="#">Pagos de Prestamos </a></span>
          </div>
        </li>
        
        <li id="seguroDeGastos">
          <div class="iocn-link">
            <a aria-current="page" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">
              <i class="ri-medicine-bottle-fill"></i>
              <span class="link_name">Empleados</span>
            </a>
            <i class="ri-arrow-down-s-line arrow"></i>
          </div>
          <ul class="sub-menu">
            <span><a class="link_name" href="#">Seguro</a></span>
            <span><a href="#">Sucursales</a></span>
            <span><a href="#">Cargos</a></span>
            <span><a href="#">Dribbble</a></span>
          </ul>
        </li>
        <li id="aperturaCuenta">
          <a aria-current="page" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">
            <i class="ri-account-circle-fill"></i>
            <span class="link_name">Vista General</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" href="#">Apertura de cuenta</a></span>
          </div>
        </li>
        
      </ul>
    </div>
  </nav>


  <section class="dashboard">

    <div class="top">
        <i class="ri-menu-2-line sidebar-toggle"></i>

        <div class="search-box">
            <i class="ri-search-2-line"></i>
            <input type="text" placeholder="Search here...">
        </div>

        <i class="ri-moon-line  change-theme" id="theme-button"></i>

        <div class="profile-container">
          <div class="dropdown">
            <div class="profile-info">
              <img src="assets/img/ac.png" alt="Profile Picture" class="profile-image">
              <div>
                <span class="name">Johndoe</span><br>
                <small class="role">Super Admin</small>
              </div>
            </div>

            <div class="dropdown-content">
              <a href="#" class="dropdown-item">
                <i class="ri-user-3-fill text-primary"></i>
                <span class="ms-2">Perfil</span>
              </a>
              <a href="#" class="dropdown-item">
                <i class="ri-mail-line text-success"></i>
                <span class="ms-2">Configuración</span>
              </a>
              <a href="#" class="dropdown-item">
                <i class="ri-logout-box-r-line text-danger"></i>
                <span class="ms-2">Salir</span>
              </a>
            </div>
          </div>
        </div>

    </div>

    <div class="iframe-container">
        
      <iframe name="myFrame"></iframe>
  </div>
  
</section>


<script src="./assets/js/scripts.js"></script>
</body>
</html>