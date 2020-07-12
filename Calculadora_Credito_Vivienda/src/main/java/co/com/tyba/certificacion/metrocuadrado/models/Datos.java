package co.com.tyba.certificacion.metrocuadrado.models;

import java.util.Map;

public class Datos {

    private static Map<String, Object> map;

    private Datos() {
    }

    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> datos) {
        map = datos;
    }

}
