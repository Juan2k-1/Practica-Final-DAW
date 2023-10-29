// Obtener los nombres de las imágenes por su ID
var imagenCinqueTerre = document.getElementById("CinqueTerre");
var imagenNewYork = document.getElementById("NewYork");
var imagenSanFrancisco = document.getElementById("SanFrancisco");
var imagenPisa = document.getElementById("Pisa");
var imagenParis = document.getElementById("Paris");

var destinoInput = document.getElementById("destino");

// Agrega eventos de clic a los nombres de las imágenes
imagenCinqueTerre.addEventListener("click", function () { 
    destino.value = "Cinque Terre";
});

imagenNewYork.addEventListener("click", function () {
    destino.value = "New York";
});

imagenSanFrancisco.addEventListener("click", function () {
    destino.value = "San Francisco";
});

imagenPisa.addEventListener("click", function () {
    destino.value = "Pisa";
});

imagenParis.addEventListener("click", function () {
    destino.value = "Paris";
});