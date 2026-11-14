package parqueadero.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import parqueadero.Descuentos;

public class DescuentosTest {

    private final Descuentos descuentos = new Descuentos();

    @Test
    @DisplayName("Calcula descuento para cliente con convenio")
    void calculaDescuentoParaClienteConConvenio() {
        assertEquals(8000, descuentos.calcularDescuento(10000, "Convenio"));
    }
}

