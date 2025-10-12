package com.example.basics

fun main(){
    println("!Estructuras de control")
    println("!Condicionales")

    val value1 = 10
    val value2 = 15

    if(value1>value2){
        println("El mayor es ${value1}")
    } else{
        println("El mayor es ${value2}")
    }

    println("Rango segun nivel de la fuerza")
    var fuerza: Int = 10
    if(fuerza>10){
        println("Maestro")
    } else if (fuerza > 5){
        println("Caballero Jedi")
    } else {
        println("Padawan")
    }

    var tipoDroide: String =""

    when(tipoDroide){
        "R2-D2","R2-Q5"->println("Droide astromecanico")
        "C-3PO","C-3PA"->println("Droide de protocolo")
        "BB-8","BB-9E"->println("Droide de nueva generacion")
        else -> println("Modelo Desconocido")
    }

    var peligro: Int = 10
    var recompensa: Int = 50
    when{
        peligro>8 && recompensa < 1000 -> println("Mision Rechazada")
        peligro<=3 -> println("Mision Aceptada")
        else -> println("Requiere Evaluacion adicional")
    }

    /*var colorS: String = "verde"
    var estado: String = "vacio"
    when{
        colorS = "verde" && estado="vacio"->println("avanzar")
        colorS = "amarillo" && estado ="vacio" ->println("esperar")
        colorS = "rojo" && estado ="vacio" ->println("esperar")

    }*/


    print("Colocar el mes: ")
    val mes: String = readln().lowercase()

    print("colocar el signo: ")
    val  elemento: String = readln().lowercase()
    when {
        mes == "agosto" && (elemento == "leo" || elemento == "aries" || elemento ==
                "sagitario") -> {println("eres elemento fuego")}

        mes == "julio" && (elemento == "geminis" || elemento == "libra" || elemento == "acuario") ->
        {println("eres elemento aire")}

        mes == "febrero" && (elemento == "cancer" || elemento == "escorpion" || elemento ==
                "piscis") -> {println("eres elemento agua")}

        mes == "marzo" && (elemento == "tauro" || elemento == "virgo" || elemento ==
                "capricornio") -> {println("eres elemento tierra")}
        else -> {println("No estas")}
    }




}