document.addEventListener("DOMContentLoaded", function () {
    var userInput = document.getElementById("usuario");

    userInput.addEventListener("blur", function () {
        var user = userInput.value;
        var userRegex = /^[a-zA-Z0-9]{2,}$/;

        if (userRegex.test(user)) {
            // Usuario válido, no hacer nada
        } else {
            alert("El nombre de usuario debe incluir letras y números, y no debe contener caracteres especiales como /, *, `, - y otros.");
            userInput.value = ""; // Limpiar el campo de contraseña
        }
    });
});


