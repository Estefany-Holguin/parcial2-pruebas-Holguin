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

    @Test
    @DisplayName("Calcula descuento para cliente frecuente")
    void calculaDescuentoParaClienteFrecuente() {
        assertEquals(9000, descuentos.calcularDescuento(10000, "Frecuente"));
    }
    @Test
    @DisplayName("No aplica descuento para cliente sin convenio ni frecuente")
    void noAplicaDescuentoParaClienteSinConvenioNiFrecuente() {
        assertEquals(10000, descuentos.calcularDescuento(10000, "Ninguno"));
    }
    @Test
    @DisplayName("Rechaza un tipo de cliente no válido")
    void rechazaUnTipoDeClienteNoValido() {
        assertThrows(IllegalArgumentException.class, () -> descuentos.calcularDescuento(10000, "Invalido"));
    }
}

