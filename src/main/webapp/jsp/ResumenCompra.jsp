<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Resumen de Compra</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            body {
                font-family: "Helvetica", Arial, sans-serif;
            }

            .resumen-container {
                max-width: 600px;
                margin: 0 auto;
            }

            .w3-btn {
                margin-top: 20px;
            }
        </style>
    </head>
    <body class="w3-light-grey">
        <div class="w3-bar w3-white w3-border-bottom w3-xlarge">
            <a href="${pageContext.request.contextPath}/home/" class="w3-bar-item w3-button w3-text-black w3-hover-blue"><b><i class="fa fa-map-marker w3-margin-right"></i>Agencia Buena Vida</b></a>

            <%-- Verifica si hay un usuario autenticado --%>
            <%
                String usuarioAutenticado = (String) session.getAttribute("usuario");
                if (usuarioAutenticado != null && !usuarioAutenticado.isEmpty())
                {
            %>
            <a href="${pageContext.request.contextPath}/home/Logout/" class="w3-bar-item w3-button w3-right w3-text-black w3-hover-blue"><i class="fa fa-user"></i> <%= usuarioAutenticado%></a>
            <%
            } else
            {
            %>
            <a href="${pageContext.request.contextPath}/home/IniciarSesion/" class="w3-bar-item w3-button w3-right w3-text-black w3-hover-blue"><i class="fa fa-user"></i> Iniciar sesión</a>
            <%
                }
            %>
                    <!--<a href="${pageContext.request.contextPath}/home/IniciarSesion/" class="w3-bar-item w3-button w3-right w3-text-black w3-hover-blue"><i class="fa fa-user"></i> Iniciar sesión</a>-->
        </div>
        <header class="w3-display-container">
            <img class="w3-image" src="${pageContext.request.contextPath}/images/city2.jpg" alt="City" style="width: 100%; height: 100vh; object-fit: cover;"/>
            <div class="w3-display-middle" style="width:65%">
                <div class="w3-container w3-card-4 w3-white w3-margin-top resumen-container">
                    <h2 class="w3-center w3-text-black">Resumen de Compra</h2>

                    <div class="w3-row">
                        <div class="w3-col m4">
                            <p>Cantidad de Billetes:</p>
                        </div>
                        <div class="w3-col m8">
                            <p><%= request.getAttribute("cantidadBilletes")%></p>
                        </div>
                    </div>

                    <div class="w3-row">
                        <div class="w3-col m4">
                            <p>Tipo de Billete:</p>
                        </div>
                        <div class="w3-col m8">
                            <p><%= request.getAttribute("tipoBillete")%></p>
                        </div>
                    </div>

                    <div class="w3-row">
                        <div class="w3-col m4">
                            <p>Precio Total:</p>
                        </div>
                        <div class="w3-col m8">
                            <p><%= request.getAttribute("precioTotal")%> €</p>
                        </div>
                    </div>

                    <div class="w3-margin-top w3-center">
                        <a href="<%= request.getContextPath()%>/home/" class="w3-btn w3-blue w3-round-large">Volver al Inicio</a>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>


