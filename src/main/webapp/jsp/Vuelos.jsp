<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Vuelos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {
                font-family: Helvetica, Arial, sans-serif
            }
            td, th {
                font-size: 16px;
                border: 0.5px groove #ddd; /* Grosor y color del borde */
                padding: 5px;
                white-space: nowrap;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            @media screen and (max-width: 600px) {
                header .w3-bar  {
                    display: none;
                }

                header .w3-bar.w3-blue {
                    display: block;
                }

                #vuelosMenuBtn {
                    display: block;
                }
                /* Estilo para mostrar las cabeceras en una fila */
                .table-header-row {
                    display: grid;
                    grid-template-columns: 1fr 1fr; /* Tres columnas iguales */
                    width: 100%;
                }

                /* Estilo para mostrar las columnas en filas */
                .table-row {
                    display: grid;
                    grid-template-columns: 1fr 1fr; /* Tres columnas iguales */
                    width: 100%;
                }

                /* Evitar que el texto se rompa en varias líneas */
                .table-row td, .table-header-row th {
                    white-space: nowrap;
                }
                /* Colocar los radio buttons a la derecha */
                .radio-derecha {
                    float: none;
                    display: block;
                    text-align: right;
                }
                .w3-container.w3-white.w3-padding-16 {
                    width: 100%;
                    box-sizing: border-box; /* Incluye el borde y el relleno en el ancho total */
                }
            }
        </style>
    </head>
    <body>
        <!-- Barra de navegación -->
        <div class="w3-bar w3-white w3-border-bottom w3-xlarge">
            <a href="${pageContext.request.contextPath}/jsp/index.jsp" class="w3-bar-item w3-button w3-text-black w3-hover-blue"><b><i class="fa fa-map-marker w3-margin-right"></i>Agencia Buena Vida</b></a>
            <a href="${pageContext.request.contextPath}/jsp/InicioSesion.jsp" class="w3-bar-item w3-button w3-right w3-text-black w3-hover-blue"><i class="fa fa-user"></i> Iniciar sesión</a>
        </div>

        <header class="w3-display-container">
            <img class="w3-image" src="${pageContext.request.contextPath}/images/city2.jpg" alt="London" style="width: 100%; height: 100vh; object-fit: cover;"/>
            <div class="w3-display-middle" style="width:95%">
                <table class="w3-table w3-bordered w3-white">
                    <thead class="table-header-row">
                        <tr class="w3-blue table-row">
                            <th><strong>Origen</strong></th>
                            <th><strong>Destino</strong></th>
                            <th><strong>Hora de Salida</strong></th>
                            <th><strong>Fecha</strong></th>
                            <th><strong>Estado</strong></th>
                            <th><strong>Puerta de Embarque</strong></th>
                            <th><strong></strong></th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Aquí puedes insertar dinámicamente los datos de los vuelos seleccionados por el usuario -->
                        <tr class="table-row">
                            <td>Ciudad de Origen</td>
                            <td>Ciudad de Destino</td>
                            <td>12:00 PM</td>
                            <td>11-01-2023</td>
                            <td>En hora</td>
                            <td>Puerta 3</td>
                            <td class="w3-hide-large">¿Seleccionar?</td>
                            <td><input type="radio" name="seleccion" class="radio-derecha"></td>
                        </tr>
                        <tr class="table-row">
                            <td>Ciudad de Origen</td>
                            <td>Ciudad de Destino</td>
                            <td>12:00 PM</td>
                            <td>11-01-2023</td>
                            <td>En hora</td>
                            <td>Puerta 3</td>
                            <td class="w3-hide-large">¿Seleccionar?</td>
                            <td><input type="radio" name="seleccion" class="radio-derecha"></td>
                        </tr>
                        <tr class="table-row">
                            <td>Ciudad de Origen</td>
                            <td>Ciudad de Destino</td>
                            <td>12:00 PM</td>
                            <td>11-01-2023</td>
                            <td>En hora</td>
                            <td>Puerta 3</td>
                            <td class="w3-hide-large">¿Seleccionar?</td>
                            <td><input type="radio" name="seleccion" class="radio-derecha"></td>
                        </tr>
                    </tbody>
                </table>
                <div class="w3-container w3-white w3-padding-16">
                    <button class="w3-button w3-blue w3-right">Seleccionar</button>
                </div>
            </div>
        </header>
    </body>
</html>
