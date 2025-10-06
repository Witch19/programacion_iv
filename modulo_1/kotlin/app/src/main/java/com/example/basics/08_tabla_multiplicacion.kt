package com.example.basics

fun main(){
    print("Que tabla de multiplicacion desea: ")
    val tablaMulti = readln().toIntOrNull()?:0

    val num= listOf(1,2,3,4,5,6,7,8,9,10)

    for (lisnum in num){
        print("Tu tabla: ")
        println(tablaMulti * lisnum)
    }
}