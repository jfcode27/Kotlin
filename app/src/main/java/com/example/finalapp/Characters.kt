package com.example.finalapp

abstract class Characters(
    protected val Nombre: String? = "",
    protected val Poder: String? = "",
    protected val Raza: String? = null
) {

    abstract val type: String

    fun getInfo() = "Tu personaje $Nombre es $type\n su raza es $Raza\n y su Poder es $Poder"

    abstract fun action(): String
    abstract fun eat(): String
    abstract fun play(): String

}

class Hero(Nombre: String?, Poder: String?, Raza: String?): Characters(Nombre, Poder, Raza) {
    override val type = "Heroe"

    override fun action() = "$Nombre ataca con $Poder"
    override fun eat() = "$Nombre esta comiendo ramen"
    override fun play() = "$Nombre se defiende"
}

class Villain(Nombre: String?, Poder: String?, Raza: String?): Characters(Nombre, Poder, Raza){
    override val type = "Villano"

    override fun action() = "$Nombre ataca con $Poder"
    override fun eat() = "$Nombre esta comiendo dumplings"
    override fun play() = "$Nombre se defiende"
}
