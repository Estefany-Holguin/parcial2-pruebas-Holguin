package parqueadero;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reportes {

    private static final String TOTAL_RECAUDADO = "total_recaudado";

    private final CalculadoraTarifas calculadora = new CalculadoraTarifas();

    public Map<String, Integer> resumen(List<Registro> registros) {
        Map<String, Integer> resultado = new HashMap<>();
        resultado.put("carro", 0);
        resultado.put("moto", 0);
        resultado.put(TOTAL_RECAUDADO, 0);

        for (Registro registro : registros) {
            String tipoVehiculo = registro.tipo();
            resultado.put(tipoVehiculo, resultado.get(tipoVehiculo) + 1);
            int tarifa = calculadora.calcularTarifa(registro.minutos(), tipoVehiculo);
            resultado.put(TOTAL_RECAUDADO, resultado.get(TOTAL_RECAUDADO) + tarifa);
        }
        return resultado;
    }
}
