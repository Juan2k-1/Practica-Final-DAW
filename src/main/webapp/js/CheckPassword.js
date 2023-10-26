document.addEventListener("DOMContentLoaded", function () {
    var passwordInput = document.getElementById("password");

    passwordInput.addEventListener("blur", function () {
        var password = passwordInput.value;
        var passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)[A-Za-z\d]{8,}$/;

        if (passwordRegex.test(password)) {
            // Contraseña válida, no hacer nada
        } else {
            alert("La contraseña debe contener al menos 8 caracteres, incluyendo letras y números, y no debe contener caracteres especiales como /, *, `, - y otros.");
            passwordInput.value = ""; // Limpiar el campo de contraseña
        }
    });
});


