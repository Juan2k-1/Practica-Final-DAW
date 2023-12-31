<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar Sesión</title>
        <link href="${pageContext.request.contextPath}/css/w3.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/misEstilos.css" type="text/css"/>
        <style>
            p {
                display: inline;
                font-size: 14px;
                margin-left: 50px;

            }
            a {
                display: inline;
            }

            @media screen and (max-width: 600px) {
                p {
                    display: block;
                    margin-left: 0px;
                    margin-top: 15px;
                    margin-bottom: 0px;

                }
                a .w3-right {
                    display: block;
                    margin-left: 0px;
                    float:left!important
                }
            }
        </style>
    </head>
    <script>
        var contextoDeLaAplicacion = '<%= request.getContextPath()%>';
    </script>
    <body>      
        <!-- Barra de navegación -->
        <div class="w3-bar w3-white w3-border-bottom w3-xlarge">
            <a href="${pageContext.request.contextPath}/home/" class="w3-bar-item w3-button w3-text-black w3-hover-blue"><b><i class="fa fa-map-marker w3-margin-right"></i>Agencia Buena Vida</b></a>
            <a href="${pageContext.request.contextPath}/home/IniciarSesion/" class="w3-bar-item w3-button w3-right w3-text-black w3-hover-blue"><i class="fa fa-user"></i> Iniciar sesión</a>           
        </div>
        
        <%
            String mensajeError = (String) request.getAttribute("mensajeError");
            if (mensajeError != null && !mensajeError.isEmpty())
            {
        %>
        <script>
            alert("<%= mensajeError%>");
        </script>
        <%
            }
        %>

        <header class="w3-display-container">
            <img class="w3-image" src="${pageContext.request.contextPath}/images/city2.jpg" alt="London" style="width: 100%; height: 100vh; object-fit: cover;"/>
            <div class="login-container w3-card-4 w3-display-topmiddle">
                <form class="w3-container" id="formLogin" onsubmit="submitForm(event)">
                    <label class="w3-text-blue"><b><strong>Usuario</strong></b></label>
                    <input id="usuario" class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Ingresa tu usuario" name="usuario" required autocomplete="off">

                    <label class="w3-text-blue"><b><strong>Contraseña</strong></b></label>
                    <input id="contraseña" class="w3-input w3-border" type="password" placeholder="Ingresa tu contraseña" name="contraseña" value="" required autocomplete="off">

                    <button type="submit" class="w3-button w3-blue w3-margin-top">Iniciar Sesión</button>
                    <p>¿No tienes cuenta? Regístrate</p>
                    <a href="${pageContext.request.contextPath}/home/IniciarSesion/CrearCuenta/" class="w3-button w3-blue w3-margin-top w3-right">Registrarse</a>
                </form>
            </div>
        </header>
        <script src="${pageContext.request.contextPath}/js/Script_RefreshLogin.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/Script_Autenticacion.js" type="text/javascript"></script>
    </body>
</html>
