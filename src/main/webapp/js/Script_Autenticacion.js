function submitForm(event) {
    event.preventDefault();

    const usuario = document.getElementById('usuario').value;
    const contraseña = document.getElementById('contraseña').value;

    const requestBody = new URLSearchParams();
    requestBody.append('usuario', usuario);
    requestBody.append('contraseña', contraseña);

    console.log('Usuario:', usuario);
    console.log('Contraseña:', contraseña);

    fetch(contextoDeLaAplicacion + '/home/IniciarSesion/Autenticacion/', {
        method: 'POST',
        body: requestBody,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
            .then(response => {
                if (response.ok) {
                    console.log('Formulario enviado');  // Mensaje de consola
                    window.location.href = contextoDeLaAplicacion + '/home/';
                } else {
                    // Muestra un alerta con el mensaje de error
                    alert('Error en la autenticación. Por favor, verifica tus credenciales.');
                }
            })
            .catch(error => {
                // Muestra un alerta en caso de un error en la solicitud AJAX
                alert('Error en la solicitud AJAX. Por favor, intenta nuevamente.');
            });
}