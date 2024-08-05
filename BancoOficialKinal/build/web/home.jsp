<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banco Oficial Kinal</title>
    <link rel="stylesheet" href="./css/index.css">
    <link rel="icon" href="LogoAlpha.png" type="image/LogoAlpha.png">
</head>
<body>
    <div class="container">
        <div class="login-card">
            <div class="header-gradient"></div>
            <div class="logo">
                <img src="./img/LogoAlpha.png" alt="Logo" width="120">
            </div>
            <h2>Bienvenido de nuevo</h2>
            <p>Ingresa tu Correo y Contraseña</p>
            <form action="Validar" method="POST">
                <div class="input-group">
                    <label><strong>Usuario</strong></label>
                    <input class="form-control" type="text" name="txtUser">
                </div>
                <div class="input-group">
                    <label><strong>Contraseña</strong></label>
                    <input class="form-control" type="password" name="txtPass">
                </div>
                <div class="remember-me">
                    <input type="checkbox" id="remember-me" name="remember-me">
                    <label for="remember-me">Recuerdame la contraseña.</label>
                </div>
                <input class="btn btn-primary btn-block" type="submit" name="accion" value="Ingresar">
                <a href="#" class="forgot-password">¿Olvidaste la Contraseña?</a>
            </form>
            <div class="sign-up">
                <p>¿No tienes una Cuenta? <a href="#">Registrate aca</a></p>
            </div>
            <div class="social-login">
                <p>O te puedes registrar con:</p>
                <div class="social-icons">
                    <div class="iconogoogle">
                        <a href="#"><img src="./img/Google.png" alt="Google"></a>
                    </div>
                    <div class="iconofacebook">
                        <a href="#"><img src="./img/Facebook.png" alt="Facebook"></a>
                    </div>
                    <div class="iconolinkedin">
                        <a href="#"><img src="./img/LinkedIn.png" alt="LinkedIn"></a>
                    </div>
                    <div class="iconohub">
                        <a href="#"><img src="./img/Hub.png" alt="GitHub"></a>
                    </div>
                </div>  
            </div>
        </div>
    </div>
</body>
</html>
