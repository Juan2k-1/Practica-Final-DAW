document.addEventListener("DOMContentLoaded", function () {
    var nameInput = document.getElementById("nombre");

    nameInput.addEventListener("blur", function () {
        var name = nameInput.value;
        var nameRegex = /^[a-zA-ZáéíóúñÁÉÍÓÚÑ ]{2,}$/;

        if (nameRegex.test(name)) {
            // Nombre válido, no hacer nada
        } else {
            alert("El nombre debe incluir solo letras, y no debe contener caracteres especiales como /, *, `, - y otros.");
            nameInput.value = ""; // Limpiar el campo de contraseña
        }
    });
});


