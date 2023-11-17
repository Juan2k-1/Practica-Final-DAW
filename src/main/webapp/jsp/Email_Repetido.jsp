<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro Fallido</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-content w3-center" style="max-width:500px;margin-top:80px">
            <div class="w3-card w3-round w3-white">
                <div class="w3-container">
                    <h2 class="w3-center">¡Registro Fallido!</h2>
                    <p>Hubo un problema al crear tu cuenta. El nickName introducido ya existe.</p>
                    <a href="${pageContext.request.contextPath}/home/IniciarSesion/" class="w3-button w3-block w3-red w3-section">Volver a Intentar</a>
                </div>
            </div>
        </div>
    </body>
</html>
