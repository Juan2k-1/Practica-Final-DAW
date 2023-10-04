
/* Este script permite cambiar entre diferentes secciones de contenido 
 * (definidas por elementos con la clase myLink) 
 * haciendo clic en pestañas (definidas por elementos con la clase tablink). 
 * Cuando se hace clic en una pestaña, 
 * se oculta el contenido de las otras secciones 
 * y se muestra solo el contenido de la sección correspondiente 
 * a la pestaña seleccionada. 
 * La pestaña seleccionada también se resalta visualmente con un color de fondo azul*/
function openLink(evt, linkName) {
    var i, x, tablinks;
    x = document.getElementsByClassName("myLink");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < x.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" w3-blue", "");
    }
    document.getElementById(linkName).style.display = "block";
    evt.currentTarget.className += " w3-blue";
}

// Click on the first tablink on load
document.getElementsByClassName("tablink")[0].click();



