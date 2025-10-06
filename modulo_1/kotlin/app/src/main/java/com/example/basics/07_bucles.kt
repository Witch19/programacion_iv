package com.example.basics

fun main(){
    println("bucles")
    val jedis= listOf("Luke","Leia","Obi-Wan","Yoda")
    for((index,jedi) in jedis.withIndex()){
        println("${index+1}.$jedi")
    }

    // el step es el que va a indicar cada cuanto me va a mostrar
    for( i in 0 .. 20 step 5){
        println("Energia: $i%")
    }

    //control de flujo
    for (jedi in jedis){
        if(jedi == "Obi-Wan") continue
        if(jedi == "Yoda") break
        println("entrenamiento a $jedi")
    }

}