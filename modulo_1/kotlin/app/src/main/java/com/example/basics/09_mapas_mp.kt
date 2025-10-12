package com.example.basics

fun main(){
    println("Mapas")
    println("Mapa inmutable")

    val listaVehicular = mapOf(
        "PFP9163" to 1,
        "PDC5236" to 5,
    )

    println("Lista de vehiculos: ${listaVehicular}")

    println("Mapa mutable")

    val pagoVehiculo = mutableMapOf<String, Int>()
    pagoVehiculo ["PFP9163"] = 1
    pagoVehiculo ["PDC5236"] = 5

    println("pago completado: ${pagoVehiculo}")


    for((vehiculo, pago) in listaVehicular){
        println("$vehiculo tiene nivel de fuerza $pago")
    }

    /*val planetasVisitados = setOf("Tatooine", "Coruscant", "Dagobah")
    println("Planetas visitados: ${planetasVisitados}")

    val planetasPeligrosos = setOf("Mustafar", "Coruscant", "Korriban")
    println("Planetas visitados: ${planetasPeligrosos}")

    println("Conjunciones")
    val interseccion = planetasPeligrosos intersect planetasVisitados
    val union = planetasPeligrosos union planetasVisitados
    val diferencia = planetasPeligrosos - planetasVisitados
    println("planetas visitados y peligros: ${interseccion}")
    println("Todos los planetas: ${union}")
    println("Planetas seguros visitados: ${diferencia}")


    println("Vlidad de horario de clases")*/

    println("Ingresa tu hora de ingreso de 0")
    var ingreso: Int = readln()?.toIntOrNull()?:0


    when{
        ingreso>=7-> println("Horario de la mañana")
        ingreso>=14-> println("Horario de la tarde")
        else -> println("no tiene horario")
    }

}