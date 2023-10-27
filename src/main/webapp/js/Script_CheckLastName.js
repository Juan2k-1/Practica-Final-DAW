document.addEventListener("DOMContentLoaded", function () {
    var lastNameInput = document.getElementById("apellidos");

    lastNameInput.addEventListener("blur", function () {
        var lastName = lastNameInput.value;
        var lastNameRegex = /^[a-zA-ZáéíóúñÁÉÍÓÚÑ` ]{2,}$/
                ;

        if (lastNameRegex.test(lastName)) {
            // Nombre válido, no hacer nada
        } else {
            alert("El apellido debe incluir solo letras, y no debe contener caracteres especiales como /, *, `, - y otros.");
            lastNameInput.value = ""; // Limpiar el campo de contraseña
        }
    });
});


