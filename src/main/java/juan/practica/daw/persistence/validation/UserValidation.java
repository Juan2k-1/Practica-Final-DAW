package juan.practica.daw.persistence.validation;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public class UserValidation {
    
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^[a-zA-ZáéíóúñÁÉÍÓÚÑ ]{2,}$");
    }
    
    public static boolean validarApellidos(String apellidos) {
        return apellidos.matches("^[a-zA-ZáéíóúñÁÉÍÓÚÑ` ]{2,}$");
    }
    
    public static boolean validarContraseña(String contraseña) {
        return contraseña.matches("^[a-zA-Z0-9]{8,}$");
    }
    
    public static boolean validarRepitContraseña(String contraseña) {
        return contraseña.matches("^[a-zA-Z0-9]{8,}$");
    }
    
    public static boolean validarEmail(String email) {
        return email.matches("^[a-zA-Z0-9@.]{10,}$");
    }
    
    public static boolean validarNickName(String nickName) {
        return nickName.matches("^[a-zA-Z0-9]{2,}$");
    }
}
