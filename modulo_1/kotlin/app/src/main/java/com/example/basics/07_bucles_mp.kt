package com.example.basics

fun main(){
    println("bucles")

    val coloresCarro= listOf("Rojo","Amariilo","Verde")
    for((index,colores) in coloresCarro.withIndex()){
        println("${index+1}.$colores")
    }

    // el step es el que va a indicar cada cuanto me va a mostrar
    for( i in 0 .. 20 step 5){
        println("Energia: $i%")
    }

    //control de flujo
    for (colores in coloresCarro){
        if(colores == "Obi-Wan") continue
        if(colores == "Yoda") break
        println("entrenamiento a $colores")
    }

}