fun main() {
    // Objeto tiempo fijo test
    val testTiempo = Tiempo(6,20,10)
    val testTiempo2 = Tiempo(10,50,6)

    // Instanciamos la clase tiempo con los valores pedidos
    println("TIEMPO 1:")
    val tiempo1 = Tiempo(pedirTiempo("Introduce hora: "),pedirTiempo("Introduce minutos (enter para omitir): ", false),pedirTiempo("Introduce segundos (enter para omitir): ", false))
    println(tiempo1.toString())

    // Metodo incrementar tiempo
    println("TIEMPO 2:")
    val tiempo2 = Tiempo(pedirTiempo("Introduce hora: "),pedirTiempo("Introduce minutos (enter para omitir): ", false),pedirTiempo("Introduce segundos (enter para omitir): ", false))
    if (!(tiempo1.incrementar(tiempo2))) println("Error, la hora resultante no es valida!: $tiempo1")

    println("*********************************")
    println("Tiempo actual $tiempo1")
    println("*********************************")

    //Metodo decrementar tiempo
    println("TIEMPO 3:")
    val tiempo3 = Tiempo(pedirTiempo("Introduce hora: "),pedirTiempo("Introduce minutos (enter para omitir): ", false),pedirTiempo("Introduce segundos (enter para omitir): ", false))
    //val sumaTiempo = tiempo1.decrementar(tiempo3)
    if (!(tiempo1.decrementar(tiempo3))) println("Error, la hora resultante no es valida!: $tiempo1")

    println("*********************************")
    println("Tiempo actual $tiempo1")
    println("*********************************")

    if (testTiempo.comparar(tiempo2) == 0) {
        println("Tiempo iguales")
    } else if (testTiempo.comparar(tiempo2) == 1) {
        println("Tiempo1 es mayor que Tiempo2")
    } else if (testTiempo.comparar(tiempo2) == -1) {
        println("Tiempo1 es menor que Tiempo2")
    } else {
        println("Comparación no valida")
    }

    println("************************************")

    // Prueba del metodo .copiar() con el testTiempo
    println("Print testTiempo: $testTiempo")
    println("Print testTiempo.copia(): ${testTiempo.copiar()}")

    println("************************************")

    // Prueba del metodo .copiar(t:Tiempo) con el testTiempo2
    val copiaTestTiempo2 = testTiempo2.copiar(testTiempo2)
    println("Print testTiempo2: $testTiempo2")
    println("Print copiaTestTiempo: $copiaTestTiempo2")

    println("************************************")

    // Pueba metodo sumar(t:Tiempo)
    println("testTiempo : $testTiempo")
    println("testTiempo2: $testTiempo2")
    println("Suma de testTiempo y testTiempo2: ${testTiempo.sumar(testTiempo2)}")

    println("************************************")

    // Prueba metodo restar(t: Tiempo)
    println("Test Restar")
    println("TestTiempo - TestTimepo2: ${testTiempo.restar(testTiempo2)}")
    println("TestTiempo2 - TestTimepo: ${testTiempo2.restar(testTiempo)}")

    println("************************************")

    // Prueba metodo esMayorQue
    println("Test esmayorque")
    println(testTiempo.esMayorQue(testTiempo2))

    // Prueba metodo esMenorQue
    println("Test esMenorQue")
    println(testTiempo.esMenorQue(testTiempo2))

    testTiempo.decrementar(testTiempo2)
}