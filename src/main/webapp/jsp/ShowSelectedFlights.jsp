<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="juan.practica.daw.models.Vuelo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Vuelos</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
    <script>
        var contextoDeLaAplicacion = '<%= request.getContextPath()%>';
    </script>

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
        </div>

        <header class="w3-display-container">
            <img class="w3-image" src="${pageContext.request.contextPath}/images/city2.jpg" alt="London" style="width: 100%; height: 100vh; object-fit: cover;"/>
            <div class="w3-display-middle " style="width:75%">
                <div class="w3-bar w3-blue">
                    <button class="w3-bar-item w3-text-black w3-blue"><i class="fa fa-plane w3-margin-right"></i><strong>Lista de Vuelos</strong></button>                  
                </div>

                <div class="w3-container w3-white w3-padding-16">
                    <form id="seleccionarVueloForm" action="${pageContext.request.contextPath}/Vuelos/MostrarVuelos/SeleccionarVuelo/" method="post">
                        <table id="vuelos" class="w3-table w3-striped w3-bordered">
                            <thead>
                                <tr class="w3-blue">
                                    <th>ID</th>
                                    <th>Fecha</th>
                                    <th>Hora Salida</th>
                                    <th>Hora Llegada</th>
                                    <th>Estado</th>
                                    <th>Puerta de Embarque</th>
                                    <th>Ciudad Origen</th>
                                    <th>Ciudad Destino</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                                    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
                                %>
                                <c:forEach var="vuelo" items="${requestScope.listaDeVuelos}">
                                    <tr>
                                        <td>${vuelo.id}</td>
                                        <td>${vuelo.fecha != null ? vuelo.fecha : ''}</td>
                                        <td>${vuelo.horaSalida != null ? vuelo.horaSalida : ''}</td>
                                        <td>${vuelo.horaLlegada != null ? vuelo.horaLlegada : ''}</td>
                                        <td>${vuelo.estado}</td>
                                        <td>${vuelo.puertaDeEmbarque}</td>
                                        <td>${vuelo.ciudadOrigen}</td>
                                        <td>${vuelo.ciudadDestino}</td>
                                        <td><input type="radio" name="seleccionVuelo" id="Vuelo_Seleccionado_${vuelo.id}" value="${vuelo.id}"></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div style="margin-bottom: 20px;"></div>
                        <button type="submit" class="w3-button w3-blue w3-right">Seleccionar Vuelo</button>
                        <input type="hidden" id="vueloSeleccionadoId" name="vuelo" value="">
                    </form>
                </div>
            </div>
        </header>
    </body>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js" ></script>
    <script src="${pageContext.request.contextPath}/js/Script_SeleccionarVuelo.js" type="text/javascript"></script>
</html>