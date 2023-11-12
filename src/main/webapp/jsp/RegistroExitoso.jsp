<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro Exitoso</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-content w3-center" style="max-width:500px;margin-top:80px">
            <div class="w3-card w3-round w3-white">
                <div class="w3-container">
                    <h2 class="w3-center">¡Registro Exitoso!</h2>
                    <p>Tu cuenta ha sido creada con éxito. Ahora puedes iniciar sesión con tus credenciales.</p>
                    <a href="${pageContext.request.contextPath}/jsp/InicioSesion.jsp" class="w3-button w3-block w3-blue w3-section">Iniciar Sesión</a>
                </div>
            </div>
        </div>
    </body>
</html>