class Punto(id: String) {

    val idPunto: String = id
    var xposicion: Int = 0
    var yposicion: Int = 0

    constructor(id: String, x: Int, y: Int) : this(id) {
        this.xposicion = x
        this.yposicion = y
    }

    fun getCoordenadas()=Pair(
        this.xposicion,
        this.yposicion
    )

    override fun toString():String {
        val a: String = "punto "+this.idPunto+" ->"+" [<"+this.xposicion+">,<"+this.yposicion+">]"
        return a
    }

    companion object{
        fun componenteDeVector(punto1: Punto, punto2: Punto): Punto =
            Punto(
                punto1.idPunto + "," + punto2.idPunto,
                punto2.getCoordenadas().first - punto1.getCoordenadas().first,
                punto2.getCoordenadas().second - punto1.getCoordenadas().second
            )


        fun distancia(punto1: Punto, punto2: Punto): Double =

            ((punto2.getCoordenadas().first-punto1.getCoordenadas().first)/2)*(punto2.getCoordenadas().first-punto1.getCoordenadas().first)*(punto2.getCoordenadas().first-punto1.getCoordenadas().first).toDouble()


        fun localizacionGeograficaNS(lista: List<Punto>): Map<String, List<Punto>> {
            val iterador = lista.listIterator()
            var localizacion: MutableMap<String, List<Punto>> = mutableMapOf()
            var norte: MutableList<Punto> = mutableListOf()
            var sur: MutableList<Punto> = mutableListOf()
            for (i in iterador) {
                if (i.yposicion >= 0) {
                    norte.add(i)
                } else if(i.yposicion <0) {
                    sur.add(i)
                } else {
                    println("Se ha producido un error")}
            }
            localizacion.put("Norte", norte)
            localizacion.put("Sur", sur)

            return localizacion
        }
    }


}
fun main() {

    //val reset = "\u001B[0m"
    //val rojo = "\u001B[31m"
    val azul = "\u001B[34m"
    val cian = "\u001B[36m"
    //val verde = "\u001B[32m"
    val amarillo = "\u001B[33m"
    val purpura = "\u001B[35m"

    var a:Punto = Punto("a", 3, 2)
    println(azul+a.toString())
    var b:Punto = Punto("b", 1, 3)
    println(azul+b.toString())


    var ab:Punto = Punto.componenteDeVector(a, b)
    println(cian+ab.toString())



    var lista: List<Punto> = listOf(
        Punto("p1", -1, 0),
        Punto("p2", 3, -1),
        Punto("p3", -4, 4),
        Punto("p4", -3, 2),
        Punto("p5", 6, -4),
        Punto("p6", -5, 6),
        Punto("p7", 10, -8),
        Punto("p8", 1, 5),
        Punto("p9", 6, -7)
    )
    println(amarillo+"Norte: ${Punto.localizacionGeograficaNS(lista)["Norte"]}")
    println(purpura+"Sur: ${Punto.localizacionGeograficaNS(lista)["Sur"]}")

}
