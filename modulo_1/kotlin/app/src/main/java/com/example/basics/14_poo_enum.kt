package com.example.basics

//es un objeto que se puede ingresar una clasificacion
enum class tipoSable(val color: String, val poder:Int){
    // override: sobreescribe la funcion de descripcion segun los parametros que se le mande
    AZUL ("azul", 85){
        override fun description()="Sable tradicional de los Jedi"
    },
    VERDE("verde", 90){
        override fun description()="Sable de los jedi consultares"
    },
    ROJO("verde", 90){
        override fun description()="Sable de Stich"
    },
    MORADO("morado", 95){
        override fun description()="Sable Equilibra luz y oscuridad"
    };
    abstract fun description(): String
    companion object{
        fun porColor(color: String) = values().find { it.color==color }
    }
}

class SableDeLuz(val tipo: tipoSable, val portador:String){
    fun activar() = "!ZZZrum! El sable de color ${tipo.color} de ${portador} se enciende"
    fun info() = "${tipo.description()} - tipo poder ${tipo.poder}"
}

fun main(){
    val sableWindoo = SableDeLuz(tipoSable.MORADO, "Windoo")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())

    val sableLuke = SableDeLuz(tipoSable.VERDE, "Luke")
    println(sableLuke)
    println(sableLuke.activar())
    println(sableLuke.info())
}