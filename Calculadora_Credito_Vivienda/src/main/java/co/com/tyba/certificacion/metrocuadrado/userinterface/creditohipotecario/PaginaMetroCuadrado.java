package co.com.tyba.certificacion.metrocuadrado.userinterface.creditohipotecario;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;


@NamedUrls(
        {
                @NamedUrl(name = "open.metrocuadrado", url = "https://{1}")
        }
)
public class PaginaMetroCuadrado extends PageObject {


    public static final Target INGRESOS_MENSUALES = Target.the("Ingresos Mensuales").located(By.id("ingresosMensuales"));
    public static final Target PLAZO_AÑOS = Target.the("Plazo en años").locatedBy("//*[@ng-model='termInYears']/child::option[text()='{0}']");
    public static final Target BOTON_CALCULAR_CREDITO = Target.the("Boton Calcular Credito").located(By.xpath("//button[contains(.,'Calcular Cr\u00e9dito')]"));
    public static final Target RESULTADO_CALCULO = Target.the("Resultado Calculo").located(By.xpath("//div[@class='col-md-7 col-sm-8 col-xs-12 resultados credito']//div[@class='datos_superior']"));

}
