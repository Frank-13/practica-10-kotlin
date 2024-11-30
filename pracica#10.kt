class Nodo(val pregunta: String, val respuesta: String? = null){
    var izquierdo: Nodo? = null
    var derecho: Nodo? = null
}

class ArbooBinarioRPG{
    var raiz: Nodo

    init {
        val mago= Nodo("", "eres un mago")
        val arquero= Nodo("", "eres un arquero")
        val gerrero= Nodo("", "eres un gerrero")
        val asesino= Nodo("", "eres un asesino")

        val magia = Nodo("prefieres usar magia?")
        magia.izquierdo = mago
        magia.derecho = arquero
        
        val armas = Nodo("prefieres usar armas?")
        armas.izquierdo = gerrero
        armas.derecho = asesino
        
        raiz = Nodo("prefieres combate a distancia?")
        raiz.izquierdo = magia
        raiz.derecho = armas

    }
}

fun juego(nodo: Nodo?){
    if (nodo == null) return 

    if (nodo.respuesta != null){
        println(nodo.respuesta)
        return
    }
    println(nodo.pregunta + "(si/no)")
    val respuesta = readLine()?.trim()?.lowercase()

    if (respuesta == "si"){
        juego(nodo.izquierdo)
    }else{
        juego(nodo.derecho)
    }
}