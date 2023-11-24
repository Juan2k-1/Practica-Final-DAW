<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logout</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <div class="w3-container w3-card-4 w3-light-grey" style="max-width: 400px; margin: auto; margin-top: 50px;">
            <h2 class="w3-center">¿Estás seguro de que deseas cerrar sesión?</h2>

            <form class="w3-container" action="${pageContext.request.contextPath}/home/Logout" method="post" onsubmit="showAlert()">
                <button class="w3-button w3-blue w3-center" type="submit">Cerrar Sesión</button>
            </form>
        </div>
    </body>
    <script>
        function showAlert() {
            alert('Has cerrado sesión exitosamente');
        }
    </script>
</html>
