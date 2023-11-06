<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/w3.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/misEstilos.css" type="text/css"/>
        <style>
            .form-container input[type="text"],
            .form-container input[type="password"] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .form-container input[type="submit"] {
                width: 100%;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .form-container input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>

        <div class="w3-bar w3-white w3-border-bottom w3-xlarge">
            <a href="index.jsp" class="w3-bar-item w3-button w3-text-black w3-hover-blue"><b><i class="fa fa-map-marker w3-margin-right"></i>Agencia Buena Vida</b></a>
            <a href="InicioSesion.jsp" class="w3-bar-item w3-button w3-right w3-text-black w3-hover-blue"><i class="fa fa-user"></i> Iniciar sesión</a>           
        </div>

        <header class="w3-display-container">
            <img class="w3-image" src="images/city2.jpg" alt="London" style="width: 100%; height: 100vh; object-fit: cover;"/>
            <div class="w3-container form-container w3-display-topmiddle" style="width:75%">
                <form id="form1" action="${pageContext.request.contextPath}/CrearCuenta" method="post" onsubmit="return validaAltaUsuario()" class="w3-container w3-card-4">
                    <h2 class="w3-center w3-text-blue"><strong>Crear cuenta</strong></h2>

                    <label for="usuario">Usuario:</label>
                    <input type="text" id="usuario" name="usuario" class="w3-input" required autocomplete="off">

                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" class="w3-input" required autocomplete="off">

                    <label for="repit_password">Repetir Contraseña:</label>
                    <input type="password" id="repit_password" name="repit_password" class="w3-input" required autocomplete="off">

                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" class="w3-input" required autocomplete="off">

                    <label for="apellidos">Apellidos:</label>
                    <input type="text" id="apellidos" name="apellidos" class="w3-input" required autocomplete="off">

                    <label for="email">Correo Electrónico:</label>
                    <input type="text" id="email" name="email" class="w3-input" required autocomplete="off">

                    <input type="submit" value="Registrarse" class="w3-button w3-blue">
                </form>
            </div>
        </header>

        <script src="js/Script_CheckPassword.js" type="text/javascript"></script>
        <script src="js/Script_RepitPassword.js" type="text/javascript"></script>
        <script src="js/Script_CheckEmail.js" type="text/javascript"></script>
        <script src="js/Script_CheckLastName.js" type="text/javascript"></script>
        <script src="js/Script_CheckName.js" type="text/javascript"></script>
        <script src="js/Script_CheckUser.js" type="text/javascript"></script>
    </body>
</html>
