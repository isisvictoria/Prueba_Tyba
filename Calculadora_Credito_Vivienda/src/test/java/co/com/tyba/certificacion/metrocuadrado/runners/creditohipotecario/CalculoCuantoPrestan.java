package co.com.tyba.certificacion.metrocuadrado.runners.creditohipotecario;

import co.com.tyba.certificacion.metrocuadrado.utilities.constant.ConstantTypeClass;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/creditohipotecario/calculo_cuanto_prestan.feature",
        snippets = SnippetType.CAMELCASE,
        glue = {"co.com.tyba.certificacion.metrocuadrado.stepdefinitions.creditohipotecario"},
        plugin = {"json:target/cucumber_json/cucumber.json"}
)


public class CalculoCuantoPrestan {

    private CalculoCuantoPrestan() {
        throw new IllegalStateException(ConstantTypeClass.RUNNER_CLASS);
    }


}

