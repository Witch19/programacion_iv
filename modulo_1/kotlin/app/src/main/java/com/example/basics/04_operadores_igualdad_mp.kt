package com.example.basics

fun main(){
    println("Operadores igualdad")

    val nombre1: String = "Andre"
    val nombre2: String = "Joss"
    val nombre3: String = String("Joss".toCharArray())

    println("Igualdad Estructural (Contenido)")
    println("${nombre1 === nombre2}")
    println("${nombre1 === nombre3}")
    println("Igualdad referencial (misma instancia)")
    println("${nombre1 === nombre2}")
    println("${nombre2 === nombre3}")


}