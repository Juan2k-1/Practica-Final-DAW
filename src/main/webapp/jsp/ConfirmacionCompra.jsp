<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmación de Compra</title>
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-white w3-padding-16">
            

            <!-- Script para mostrar un alert si hay un mensaje de error -->
            <script>
                var mensajeError = '<%= request.getAttribute("mensajeError")%>';
                if (mensajeError && mensajeError.length > 0) {
                    alert(mensajeError);
                }
            </script>
        </div>
    </body>
</html>
