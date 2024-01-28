/**
 * Ejercicio 4.5¶
 * Crear una clase Tiempo, con atributos hora, minuto y segundo, que pueda ser construida indicando los tres atributos, sólo hora y minuto o sólo la hora (si no se indica, el valor de minuto o segundo será 0).
 *
 * Crear el método toString() para mostrar el tiempo en formato: XXh XXm XXs.
 *
 * En el programa principal, debe solicitar por teclado hora, minuto y segundo de forma que se puedan omitir los segundos o los minutos (y segundos, claro) e instancie la clase Tiempo mostrando su valor.
 */

/*
class Tiempo(private var hora: Int){
    private var minuto: Int = 0
    private var segundo: Int = 0


    // Constructor para crear con hora y minuto
    constructor(hora: Int, minuto: Int  ): this(hora) {
        this.minuto = minuto
    }

    // Contructor para crear con hora minuto y segundo
    constructor(hora: Int, minuto: Int, segundo: Int): this(hora, minuto){
        this.segundo = segundo
    }

    override fun toString(): String {
        return "Tiempo - ${this.hora}h ${this.minuto}m ${this.segundo}s"
    }
}


fun pedirIntValido(): Int{
    var num: Int?

    do {
        val valor = readln()
        if (valor == "") return 0
        num = valor.toIntOrNull()

        if (num == null || num !in 0..24) println("Debes introducir un numero valido (0-24s): ")

    }while (num == null || num !in 0..24)
    return num
}

fun ejercicioBasico5(){
    println("Introduce hora: ")
    val hora = pedirIntValido()

    println("Introduce minuto (ENTER para omitir): ")
    val minuto = pedirIntValido()

    println("Introduce segundo (ENTER para omitir): ")
    val segundo = pedirIntValido()

    val tiempo = Tiempo(hora, minuto, segundo)

    print(tiempo.toString())

}
*/



// Ejercicio5 v2
/*
Ejercicio 4.5¶
Crear una clase Tiempo, que refleja las horas de un día, es decír, desde 00:00:00 hasta 23:59:59, con atributos hora, minuto y segundo, que pueda ser construida indicando los tres atributos, sólo hora y minuto o sólo la hora (si no se indica, el valor de minuto o segundo será 0).

Crear el método toString() para mostrar el tiempo en formato: XXh XXm XXs.

En el programa principal, debe solicitar por teclado hora, minuto y segundo de forma que se puedan omitir los segundos o los minutos (y segundos, claro) e instancie la clase Tiempo mostrando su valor.

A tener en cuenta:

Si segundos o minutos es mayor que 60, se tendrá que hacer las operaciones necesarios para incrementar la magnitud superior por el resultado del modulo de 60, quedándose en segundos o minutos con el resto. Es decir 65 segundos equivale a : 1 minuto y 5 segundos.
Hora siempre tendrá que ser menor que 24, si no, lanzará una excepción.
Añadir un nuevo método incrementar(t:Tiempo):Boolean, que incrementa en t, el total del tiempo que almacena el objeto que recibe el mensaje, devolviendo false si al incrementar se superan las 23:59:59, en cuyo caso no cambiaría nada del objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al incrementar en t el tiempo, mostrando un mensaje de error si devuelve false.

Añadir un nuevo método decrementar(t:Tiempo):Boolean, que decrementa en t, el total del tiempo que almacena el objeto que recibe el mensaje, devolviendo false si al decrementar se superan las 00:00:00, en cuyo caso no cambiaría nada del objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al decrementar en t el tiempo, mostrando un mensaje de error si devuelve false.

Añadir un nuevo método comparar(t:Tiempo):Int, que compara el tiempo que almacena el objeto que recibe el mensaje con el tiempo que almacena t, devolviendo -1 si el tiempo del objeto que recibe el mensaje es menor que t, 0 si son iguales y 1 si es mayor. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al comparar el tiempo del objeto que recibe el mensaje con el tiempo de t.

Añadir un nuevo método copiar():Tiempo, que devuelve un objeto Tiempo con el mismo tiempo que almacena el objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al copiar el tiempo del objeto que recibe el mensaje en un nuevo objeto Tiempo.

Añadir un nuevo método copiar(t:Tiempo):Tiempo, que copia el tiempo que almacena t en el objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al copiar el tiempo de t en el objeto que recibe el mensaje.

Añadir un nuevo método sumar(t:Tiempo):Tiempo?, que suma el tiempo que almacena el objeto que recibe el mensaje con el tiempo que almacena t, devolviendo un nuevo objeto Tiempo con el resultado o null si el resultado es mayor que 23:59:59. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al sumar el tiempo del objeto que recibe el mensaje con el tiempo de t.

Añadir un nuevo método restar(t:Tiempo):Tiempo?, que resta el tiempo que almacena el objeto que recibe el mensaje con el tiempo que almacena t, devolviendo un nuevo objeto Tiempo con el resultado o null si el resultado es menor que 00:00:00. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al restar el tiempo del objeto que recibe el mensaje con el tiempo de t.

Añadir un nuevo método esMayorQue(t:Tiempo):Boolean, que devuelve true si el tiempo que almacena el objeto que recibe el mensaje es mayor que el tiempo que almacena t. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al comparar si el tiempo del objeto que recibe el mensaje es mayor que el tiempo de t.

Añadir un nuevo método esMenorQue(t:Tiempo):Boolean, que devuelve true si el tiempo que almacena el objeto que recibe el mensaje es menor que el tiempo que almacena t. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al comparar si el tiempo del objeto que recibe el mensaje es menor que el tiempo de t.
*/



/**
 * Clase que representa el tiempo en formato de horas, minutos y segundos.
 * El tiempo se formatea automáticamente para asegurarse de que esté dentro de los límites válidos.
 * @param hora La hora del tiempo (0-23).
 * @param minuto El minuto del tiempo (0-59).
 * @param segundo El segundo del tiempo (0-59).
 */
class Tiempo(private var hora: Int, private var minuto: Int = 0, private var segundo: Int = 0){


    init {
        require(hora in 0..23) { "ERROR - La hora debe estar entre 0..23" }
        formatearTiempo(this)
    }


    /**
     * Incrementa el tiempo actual en la cantidad de tiempo proporcionada.
     * @param t El tiempo a incrementar.
     * @return true si la operación fue exitosa, false si se supera 23:59:59.
     */
    fun incrementar(t: Tiempo): Boolean{
        this.segundo += t.segundo
        this.minuto += t.minuto
        this.hora += t.hora
        formatearTiempo(this)

        return this.hora <= 23
    }


    /**
     * Decrementa el tiempo actual en la cantidad de tiempo proporcionada.
     * @param t El tiempo a decrementar.
     * @return true si la operación fue exitosa, false si es menor a 00:00:00.
     */
    fun decrementar(t: Tiempo): Boolean{

        val segundos1 = calcularSegundos(this.hora, this.minuto, this.segundo)
        val segundos2 = calcularSegundos(t.hora, t.minuto, t.segundo)

        val segundosResultantes = segundos1 - segundos2

        if (segundosResultantes < 0){
            println("Error, se supera las 00:00:00")
            return false
        }

        // Calculamos y reasignamos la nueva hora resultante
        val nuevaHora = segundosResultantes / 3600
        val nuevoMinuto = (segundosResultantes % 3600) / 60
        val nuevoSegundo = segundosResultantes % 60

        this.segundo = nuevoSegundo
        this.minuto = nuevoMinuto
        this.hora = nuevaHora

        return true

    }

    /**
     * Formatea el tiempo asegurándose de que los segundos y minutos estén dentro de los límites válidos.
     * @param t El tiempo a formatear.
     */
    private fun formatearTiempo(t: Tiempo){
        if (t.segundo > 60){
            t.minuto += t.segundo / 60
            t.segundo %= 60
        }

        if (t.minuto > 60){
            t.hora += t.minuto / 60
            t.minuto %= 60
        }
    }

    /**
     * Compara un tiempo con otro tiempo y devuelve un valor numerico dependiendo de la comparacion
     * @param t El tiempo a comparar.
     * @return -1 si este tiempo es menor, 0 si son iguales, 1 si este tiempo es mayor.
     */
    fun comparar(t: Tiempo): Int{
        val segundos = calcularSegundos(this.hora, this.minuto, this.segundo)
        val segundos2 = calcularSegundos(t.hora, t.minuto, t.segundo)
        return when{
            segundos < segundos2 -> -1
            segundos > segundos2 -> 1
            else -> 0
        }
    }

    /**
     * Crea un nuevo objeto Tiempo con el valor del obejto Tiempo actual.
     * @return Un nuevo objeto Tiempo con el mismo tiempo que el actual.
     */
    fun copiar():Tiempo{
        return Tiempo(this.hora, this.minuto, this.segundo)
    }

    /**
     * Copia el tiempo proporcionado en un nuevo objeto Tiempo.
     * @param t El tiempo a copiar.
     * @return Un nuevo objeto Tiempo con el tiempo proporcionado.
     */
    fun copiar(t:Tiempo):Tiempo{
        return Tiempo(t.hora, t.minuto, t.segundo)
    }

    /**
     * Suma el tiempo actual con el tiempo proporcionado.
     * @param t El tiempo a sumar.
     * @return Un nuevo objeto Tiempo con el resultado de la suma, o null si el resultado es mayor que 23:59:59.
     */
    fun sumar(t: Tiempo):Tiempo?{
        this.segundo += t.segundo
        this.minuto += t.minuto
        this.hora += t.hora

        val segundos = calcularSegundos(this.hora, this.minuto, this.segundo)
        if (segundos > 86400){
            return null
        }

        formatearTiempo(this)
        return this
    }


    /**
     * Resta el tiempo proporcionado del tiempo actual.
     * @param t El tiempo a restar.
     * @return Un nuevo objeto Tiempo con el resultado de la resta, o null si el resultado es menor que 00:00:00.
     */
    fun restar(t: Tiempo): Tiempo?{
        val segundos1 = calcularSegundos(this.hora, this.minuto, this.segundo)
        val segundos2 = calcularSegundos(t.hora, t.minuto, t.segundo)

        val segundosResultantes = segundos1 - segundos2

        if (segundosResultantes < 0) return null

        val nuevaHora = segundosResultantes / 3600
        val nuevoMinuto = (segundosResultantes % 3600) / 60
        val nuevoSegundo = segundosResultantes % 60

        return Tiempo(nuevaHora, nuevoMinuto, nuevoSegundo)

    }


    /**
     * Comprueba si el tiempo actual es mayor que el tiempo proporcionado.
     * @param t El tiempo a comparar.
     * @return true si el tiempo actual es mayor, false en caso contrario.
     */
    fun esMayorQue(t: Tiempo): Boolean{
        val segundos = calcularSegundos(this.hora, this.minuto, this.segundo)
        val segundos2 = calcularSegundos(t.hora, t.minuto, t.segundo)
        if (segundos > segundos2){
            println("El tiempo actual es mayor.")
            return true
        }
        return false
    }


    /**
     * Comprueba si el tiempo actual es menor que el tiempo proporcionado.
     * @param t El tiempo a comparar.
     * @return true si el tiempo actual es menor, false en caso contrario.
     */
    fun esMenorQue(t: Tiempo): Boolean{
        val segundos = calcularSegundos(this.hora, this.minuto, this.segundo)
        val segundos2 = calcularSegundos(t.hora, t.minuto, t.segundo)
        if (segundos2 > segundos){
            println("El tiempo actual es menor.")
            return true
        }
        return false
    }


    /**
     * Calcula los segundos totales a partir de las horas, minutos y segundos proporcionados.
     * @param horas Las horas.
     * @param minutos Los minutos.
     * @param segundos Los segundos.
     * @return Los segundos totales.
     */
    private fun calcularSegundos(horas: Int, minutos: Int, segundos: Int): Int{
        val segundosTotal = (horas * 3600) + (minutos * 60) +  (segundos)
        return segundosTotal
    }

    /**
     * Reemplazamos la funcion toString() para mostrar la hora formateada correctamente
     */
    override fun toString():String{
        var horaF = ""
        if (this.hora < 10) horaF = "0${this.hora}" else horaF = this.hora.toString()

        var minF = ""
        if (this.minuto < 10) minF = "0${this.minuto}" else minF = this.minuto.toString()

        var segF = ""
        if (this.segundo < 10) segF = "0${this.segundo}" else segF = this.segundo.toString()

        return "$horaF:$minF:$segF"
    }
}


/**
 * Función que solicita un valor entero por teclado comprobando que sea positivo y valido.
 * @param msg El mensaje para solicitar la entrada.
 * @param obligatorio Indica si la entrada es obligatoria.
 * @return El valor entero introducido por el usuario.
 */
fun pedirTiempo(msg: String, obligatorio: Boolean = true): Int{
    var num: Int?
    println(msg)
    do {
        val valor = readln()
        num = if (valor.isBlank()) {
            if (obligatorio) {
                println("Este valor es obligatorio: ")
                null
            } else 0

        }else valor.toIntOrNull()

        if (num == null || num < 0) println("Debes introducir un numero valido")

    }while (num == null || num < 0)
    return num
}