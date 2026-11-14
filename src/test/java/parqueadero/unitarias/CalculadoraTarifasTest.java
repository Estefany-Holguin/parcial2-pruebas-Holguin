package parqueadero.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import parqueadero.CalculadoraTarifas;

/** Pruebas unitarias iniciales de calcularTarifa. Están incompletas a propósito. */
class CalculadoraTarifasTest {

    private final CalculadoraTarifas calculadora = new CalculadoraTarifas();

    @Test
    @DisplayName("Un carro con una hora y un minuto paga dos horas")
    void carroConUnaHoraYUnMinutoPagaDosHoras() {
        assertEquals(6000, calculadora.calcularTarifa(61, "carro"));
    }

    @Test
    @DisplayName("Una moto con media hora paga una hora")
    void motoConMediaHoraPagaUnaHora() {
        assertEquals(1500, calculadora.calcularTarifa(30, "moto"));
    }

    @Test
    @DisplayName("Rechaza un tipo de vehículo desconocido")
    void rechazaUnTipoDeVehiculoDesconocido() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTarifa(30, "bicicleta"));
    }
    @Test
    @DisplayName("Rechaza un número de minutos negativo")
    void rechazaUnNumeroDeMinutosNegativo() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTarifa(-1, "carro"));
    }
    @Test
    @DisplayName("Rechaza un número de minutos mayor a 1440")
    void rechazaUnNumeroDeMinutosMayorA1440() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTarifa(1441, "moto"));
    }
    @Test
    @DisplayName("Rechaza un número de minutos igual a 1440")
    void rechazaUnNumeroDeMinutosIgualA1440() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTarifa(1445, "carro"));
    }
    @Test
    @DisplayName("Un carro con 15 minutos paga cero")
    void carroCon15MinutosPagaCero() {
        assertEquals(0, calculadora.calcularTarifa(15, "carro"));
    }
    @Test
    @DisplayName("Una moto con 15 minutos paga cero")
    void motoCon15MinutosPagaCero() {
        assertEquals(0, calculadora.calcularTarifa(15, "moto"));
    }
    @Test
    @DisplayName("Un carro con 1440 minutos paga el tope diario")
    void carroCon1440MinutosPagaElTopeDiario() {
        assertEquals(25000, calculadora.calcularTarifa(1440, "carro"));
    }
    @Test
    @DisplayName("Una moto con 1440 minutos paga el tope diario")
    void motoCon1440MinutosPagaElTopeDiario() {
        assertEquals(12000, calculadora.calcularTarifa(1440, "moto"));
    }
    @Test
    @DisplayName("Un carro con 0 minutos paga cero")
    void carroCon0MinutosPagaCero() {
        assertEquals(0, calculadora.calcularTarifa(0, "carro"));
    }
    @Test
    @DisplayName("Una moto con 0 minutos paga cero")
    void motoCon0MinutosPagaCero() {
        assertEquals(0, calculadora.calcularTarifa(0, "moto"));
    }
    @Test
    @DisplayName("Un carro con 1 hora paga 2000")
    void carroCon1HoraPaga3000() {
        assertEquals(3000, calculadora.calcularTarifa(60, "carro"));
    }
}


