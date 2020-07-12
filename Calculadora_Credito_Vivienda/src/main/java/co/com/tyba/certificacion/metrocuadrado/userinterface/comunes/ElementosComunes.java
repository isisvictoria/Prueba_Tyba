package co.com.tyba.certificacion.metrocuadrado.userinterface.comunes;

import co.com.tyba.certificacion.metrocuadrado.utilities.constant.ConstantTypeClass;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ElementosComunes {

    public static final Target BOTON_CALCULAR_CREDITO1 = Target.the("Boton Calcular Credito").located(By.xpath("//button[contains(.,'Calcular Cr\u00e9dito')]"));

    private ElementosComunes() {
        throw new IllegalStateException(ConstantTypeClass.UI_CLASS);
    }

}
