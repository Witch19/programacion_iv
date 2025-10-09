package com.example.basics

class FuerzaInsuficienteException(message: String): Exception(message)
class MisionPeligrosaException(message: String): Exception(message)

fun realizarMision(nivelFuerza:Int,peligroMision:Int): String{
    return try{
        when{
            nivelFuerza < 30 -> throw FuerzaInsuficienteException("Nivel de fuerza muy bajo: ${nivelFuerza}")
            nivelFuerza < 80 -> throw MisionPeligrosaException("Mision extremadamente peligrosa")
            else -> {"Error inesperado"}
        }
    }catch (e: FuerzaInsuficienteException){
        "error: ${e.message}. Se requiere entrenamiento adicional"
    }catch (e: MisionPeligrosaException){
        "error: ${e.message}. Nivel de peligrp ${peligroMision}"
    }catch (e: Exception){
        "${e.message}"
    }finally {
      "Reporte enviado"
    }
}

fun main(){
    println(realizarMision(20,60))
    println(realizarMision(100,60))

}