package co.com.tyba.certificacion.metrocuadrado.exceptions.creditohipotecario;

public class FalloVerificacionCalculoException extends AssertionError {

    public static final String FALLO_EN_CALCULO = "El resultado esperado no es igual al obtenido";


    public FalloVerificacionCalculoException(String message, Throwable cause) {
        super(message, cause);
    }

}
