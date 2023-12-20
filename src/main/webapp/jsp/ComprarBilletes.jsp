<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Comprar Billetes</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/misEstilos.css" type="text/css"/>
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
        <script>
            var plazasDisponibles = <%= request.getAttribute("plazasDisponibles")%>;

            function verificarCantidadBilletes() {
                var cantidadBilletes = parseInt(document.getElementById("cantidadBilletes").value);
                if (isNaN(cantidadBilletes) || cantidadBilletes <= 0 || cantidadBilletes > plazasDisponibles) {
                    alert("La cantidad de billetes debe ser un número positivo y no puede exceder las plazas disponibles.");
                    return false;
                }
                return true;
            }
        </script>
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

        <header class="w3-display-container">
            <img class="w3-image" src="${pageContext.request.contextPath}/images/city2.jpg" alt="City" style="width: 100%; height: 100vh; object-fit: cover;"/>
            <div class="w3-display-middle" style="width:65%">
                <div class="w3-container w3-card-4 w3-white w3-padding-32">
                    <h1 class=" w3-center w3-text-black">Comprar Billetes</h1>

                    <form action="${pageContext.request.contextPath}/Vuelos/MostrarVuelos/SeleccionarVuelo/ProcesarCompra/" method="post" class="w3-container">
                        <label for="cantidadBilletes" class="w3-text-black">Cantidad de Billetes:</label>
                        <input type="number" id="cantidadBilletes" name="cantidadBilletes" min="1" max="200" required class="w3-input w3-border w3-round-large">

                        <label for="tipoBillete" class="w3-text-black">Tipo de Billete:</label>
                        <select id="tipoBillete" name="tipoBillete" required class="w3-select w3-border w3-round-large">
                            <option value="PrimeraClase">Primera Clase</option>
                            <option value="Business">Business</option>
                            <option value="Turista">Turista</option>
                        </select>

                        <button type="submit" class="w3-button w3-blue w3-round-large w3-margin-top">Confirmar Compra</button>
                    </form>
                </div>
            </div>
        </header>

    </body>
</html>
