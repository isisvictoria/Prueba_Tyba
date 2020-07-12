package co.com.tyba.certificacion.metrocuadrado.tasks.comunes;

import co.com.tyba.certificacion.metrocuadrado.userinterface.creditohipotecario.PaginaMetroCuadrado;
import co.com.tyba.certificacion.metrocuadrado.utilities.properties.GeneralProperties;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.thucydides.core.pages.PageObject.withParameters;

public class Abrir implements Task {
    private static final Logger LOGGER = LogManager.getLogger(Abrir.class.getName());
    PaginaMetroCuadrado paginaMetroCuadrado = new PaginaMetroCuadrado();

    public static Abrir abrirElSitioMetroCuadrado() {
        return Tasks.instrumented(Abrir.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String strUrl1;
        try {
            strUrl1 = GeneralProperties.getUrlFrontMetroCuadrado();
            paginaMetroCuadrado.open("open.metrocuadrado", withParameters(strUrl1));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
