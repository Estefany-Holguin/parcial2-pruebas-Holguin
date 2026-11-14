package parqueadero.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import parqueadero.CalculadoraTarifas;
import parqueadero.Descuentos;

public class ParqueaderoSteps {

    private final CalculadoraTarifas calculadora = new CalculadoraTarifas();
    private final Descuentos descuentos = new Descuentos();

    private String tipoVehiculo;
    private int tarifaCalculada;
    private int tarifaBase;
    private int tarifaConDescuento;

    @Dado("que ingresa un vehículo de tipo {string}")
    public void queIngresaUnVehiculoDeTipo(String tipo) {
        this.tipoVehiculo = tipo;
    }

    @Cuando("permanece estacionado durante {int} minutos")
    public void permaneceEstacionadoDuranteMinutos(int minutos) {
        this.tarifaCalculada = calculadora.calcularTarifa(minutos, tipoVehiculo);
    }

    @Entonces("el valor a pagar debe ser {int} pesos")
    public void elValorAPagarDebeSerPesos(int esperado) {
        assertEquals(esperado, tarifaCalculada);
    }

    @Dado("que un cliente tiene una tarifa de {int} pesos")
    public void queUnClienteTieneUnaTarifaDePesos(int valor) {
        this.tarifaBase = valor;
    }

    @Cuando("presenta su beneficio de {string}")
    public void presentaSuBeneficioDe(String tipoCliente) {
        this.tarifaConDescuento = descuentos.calcularDescuento(tarifaBase, tipoCliente);
    }

    @Entonces("el valor final a pagar con descuento es {int} pesos")
    public void elValorFinalAPagarConDescuentoEsPesos(int esperado) {
        assertEquals(esperado, tarifaConDescuento);
    }
}
