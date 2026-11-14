package parqueadero;

public class Descuentos {
    public int calcularDescuento(int valor, String tipoCliente) {
        if  (tipoCliente.equals("Ninguno")) {
            return valor;
        } else if (tipoCliente.equals("Convenio")) {
            return (int) (valor * 0.8);
        } else if (tipoCliente.equals("Frecuente")) {
            return (int) (valor * 0.9);
        } else {
            throw new IllegalArgumentException("Tipo de cliente no válido");
        }
    }
}
