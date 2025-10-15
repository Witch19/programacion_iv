package com.example.basics
import kotlin.random.Random

fun main(){
    // Condiciones
    //1. Termostato doméstico
    print("Ingrese la temperatura `C: ")
    val temp = readln().toDouble();
    print("Preferencia en frio, templado o caliente: ")
    val pref = readln().lowercase();

    when{
        pref == "frio" && temp > 22 -> println("Encender aire")
        pref == "caliente" && temp < 18 -> println("Encender calefaccion")
        pref == "templado" && temp in 18.0..22.0 -> println("En confort")
        else -> println("Ventilar")
    }

    //2. Costo de envío express
    print("ingresa la distancia: ")
    val distancia = readln().toDouble();
    print("Esta lluviendo? (si/no) ")
    val lluvia = readln().lowercase();

    var costo = when {
        distancia <= 5 -> 2.5;
        distancia in 6.0..15.0 -> 5.0

        else -> 8.0
    }

    if(lluvia == "si" || lluvia == "sí"){
        costo += 1.5
    }
    println("Costo total: $$costo")

    //3. Control de acceso por horario
    print("Pon me la hora de 0-23: ")
    val hora = readln().toInt();
    print("Escoge un rol: admin, invitado y empleador ")
    val rol = readln().lowercase()

    val acceso = when(rol){
        "admin"->"permitido"
        "invitado" -> if(hora in 9..17) "Permitido" else "Denegado"
        "empleado" -> if(hora in 6..20) "Permitido" else "Denegado"
        else -> "Rol invalido"
    }
    println("Aceso:  $acceso")

    //BUCLES
    //Simulador de ahorro semanal
    print("Ingrese la meta: ")
    val meta = readln().toDouble()
    print("Ingrese cuando quiere comenzar ahorrar:  ")
    var ahorro = readln().toDouble()

    var deposito = 5.0
    var semana = 1

    while (ahorro < meta) {
        ahorro += deposito
        println("Semana $semana → Depósito: $deposito = Ahorro total: $ahorro")
        deposito += 10
        semana++
    }

    println("Meta alcanzada con $ahorro ahorrado en $semana semanas")

    //Detector de vocales consecutivas
    print("Ingrese un texto: ")
    val texto = readln()
    val vocales = "aeiouAEIOU"
    var constante = 0

    for (i in 0 until texto.length-1){
        if(texto[i] in vocales && texto[i+1] in vocales ){
            constante++
        }
    }

    println("las vocales encontradas son estas $constante")

    //Cuenta regresiva con eventos
    for(u in 30 .. 0){
        when(u){
            20 -> println("Chequeo de sistemas")
            10 -> println("Últimos ajustes")
            0 -> println("Despegue")
            else -> println(u)
        }
    }


    //Combinados (condicionales + bucles)
    //Cola de supermercado

    var totalDia = 0.0
    var clientes = 0

    while (true) {
        print("Ingrese total del cliente o 'fin' para terminar: ")
        val entrada = readln().lowercase()

        if (entrada == "fin") break

        val totalCliente = entrada.toDouble()

        print("Ingrese cantidad de productos: ")
        val items = readln().toInt()
        var conDescuento = totalCliente

        if (totalCliente > 100) {
            conDescuento *= 0.95
            println("Descuento aplicado 5% del total: $conDescuento")
        }
        if (items > 10) {
            println("Caja rapida no disponible.")
        }

        totalDia += conDescuento
        clientes++
    }

    println("\nResumen del dia:")
    println("Clientes atendidos: $clientes")
    println("Total vendido: $totalDia")

    //ATM simplificado
    var saldo = 0.0
    var opcion: Int

    do{
        println("-- MENI ATM --")
        println("1) Depositar")
        println("2) Retirar")
        println("3) Salir")
        println("Seleccione una opcion: ")
        opcion = readln().toInt()

        when(opcion){
            1 ->{
                print("Ingrese monto que quiere depositar: ")
                val monto = readln().toDouble()
                saldo += monto
                println("Deposito exitoso, saldo total $saldo")
            }

            2 ->{
                print("Ingrese monto que quiere retirar: ")
                val monto = readln().toDouble()
                if(monto <= saldo){
                    saldo -= monto
                    println("Retiro exitoso, queda: $saldo")
                } else {
                    println("No tiene fondos: $saldo")
                }
            }
            3 -> println("Sesion terminada.")
            else -> println("Opción no válida.")
        }
    }
    while (opcion != 3)

    //Generador de usuario
    print("Ingresa tu nombre: ")
    val nombre = readln().lowercase()
    print("Ingrese su apellido: ")
    val apellido = readln().lowercase()

    var username = ""
    var i = 0

    while (i < nombre.length || i < apellido.length){
        if(i + 1 < nombre.length){
            username += nombre.substring(i, i + 2)
        }
        if(i + 1 < apellido.length){
            username += apellido.substring(i, i + 2)
        }
        i+=2
    }

    var contador = 1

    while (username.length < 6) {
        username += contador
        contador++
    }

    println("Username agregado: ${username.lowercase()}")

    //Rally de resistencia

    print("Ingrese la cantidad de etapas del rally: ")
    val etapas = readln().toInt()
    var energia = 100

    for (etapa in 1..etapas) {
        val terreno = Random.nextInt(1, 4)
        when (terreno) {
            1 -> {
                energia -= 5
                println("Etapa $etapa y energia actual: $energia")
            }
            2 -> {
                energia -= 10
                println("Etapa $etapa y energia actual: $energia")
            }
            3 -> {
                energia -= 15
                println("Etapa $etapa y energia actual: $energia")
            }
        }
        if (energia <= 0) {
            println("Abandona  $etapa.")
            return
        }
    }
    println("Rally completado, te queda energia $energia.")





}
