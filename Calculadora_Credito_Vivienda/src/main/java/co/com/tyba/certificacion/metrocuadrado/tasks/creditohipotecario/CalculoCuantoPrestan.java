package co.com.tyba.certificacion.metrocuadrado.tasks.creditohipotecario;

import co.com.tyba.certificacion.metrocuadrado.models.Datos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.tyba.certificacion.metrocuadrado.interactions.creditohipotecario.CapturarCalculoCreditoHipotecario.capturarCalculoCreditoVivienda;
import static co.com.tyba.certificacion.metrocuadrado.interactions.comunes.Esperar.unTiempo;
import static co.com.tyba.certificacion.metrocuadrado.userinterface.creditohipotecario.PaginaMetroCuadrado.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CalculoCuantoPrestan implements Task {

    private static final Logger LOGGER = LogManager.getLogger();


    public static CalculoCuantoPrestan deCuantoPrestan() {
        return instrumented(CalculoCuantoPrestan.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Enter.theValue(Datos.getMap().get("ingresosMensualesc").toString()).into(INGRESOS_MENSUALES),
                    Click.on(PLAZO_AÑOS.of(Datos.getMap().get("plazoEnAñosc").toString())),
                    Click.on(BOTON_CALCULAR_CREDITO), unTiempo(), capturarCalculoCreditoVivienda());

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}