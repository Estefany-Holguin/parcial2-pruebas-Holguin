package parqueadero;

import java.util.Map;

public class Descuentos {

    private static final Map<String, Double> FACTORES = Map.of(
            "Ninguno", 1.0,
            "Convenio", 0.8,
            "Frecuente", 0.9
    );

    public int calcularDescuento(int valor, String tipoCliente) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        if (!FACTORES.containsKey(tipoCliente)) {
            throw new IllegalArgumentException("Tipo de cliente no válido");
        }
        return (int) Math.round(valor * FACTORES.get(tipoCliente));
    }
}
