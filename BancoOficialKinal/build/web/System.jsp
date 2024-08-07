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
          <a aria-current="page" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">
            <i class="ri-account-circle-fill"></i>
            <span class="link_name">Apertura de cuenta</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" aria-current="page" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Apertura de cuenta</a></span>
          </div>
        </li>
        
        

        <li id="prestamoNuevo">
          <a aria-current="page" href="Controlador?menu=Prestamo&accion=Listar" target="myFrame">
            <i class="ri-money-dollar-circle-fill"></i>
            <span class="link_name">Solicitar prestamo</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" href="Prestamo.jsp">Solicitar prestamo</a></span>
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
            <span><a aria-current="page" href="Controlador?menu=Seguro&accion=Listar" target="myFrame">Seguros</a></span>
            <span><a href="#">Targetas</a></span>
            <span><a aria-current="page" href="Controlador?menu=Transaccion&accion=Listar" target="myFrame">Transacciones</a></span>
            <span><a aria-current="page" href="Controlador?menu=TipoCuenta&accion=Listar" target="myFrame">Tipos de Cuentas</a></span>
          </ul>
        </li>
        
        <li id="prestamoNuevo">
          <a aria-current="page" href="Controlador?menu=Prestamo&accion=Listar" target="myFrame">
            <i class="ri-money-dollar-circle-fill"></i>
            <span class="link_name">Pagos de Prestamos</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" href="">Pagos de Prestamos </a></span>
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
            <span><a aria-current="page" href="Controlador?menu=Sucursal&accion=Listar" target="myFrame">Sucursales</a></span>
            <span><a aria-current="page" href="Controlador?menu=CargoEmpleado&accion=Listar" target="myFrame">Cargos</a></span>
            <span><a aria-current="page" href="Controlador?menu=NuevaTarjeta&accion=Listar" target="myFrame">Crear Targeta</a></span>
          </ul>
        </li>
        <li id="prestamoNuevo">
          <a aria-current="page" href="Controlador?menu=BancoTarjetas&accion=BancoTarjetas" target="myFrame">
            <i class="ri-money-dollar-circle-fill"></i>
            <span class="link_name">Solicitud de Targeta</span>
          </a>
          <div class="sub-menu blank">
            <span><a class="link_name" href="Controlador?menu=BancoTarjetas">Pagos de Prestamos </a></span>
          </div>
        </li>
        <li id="aperturaCuenta">
          <a aria-current="page" href="Controlador?menu=DetalleCuenta&accion=Listar" target="myFrame">
            <i class="ri-account-circle-fill"></i>
            <span class="link_name">Detalle Cuenta</span>
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

        <!-- Botón para abrir el modal -->
        <button id="abrirModal" class="profile-info">
          <img src="assets/img/fav-icon.png" alt="Profile Picture" class="profile-image">
          <div>
            <span class="name">${empleado.getNombreEmpleado()}</span><br>
            <small class="role">${cargoEmpleado.getNombreCargo()}</small>
          </div>
        </button>
        
        <!-- Estructura del modal principal -->
        <div id="miModal" class="modal">
          <div class="modal-contenido">
            <span class="cerrar">&times;</span>
            <div class="dropdown-content">
              <a href="#" id="openPerfil" class="dropdown-item">
                <i class="ri-user-3-fill text-primary"></i>
                <span class="ms-2">Perfil</span>
              </a>
              <a href="#" id="openConfiguracion" class="dropdown-item">
                <i class="ri-mail-line text-success"></i>
                <span class="ms-2">Configuración</span>
              </a>
              <a href="#" class="dropdown-item">
                <form action="Validar" method="POST">
                    <i class="ri-logout-box-r-line text-danger"></i>
                      <button name="accion" name="Salir" class="Salir" href="#">Salir</button>
                      
                </form>
              </a>
            </div>
          </div>
        </div>
        
        <!-- Modal para la opción "Perfil" -->
        <div id="modalPerfil" class="modal">
          <div class="modal-contenido2">
            <span class="cerrar">&times;</span>
            <h2>Perfil</h2>
            <div class="perfil-datos">
            <img src="assets/img/fav-icon.png" alt="Profile Picture" class="profile-datos-img">
            <div class="datos">
                <form action="Controlador?menu=Empleado&accion=Listar" method="POST">
                  <div class="containerInputs">
                      <div class="TituloAgregar">
                          <p class="TituloAgregar__subtitulos1">Mis Datos</p>
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
                  </div>
                </form>
            </div>
            </div>
          </div>
        </div>
        
        <!-- Modal para la opción "Configuración" -->
        <div id="modalConfiguracion" class="modal">
          <div class="modal-contenido1">
            <span class="cerrar">&times;</span>
            <h2>Configuración</h2>
            <div class="modo-oscuro">
              <span>Modo Oscuro</span>
              <i class="ri-moon-line  change-theme" id="theme-button"></i>
            </div>
          </div>
        </div>

    </div>

    <div class="iframe-container">
        
      <iframe name="myframe"></iframe>
  </div>
  
</section>


<script src="./assets/js/scripts.js"></script>
</body>
</html>