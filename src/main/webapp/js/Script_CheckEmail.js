document.addEventListener("DOMContentLoaded", function () {
    var emailInput = document.getElementById("email");

    emailInput.addEventListener("blur", function () {
        var email = emailInput.value;
        var emailRegex = /^[a-zA-Z0-9@.]{10,}$/;

        if (emailRegex.test(email)) {
            // Nombre válido, no hacer nada
        } else {
            alert("El email debe incluir letras o números, y no debe contener caracteres especiales como /, *, `, - y otros.");
            emailInput.value = ""; // Limpiar el campo de contraseña
        }
    });
});


