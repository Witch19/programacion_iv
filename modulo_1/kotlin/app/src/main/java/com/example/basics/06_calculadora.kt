package com.example.basics

fun main (){
    print("Incluir primer valor: ")
    val value1: Int = readln().toIntOrNull()?:0

    print("Incluir primer valor2: ")
    val value2: Int = readln().toIntOrNull()?:0

    print("Que quieres hacer: ")
    val signo = readln()

    when(signo){
        "+" -> println(value1 + value2 )
         "/"-> println(value1 / value2 )
        "-" -> println(value1 - value2 )
        "*"-> println(value1 * value2 )
    }
}