document.addEventListener("DOMContentLoaded", function () {
    var repit_passwordInput = document.getElementById("repit_password");
    var passwordInput = document.getElementById("password");

    repit_passwordInput.addEventListener("blur", function () {
        
        var repitPassword = repit_passwordInput.value;
        var password = passwordInput.value;
        
        if (password === repitPassword) {
            // Contraseña válida, no hacer nada
        } else {
            alert("Error, las contraseñas no coinciden");
            repit_passwordInput.value = "";
        }
    });
});


