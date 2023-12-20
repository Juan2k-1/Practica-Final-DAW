<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="juan.practica.daw.models.Vuelo"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Resumen de Vuelo</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
                <!-- Contenido principal -->
                <div class="w3-container w3-white w3-padding-16 w3-margin-top">
                    <h2>Resumen del Vuelo Seleccionado</h2>

                    <div class="w3-card w3-padding w3-margin-bottom">
                        <c:choose>
                            <c:when test="${not empty requestScope.vueloSeleccionado}">
                                <p><strong>ID del Vuelo:</strong> ${vueloSeleccionado.id}</p>
                                <p><strong>Fecha:</strong> ${vueloSeleccionado.fecha != null ? vueloSeleccionado.fecha : ''}</p>
                                <p><strong>Hora de Salida:</strong> ${vueloSeleccionado.horaSalida != null ? vueloSeleccionado.horaSalida : ''}</p>
                                <p><strong>Hora de Llegada:</strong> ${vueloSeleccionado.horaLlegada != null ? vueloSeleccionado.horaLlegada : ''}</p>
                                <p><strong>Estado:</strong> ${vueloSeleccionado.estado}</p>
                                <p><strong>Puerta de Embarque:</strong> ${vueloSeleccionado.puertaDeEmbarque}</p>
                                <p><strong>Ciudad Origen:</strong> ${vueloSeleccionado.ciudadOrigen}</p>
                                <p><strong>Ciudad Destino:</strong> ${vueloSeleccionado.ciudadDestino}</p>
                            </c:when>
                            <c:otherwise>
                                <p>No se ha seleccionado ningún vuelo.</p>
                            </c:otherwise>
                        </c:choose>                
                    </div>          
                    <a href="${pageContext.request.contextPath}/Vuelos/MostrarVuelos/SeleccionarVuelo/ComprarBilletes/" class="w3-button w3-blue w3-right">Comprar Billetes</a>
                </div>
            </div>
        </header>
    </body>
</html>