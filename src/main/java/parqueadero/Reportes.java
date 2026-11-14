package parqueadero;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reportes {

    private final CalculadoraTarifas calculadora = new CalculadoraTarifas();

    public Map<String, Integer> resumen(List<Registro> registros) {
        Map<String, Integer> r = new HashMap<>();
        r.put("carro", 0);
        r.put("moto", 0);
        r.put("total_recaudado", 0);

        for (Registro reg : registros) {
            String tipo = reg.tipo();
            if (r.containsKey(tipo)) {
                r.put(tipo, r.get(tipo) + 1);
                int tarifa = calculadora.calcularTarifa(reg.minutos(), tipo);
                r.put("total_recaudado", r.get("total_recaudado") + tarifa);
            }
        }
        return r;
    }
}
