# language: es
Característica: Tarifas y descuentos del parqueadero
  Como dueño del parqueadero
  Quiero liquidar las tarifas y aplicar descuentos automáticamente
  Para cobrar lo justo según el vehículo, el tiempo y el tipo de cliente

  Esquema del escenario: Cálculo de tarifa según tiempo de permanencia
    Dado que ingresa un vehículo de tipo "<tipoVehiculo>"
    Cuando permanece estacionado durante <minutos> minutos
    Entonces el valor a pagar debe ser <valorTotal> pesos

    Ejemplos:
      | caso               | tipoVehiculo | minutos | valorTotal |
      | Gracia carro       | carro        | 15      | 0          |
      | Gracia moto        | moto         | 15      | 0          |
      | Fracción carro     | carro        | 16      | 3000       |
      | Fracción moto      | moto         | 16      | 1500       |
      | Tope diario carro  | carro        | 1440    | 25000      |
      | Tope diario moto   | moto         | 1440    | 12000      |

  Escenario: Aplicar descuento a cliente con convenio
    Dado que un cliente tiene una tarifa de 10000 pesos
    Cuando presenta su beneficio de "Convenio"
    Entonces el valor final a pagar con descuento es 8000 pesos