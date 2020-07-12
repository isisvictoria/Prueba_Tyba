package co.com.tyba.certificacion.metrocuadrado.utilities.managers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {

    private static final Logger LOGGER = LogManager.getLogger(DateManager.class);
    private static final String UTILS_MESSAGE = "Clase Utils";
    private static final String BAD_FORMAT = "Se produjo un error inesperado al crear el formato de la fecha";
    private static final String VACIO = "";

    private DateManager() {
        throw new IllegalStateException(UTILS_MESSAGE);
    }

    public static String obtenerFechaSistema(String strFormat) {
        String result = VACIO;
        SimpleDateFormat fechaActual;
        try {
            fechaActual = new SimpleDateFormat(strFormat);
            result = fechaActual.format(new Date());
        } catch (NumberFormatException e) {
            LOGGER.info(e.getMessage(), BAD_FORMAT);
        }
        return result;
    }


}