package co.com.tyba.certificacion.metrocuadrado.stepdefinitions.creditohipotecario;

import co.com.tyba.certificacion.metrocuadrado.exceptions.creditohipotecario.FalloVerificacionCalculoException;
import co.com.tyba.certificacion.metrocuadrado.tasks.comunes.Abrir;
import co.com.tyba.certificacion.metrocuadrado.tasks.fabrica.Cargar;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static co.com.tyba.certificacion.metrocuadrado.exceptions.creditohipotecario.FalloVerificacionCalculoException.FALLO_EN_CALCULO;
import static co.com.tyba.certificacion.metrocuadrado.questions.creditohipotecario.VerificarCalculo.verificarCalculo;
import static co.com.tyba.certificacion.metrocuadrado.tasks.creditohipotecario.CalculoCuantoPrestan.deCuantoPrestan;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CalculoCuantoPrentanStepDefinitions {

    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) cargo los datos para el calculo$")
    public void queCargoLosDatosParaElCalculo(String actor, List<Map<String, Object>> informacion) {
        theActorCalled(actor).wasAbleTo(Cargar.cargoLosDatosParaLaConsultaConLaSiguiente(informacion));

    }

    @Cuando("^realizo el calculo$")
    public void realizoElCalculo() {
        theActorInTheSpotlight().attemptsTo(
                Abrir.abrirElSitioMetroCuadrado(), deCuantoPrestan());

    }

    @Entonces("^verifico el resultado exitoso del calculo$")
    public void verificoElResultadoExitosoDelCalculo() {
        theActorInTheSpotlight().should(seeThat(verificarCalculo()).orComplainWith(FalloVerificacionCalculoException.class, FALLO_EN_CALCULO));

    }


}