<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Buena Vida webApp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/css/w3.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            body,h1,h2,h3,h4,h5,h6 {
                font-family: Helvetica, Arial, sans-serif
            }
            @media screen and (max-width: 600px) {
                header .w3-bar {
                    display: none;
                }

                header .w3-bar.w3-blue {
                    display: block;
                }
            }
        </style>
    </head>
    <body class="w3-light-grey">

        <!-- Barra de navegación -->
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

        <!-- Cabecera -->
        <header class="w3-display-container">
            <img class="w3-image" src="${pageContext.request.contextPath}/images/city2.jpg" alt="London" style="width: 100%; height: 100vh; object-fit: cover;"/>
            <div class="w3-display-middle " style="width:65%">
                <div class="w3-bar w3-blue">
                    <button class="w3-bar-item w3-text-black w3-blue"><i class="fa fa-plane w3-margin-right"></i><strong>Vuelos</strong></button>                  
                </div>

                <!-- Pestañas -->
                <div id="Vuelos" class="w3-container w3-white w3-padding-16">
                    <h3>Viaja a través del mundo con nosotros</h3>
                    <form action="${pageContext.request.contextPath}/Vuelos/MostrarVuelos/" method="get">
                        <div class="w3-row-padding" style="margin:0 -16px;">
                            <p class="w3-block w3-left-align">Selecciona tu vuelo</p>
                            <div id="menuContent" class="w3-half">
                                <label for="origen">Desde:</label>
                                <input class="w3-input w3-border" type="text" name="origen" placeholder="Origen" required>
                            </div>
                            <div class="w3-half">
                                <label for="destino">A:</label>
                                <input class="w3-input w3-border" id="destino" name="destino" type="text" placeholder="Destino" value="" required>
                            </div>
                            <div class="w3-half">
                                <label for="ida">Fecha ida:</label>
                                <input class="w3-input w3-border" type="date" name="ida" id="ida" required>
                            </div>
                            <div class="w3-half">
                                <label for="vuelta">Fecha vuelta:</label>
                                <input class="w3-input w3-border" type="date" id="vuelta">
                            </div>
                        </div>
                        <p>
                            <button type="submit" class="w3-button w3-black">Buscar y encontrar vuelos</button>
                        </p>
                    </form>              
                </div>
        </header>

        <!-- Contenido de la página -->
        <div class="w3-content" style="max-width:1100px;">
            <div class="w3-container w3-margin-top">
                <h3>Ofertas que no te puedes perder</h3>
                <h6>Hasta el <strong>50%</strong> de descuento.</h6>
            </div>
            <div class="w3-row-padding w3-text-white w3-large">
                <div class="w3-half w3-margin-bottom">
                    <div class="w3-display-container">
                        <img src="${pageContext.request.contextPath}/images/cinqueterre.jpg" alt="Cinque Terre" style="width:100%;">
                        <span id="CinqueTerre" class="w3-display-bottomleft w3-padding " style="cursor:pointer">Cinque Terre</span>
                    </div>
                </div>
                <div class="w3-half">
                    <div class="w3-row-padding" style="margin:0 -16px">
                        <div class="w3-half w3-margin-bottom">
                            <div class="w3-display-container">
                                <img src="${pageContext.request.contextPath}/images/newyork2.jpg" alt="New York" style="width:100%;">
                                <span id="NewYork" class="w3-display-bottomleft w3-padding" style="cursor:pointer">New York</span>
                            </div>
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <div class="w3-display-container">
                                <img src="${pageContext.request.contextPath}/images/sanfran.jpg" alt="San Francisco" style="width:100%;">
                                <span id="SanFrancisco" class="w3-display-bottomleft w3-padding" style="cursor:pointer">San Francisco</span>
                            </div>
                        </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px">
                        <div class="w3-half w3-margin-bottom">
                            <div class="w3-display-container">
                                <img src="${pageContext.request.contextPath}/images/pisa.jpg" alt="Pisa" style="width:100%;">
                                <span id="Pisa" class="w3-display-bottomleft w3-padding" style="cursor:pointer">Pisa</span>
                            </div>
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <div class="w3-display-container">
                                <img src="${pageContext.request.contextPath}/images/paris.jpg" alt="Paris" style="width:100%;">
                                <span id="Paris" class="w3-display-bottomleft w3-padding" style="cursor:pointer">Paris</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="w3-container">
                <h2>Contacto</h2>
                <p>¡Déjanos organizar tu próximo viaje!</p>
                <i class="fa fa-map-marker" style="width:30px"></i> Huelva, ES<br>
                <i class="fa fa-phone" style="width:30px"></i> Teléfono: +34 1234567<br>
                <i class="fa fa-envelope" style="width:30px"> </i> Email: BuenaVida@mail.com<br>
                <form action="" target="_blank">
                    <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Nombre" required name="Nombre"></p>
                    <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Email" required name="Email"></p>
                    <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Mensaje" required name="Mensaje"></p>
                    <p><button class="w3-button w3-black w3-padding-large" type="submit">ENVIAR MENSAJE</button></p>
                </form>
            </div>
            <!-- Final del contenido de la página -->
        </div>

        <!-- Pie de página -->
        <footer class="w3-container w3-center w3-opacity w3-margin-bottom">
            <h5>Encuéntranos en</h5>
            <div class="w3-xlarge w3-padding-16">
                <i class="fa fa-facebook-official w3-hover-opacity" style="cursor:pointer; margin:5px;"></i>
                <i class="fa fa-instagram w3-hover-opacity" style="cursor:pointer; margin:5px;"></i>
                <i class="fa fa-snapchat w3-hover-opacity" style="cursor:pointer; margin:5px;"></i>
                <i class="fa fa-pinterest-p w3-hover-opacity" style="cursor:pointer; margin:5px;"></i>
                <i class="fa fa-twitter w3-hover-opacity" style="cursor:pointer; margin:5px;"></i>
                <i class="fa fa-linkedin w3-hover-opacity" style="cursor:pointer; margin:5px;"></i>
            </div>
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank" class="w3-hover-text-green">w3.css</a></p>
        </footer>
        <script src="${pageContext.request.contextPath}/js/Script_ClickImages.js" type="text/javascript"></script>
    </body>
</html>
