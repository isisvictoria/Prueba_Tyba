#language: es
@CalculoCuantoPrestan

Característica:Calculo Cuanto Prestan
  Yo, como usuario de metro cuadrado .com, quiero saber cuanto me prestan para un credito de vivienda segun mi salario

  @TestCase1
  Esquema del escenario: Calculo exitoso de cuanto prestan para credito de vivienda segun el salario
   Dado que Yo cargo los datos para el calculo
     |ingresosMensualesc|plazoEnAñosc|valorPrestamoc|cuotaInicialMinimac|valorInmueblec|
     |<ingresosMensualesc>|<plazoEnAñosc>|<valorPrestamoc>|<cuotaInicialMinimac>|<valorInmueblec>|
    Cuando realizo el calculo
    Entonces verifico el resultado exitoso del calculo

    Ejemplos:
     |ingresosMensualesc|plazoEnAñosc|valorPrestamoc|cuotaInicialMinimac|valorInmueblec|
     |5000000|20 Años|157618584|67550822|225169406|


