package co.com.tyba.certificacion.metrocuadrado.interactions.creditohipotecario;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.tyba.certificacion.metrocuadrado.userinterface.creditohipotecario.PaginaMetroCuadrado.RESULTADO_CALCULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CapturarCalculoCreditoHipotecario implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elementosCalculo = RESULTADO_CALCULO.resolveAllFor(actor);

        List<Map<String, String>> informacionCalculo = new ArrayList<>();
        Map<String, String> calculo = new HashMap<>();
        calculo.put("ingresoMensual", elementosCalculo.get(0).findElements(By.className("ng-binding")).get(0).getText());
        calculo.put("valorPrestamo", elementosCalculo.get(0).findElements(By.className("ng-binding")).get(1).getText());
        calculo.put("cuotaInicialMinima", elementosCalculo.get(0).findElements(By.className("ng-binding")).get(2).getText());
        calculo.put("valorInmueble", elementosCalculo.get(0).findElements(By.className("ng-binding")).get(3).getText());
        informacionCalculo.add(calculo);
        actor.remember("informacionCalculada", informacionCalculo);
    }

    public static Interaction capturarCalculoCreditoVivienda() {
        return instrumented(CapturarCalculoCreditoHipotecario.class);
    }

}
