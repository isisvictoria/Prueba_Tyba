package co.com.tyba.certificacion.metrocuadrado.utilities.properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class GeneralProperties {

    private static Properties prop = null;

    private GeneralProperties() {
        throw new IllegalStateException();
    }


    public static void loadProperties() throws IOException {
        if (prop == null) {
            prop = new Properties();
            File objclasspathRoot = new File(System.getProperty("user.dir"));
            String strFilePath = objclasspathRoot.getAbsolutePath();
            prop.load(new FileReader(strFilePath + "/urls.properties"));
        }
    }


    public static String getUrlFrontMetroCuadrado() throws IOException {
        loadProperties();
        return prop.getProperty("UrlMetroCuadrado");
    }
}