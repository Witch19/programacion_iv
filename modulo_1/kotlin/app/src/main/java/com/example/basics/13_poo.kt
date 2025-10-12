package com.example.basics

data class Jedi(
    val nombre:String,
    val edad: Int,
    val nivelFuerza: Int,
    val maestro: String?=null,
){
    val rango: String
        get()=when{
            nivelFuerza >= 90->"Maestro"
            nivelFuerza >= 70->"Caballero"
            nivelFuerza >= 50->"Padawan"
            else ->{
                "Iniciado"
            }
        }
    fun puedeEnseniar(): Boolean = nivelFuerza >= 70
    fun entrenar(): Boolean = edad <= 5
}

fun main(){
    val luke = Jedi("Anakin",25,75,"Obiwan")
    println(luke)

    //  Descentralizacion de un objeto
    val(nombre,edad,nivelFuerza)=luke
    println("Nombre del Jedi, ${nombre}, edad: ${edad}, nivel de la fuerza: ${nivelFuerza}")

    //Copiar objeto
    val ashoka = luke.copy(nombre="ashoka", nivelFuerza= 80)
    println(ashoka)

    //Propiedades calculadas
    println("Rango de shoka ${ashoka.rango}")

    println("Rango de shoka ${ashoka.puedeEnseniar()}")

}