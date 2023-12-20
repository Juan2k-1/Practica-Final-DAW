$(document).ready(function() {
    $('button').on('click', function(event) {
        event.preventDefault();  // Evita la acción predeterminada del botón

        // Obtiene el ID del vuelo seleccionado
        var idVueloSeleccionado = $('input[name="seleccionVuelo"]:checked').val();

        // Actualiza el valor del campo oculto con el ID del vuelo seleccionado
        $('#vueloSeleccionadoId').val(idVueloSeleccionado);

        // Envía el formulario al servlet
        $('#seleccionarVueloForm').submit();
    });
});

