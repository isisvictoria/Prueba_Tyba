package co.com.tyba.certificacion.metrocuadrado.questions.creditohipotecario;


import co.com.tyba.certificacion.metrocuadrado.models.Datos;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.tyba.certificacion.metrocuadrado.utilities.constant.ConstantManager.REPORTS_SERENITY;
import static co.com.tyba.certificacion.metrocuadrado.utilities.constant.ValidarCampos.clearReport;
import static co.com.tyba.certificacion.metrocuadrado.utilities.constant.ValidarCampos.validarCampo;


public class VerificarCalculo implements Question {
    private static final Logger LOGGER = LogManager.getLogger("");


    public static VerificarCalculo verificarCalculo() {
        return new VerificarCalculo();
    }

    @Override
    public Object answeredBy(Actor actor) {
        clearReport();
        boolean resulValidation = false;

        List<Map<String, String>> resultadoObtenidoFront = actor.recall("informacionCalculada");

        if (!resultadoObtenidoFront.isEmpty()) {
            resulValidation = true;

            resulValidation = validarCampo("ingreso mensual", resultadoObtenidoFront.get(0).get("ingresoMensual").replace("$", "").replace(",", "").trim(), Datos.getMap().get("ingresosMensualesc").toString(), resulValidation);
            resulValidation = validarCampo("valor prestamo", resultadoObtenidoFront.get(0).get("valorPrestamo").replace("$", "").replace(",", "").trim(), Datos.getMap().get("valorPrestamoc").toString(), resulValidation);
            resulValidation = validarCampo("cuota inicial minima", resultadoObtenidoFront.get(0).get("cuotaInicialMinima").replace("$", "").replace(",", "").trim(), Datos.getMap().get("cuotaInicialMinimac").toString(), resulValidation);
            resulValidation = validarCampo("valor inmueble", resultadoObtenidoFront.get(0).get("valorInmueble").replace("$", "").replace(",", "").trim(), Datos.getMap().get("valorInmueblec").toString(), resulValidation);
        }
        Serenity.recordReportData().withTitle("Resultado verificacion calculo cuanto prestan").andContents(Serenity.sessionVariableCalled(REPORTS_SERENITY));
        return resulValidation;
    }
}
