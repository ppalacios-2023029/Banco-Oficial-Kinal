<%-- 
    Document   : home
    Created on : 14/07/2024, 01:22:36 PM
    Author     : neryd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <title>Banco Oficial Kinal</title>

        <!--=============== FAVICON ===============-->
        <link rel="icon" href="assets/img/fav-icon.png" type="image/x-icon">

        <!--=============== REMIXICONS ===============-->
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.2.0/fonts/remixicon.css" rel="stylesheet">

        <!--=============== SWIPER CSS ===============-->
        <link rel="stylesheet" href="assets/css/swiper-bundle.min.css">

        <!--=============== CSS ===============-->
        <link rel="stylesheet" href="assets/css/styles.css">

        <!--=============== GOOGLE FONTS ===============-->
        <link href="https://fonts.googleapis.com/css2?family=Playwrite+DE+Grund:wght@100..400&display=swap" rel="stylesheet">
        
        <link href="https://fonts.googleapis.com/css2?family=Saira:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    </head>
    <body>
    <!--==================== HEADER ====================-->
    <header class="header" id="header">
       <nav class="nav container">
          <a href="#" class="nav__logo">
             BANCO<span> KINAL</span> 
          </a>

          <div class="nav__menu" id="nav-menu">
             <ul class="nav__list">
                <li class="nav__item">
                   <a href="#home" class="nav__link">Inicio</a>
                </li>

                <li class="nav__item">
                   <a href="#popular" class="nav__link">Acerca de</a>
                </li>

                <li class="nav__item">
                   <a href="#choose" class="nav__link">Conocenenos</a>
                </li>
             </ul>
             
             <div class="nav__close" id="nav-close">
                <i class="ri-close-line"></i>
             </div>
          </div>

          <div class="nav__buttons">
             <i class="ri-moon-line  change-theme" id="theme-button"></i>
             
             <div class="nav__toggle" id="nav-toggle">
                <i class="ri-menu-line"></i>
             </div>
          </div>
       </nav>
    </header>

    <!--==================== MAIN ====================-->
    <main class="main">
       <!--==================== HOME ====================-->
       <section class="home section" id="home">
          <div class="home__bg"></div>

          <div class="home__container container grid">
             <div class="home__content grid">
                <div class="home__data">
                   <h3 class="home__subtitle">
                    Quienes somos?
                   </h3>

                   <h1 class="home__title">
                      Banco Oficial <br>
                      Kinal
                   </h1>

                   <div class="home__buttons">
                      <a href="Login.html" class="button">
                         Ingresa acá
                      </a>

                      <a href="index.html" class="button__link">
                         <i class="ri-play-circle-line"></i> Saber más
                      </a>
                   </div>
                </div>

                <div class="home__info">
                   <div>
                      <h3 class="home__info-title">
                         9K<span>+</span>
                      </h3>

                      <span class="home__info-subtitle">
                         Clientes <br> A nivel mundial
                      </span>
                   </div>

                   <div>
                      <h3 class="home__info-title">
                         2K<span>+</span>
                      </h3>

                      <span class="home__info-subtitle">
                         Happy <br> Customer
                      </span>
                   </div>

                   <div>
                      <h3 class="home__info-title">
                         28<span>+</span>
                      </h3>

                      <span class="home__info-subtitle">
                         Servicios <br> a disposición
                      </span>
                   </div>
                </div>
             </div>

             <div class="home__image">
                <div class="home__blob">
                   <img src="assets/img/fav-icon.png" alt="home image" class="home__img">
                   <h1 class="home__blob-title">
                      KINAL
                   </h1>
                </div>

                <div class="home__shadow"></div>
             </div>
          </div>
       </section>

       <!--==================== POPULAR ====================-->
       <section class="popular section" id="popular">
          <div class="popular__container container">
             <div class="popular__data">
                <h2 class="section__title">Servicios Populares</h2>

                <p class="popular__description">
                   Ofrecemos una gran cantidad de Servicios
                   para que el cliente este conforme
                   y tranquilo
                </p>
             </div>

             <div class="popular__content grid swiper">
                <div class="swiper-wrapper">
                   <article class="popular__card swiper-slide">
                      <div class="popular__blob">
                         <img src="assets/img/cuenta.png" alt="popular image" class="popular__img">
                      </div>

                      <h3 class="popular__name">Apertura de cuentas</h3>
                      <span class="popular__subtitle">Diversas opciones de tipos de cuentas</span>

                      <button class="popular__button">
                         <i class="ri-add-line"></i>
                      </button>
                   </article>

                   <article class="popular__card swiper-slide">
                      <div class="popular__blob">
                         <img src="assets/img/tarjeta.png" alt="popular image" class="popular__img">
                      </div>

                      <h3 class="popular__name">Solicitud de Tarjeta de Credito</h3>
                      <span class="popular__subtitle">Solicitar diversas categorias de tarjetas</span>

                      <button class="popular__button">
                         <i class="ri-add-line"></i>
                      </button>
                   </article>

                   <article class="popular__card swiper-slide">
                      <div class="popular__blob">
                         <img src="assets/img/Prestamo.jpg" alt="popular image" class="popular__img">
                      </div>

                      <h3 class="popular__name">Solicitud de prestamos</h3>
                      <span class="popular__subtitle">Descubre las ofertas de feria</span>

                      <button class="popular__button">
                         <i class="ri-add-line"></i>
                      </button>
                   </article>

                   <article class="popular__card swiper-slide">
                      <div class="popular__blob">
                         <img src="assets/img/Seguror.jpg" alt="popular image" class="popular__img">
                      </div>

                      <h3 class="popular__name">Seguros</h3>
                      <span class="popular__subtitle">Elige el seguro que mejor se adapte a tus necesidades</span>

                      <button class="popular__button">
                         <i class="ri-add-line"></i>
                      </button>
                   </article>

                   <article class="popular__card swiper-slide">
                      <div class="popular__blob">
                         <img src="assets/img/remesas.png" alt="popular image" class="popular__img">
                      </div>

                      <h3 class="popular__name">Remesas bancarias</h3>
                      <span class="popular__subtitle">Manda y recibe remesas a nivel mundial</span>

                      <button class="popular__button">
                         <i class="ri-add-line"></i>
                      </button>
                   </article>
                </div>

                <!-- Navigation buttons -->
                <div class="swiper-button-prev">
                   <i class="ri-arrow-left-s-line"></i>
                </div>

                <div class="swiper-button-next">
                   <i class="ri-arrow-right-s-line"></i>
                </div>
             </div>
          </div>
       </section>

       <!--==================== CHOOSE ====================-->
       <section class="choose section" id="choose">
          <div class="choose__container container grid">
             <div class="choose__image">
                <div class="choose__blob">
                   <img src="assets/img/fav-icon.png" alt="choose image" class="choose__img">
                   <h1 class="choose__blob-title">Kinal</h1>
                </div>

                <div class="choose__shadow"></div>
             </div>

             <div class="choose__content">
                <div class="choose__data">
                   <h2 class="section__title">"El trabajo bien hecho, para un futuro empresarial seguro"</h2>

                   <p class="choose__description">
                      Conoce más sobre tu banco de confianza
                   </p>
                </div>

                <div class="choose__faq">
                   <div class="choose__faq-item">
                      <div class="choose_faq-header">
                         <div class="choose__faq-icon">
                            <i class="ri-add-line"></i>
                         </div>

                         <div>
                            <h3 class="choose__faq-title">Historia de BOK</h3>
                         </div>
                      </div>

                      <div class="choose__faq-content">
                         <p class="choose__faq-descripiton">
                            El proyecto Banco Oficial Kinal busca 
                            atender las necesidades financieras de las empresas 
                            oficiales guatemaltecas, ofreciendo soluciones 
                            innovadoras y adaptadas para su desarrollo económico.
                         </p>
                      </div>
                   </div>

                   <div class="choose__faq-item">
                      <div class="choose_faq-header">
                         <div class="choose__faq-icon">
                            <i class="ri-add-line"></i>
                         </div>

                         <div>
                            <h3 class="choose__faq-title">Misión</h3>
                         </div>
                      </div>

                      <div class="choose__faq-content">
                         <p class="choose__faq-descripiton">
                            En Banco Oficial Kinal, nuestra misión 
                            es ofrecer servicios financieros de alta 
                            calidad a empresas oficiales guatemaltecas, 
                            basados en integridad y responsabilidad. 
                            Nos esforzamos por ser un socio confiable, 
                            proporcionando productos adaptados a sus 
                            necesidades y contribuyendo al crecimiento 
                            económico y social de Guatemala, con un enfoque en 
                            innovación, eficiencia y excelencia operativa.
                         </p>
                      </div>
                   </div>

                   <div class="choose__faq-item">
                      <div class="choose_faq-header">
                         <div class="choose__faq-icon">
                            <i class="ri-add-line"></i>
                         </div>

                         <div>
                            <h3 class="choose__faq-title">Visión</h3>
                         </div>
                      </div>

                      <div class="choose__faq-content">
                         <p class="choose__faq-descripiton">
                            Ser el banco líder en Guatemala para empresas oficiales, 
                            reconocido por nuestra excelencia en servicios financieros, 
                            compromiso con el desarrollo económico y soluciones 
                            innovadoras, promoviendo un crecimiento sostenible y un 
                            impacto positivo en la sociedad.
                         </p>
                      </div>
                   </div>

                   <div class="choose__faq-item">
                      <div class="choose_faq-header">
                         <div class="choose__faq-icon">
                            <i class="ri-add-line"></i>
                         </div>

                         <div>
                            <h3 class="choose__faq-title">Valores</h3>
                         </div>
                      </div>

                      <div class="choose__faq-content">
                         <p class="choose__faq-descripiton">
                            Integridad, Pasión, Excelencia, Transparencia, 
                            Respeto, Confiabilidad, Prudencia, Compromiso, Seguro, 
                            Liderazgo y sobre todo esto: 
                            <br>
                            <br>
                            El trabajo bien Echo

                         </p>
                      </div>
                   </div>
                </div>
             </div>
          </div>
       </section>
    </main>

    <div class="feedback-tab">
        <button onclick="toggleFeedbackForm()">Comente</button>
    </div>
    <div class="feedback-form" id="feedbackForm">
        <div class="form-header">
            <img src="assets/img/fav-icon.png" alt="BAC" class="logo">
            <br>
            <h2>¡Nos gustaría escuchar su opinión!</h2>
            <button class="close-btn" onclick="toggleFeedbackForm()">X</button>
        </div>
        <form>
            <div class="form-group">
                <label>Con base en su última experiencia en la página web, ¿qué tan probable es que recomiende BAC Credomatic a un amigo o familiar?</label>
                <div class="rating">
                    <label><input type="radio" name="rating" value="0"> 0</label>
                    <label><input type="radio" name="rating" value="1"> 1</label>
                    <label><input type="radio" name="rating" value="2"> 2</label>
                    <label><input type="radio" name="rating" value="3"> 3</label>
                    <label><input type="radio" name="rating" value="4"> 4</label>
                    <label><input type="radio" name="rating" value="5"> 5</label>
                    <label><input type="radio" name="rating" value="6"> 6</label>
                    <label><input type="radio" name="rating" value="7"> 7</label>
                    <label><input type="radio" name="rating" value="8"> 8</label>
                    <label><input type="radio" name="rating" value="9"> 9</label>
                    <label><input type="radio" name="rating" value="10"> 10</label>
                </div>
            </div>
            <div class="form-group">
                <label>¿Sobre cuál tema es su opinión?</label>
                <select name="topic">
                    <option value="chatbot">Chatbot</option>
                    <option value="error">Reportar un error del sitio web</option>
                    <option value="info">Necesito información de algún producto o servicio</option>
                    <option value="complaint">Consulta o reclamo sobre un cargo o cobro</option>
                    <option value="credentials">Mis credenciales de ingreso a Banca en Línea</option>
                    <option value="other">Otro tema</option>
                </select>
            </div>
            <div class="form-group">
                <label>¿Pudo cumplir el propósito principal de su visita el día de hoy?</label>
                <div class="yes-no">
                    <label><input type="radio" name="purpose" value="yes"> Sí</label>
                    <label><input type="radio" name="purpose" value="no"> No</label>
                </div>
            </div>
            <button type="submit" class="btn" onclick="showAlert()">Enviar</button>
        </form>
    </div>
    <!--==================== FOOTER ====================-->
    <footer>
      <div class="footer__content">
         <div class="contact-info">
             <p class="footer-contact">
                 <strong>
                    <i class="ri-phone-fill" style="width: 20px;"></i>
                    Teléfono:
                 </strong>
                 2411-6000
             </p>
             <p class="footer-contact">
                 <i class="ri-customer-service-line" style="width: 20px;"></i>
                 <strong>PBX:</strong>
                 1717
             </p>
             <p class="footer-address">
                 <i class="ri-map-pin-2-fill" style="width: 20px;"></i>
                 <strong>Dirección: </strong>
                 Vía 5 5-35 Zona 4, Ciudad de Guatemala, Guatemala.
             </p>
         </div>
         <div class="social-icons">
             <a href="https://www.facebook.com"><i class="ri-facebook-fill"></i></a>
             <a href="https://www.instagram.com"><i class="ri-instagram-fill"></i></a>
             <a href="https://www.instagram.com"><i class="ri-twitter-fill"></i></a>
             <a href="https://www.youtube.com"><i class="ri-youtube-fill"></i></a>
             <a href="https://www.whatsapp.com"><i class="ri-whatsapp-fill"></i></a>
         </div>
     </div>
      <section class="footer-bottom">
          <p>2024 © Todos los derechos reservados.</p>
      </section>
  </footer>

    <!--========== SCROLL UP ==========-->
    <a href="#" class="scrollup" id="scroll-up">
       <i class="ri-arrow-up-line"></i>
    </a>

    <!--========== SCROLLREVEAL ==========-->
    <script src="assets/js/scrollreveal.min.js"></script>

    <!--=============== SWIPER JS ===============-->
    <script src="assets/js/swiper-bundle.min.js"></script>

    <!--=============== MAIN JS ===============-->
    <script src="assets/js/main.js"></script>
    </body>
</html>
