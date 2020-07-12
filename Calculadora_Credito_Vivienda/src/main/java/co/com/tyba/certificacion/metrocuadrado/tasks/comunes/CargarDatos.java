package co.com.tyba.certificacion.metrocuadrado.tasks.comunes;


import co.com.tyba.certificacion.metrocuadrado.models.Datos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static co.com.tyba.certificacion.metrocuadrado.utilities.constant.ConstantManager.FORMATO_FECHA_YYYYMMDD;
import static co.com.tyba.certificacion.metrocuadrado.utilities.constant.ConstantManager.FORMATO_HORA_HHMMSS;
import static co.com.tyba.certificacion.metrocuadrado.utilities.managers.DateManager.obtenerFechaSistema;

public class CargarDatos implements Task {

    private static final Logger LOGGER = LogManager.getLogger(ActualizarDatos.class.getName());
    private List<Map<String, Object>> datos;

    public CargarDatos(List<Map<String, Object>> datos) {
        this.datos = datos;
    }

    @Override
    @Step("{0} Cargo los datos  para la consulta #datos")
    public <T extends Actor> void performAs(T actor) {
        if (!datos.isEmpty()) {
            Set<Map.Entry<String, Object>> setMapaAux = datos.get(0).entrySet();
            Map<String, Object> mapAuxiliar = setMapaAux.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            if (Datos.getMap() == null) {
                Datos.setMap(mapAuxiliar);
                Datos.getMap().put("horaTransaccion", obtenerFechaSistema(FORMATO_HORA_HHMMSS));
                Datos.getMap().put("fechaTransaccion", obtenerFechaSistema(FORMATO_FECHA_YYYYMMDD));

            } else {
                Datos.getMap().putAll(mapAuxiliar);

            }
        } else {
            actor.remember("", new HashMap<>());
            LOGGER.info("La lista se encuentra vacia");
        }
    }

}
