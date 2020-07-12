package co.com.tyba.certificacion.metrocuadrado.tasks.fabrica;

import co.com.tyba.certificacion.metrocuadrado.tasks.comunes.CargarDatos;
import co.com.tyba.certificacion.metrocuadrado.utilities.constant.ConstantTypeClass;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Cargar {
    private Cargar() {
        throw new IllegalStateException(ConstantTypeClass.FACTORY_CLASS);
    }

    public static CargarDatos cargoLosDatosParaLaConsultaConLaSiguiente(List<Map<String, Object>> informacion) {
        return instrumented(CargarDatos.class, informacion);

    }


}
