package com.example.finalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var txvInfo: TextView
    private lateinit var charactersList : Array<Characters>
    private var indexList: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txvInfo = findViewById(R.id.txvInfo)
        this.charactersList = arrayOf<Characters>()

    }

    fun makeSound(view: View) {
        var case = (0..777).random()
        when(case) {
            in 0..200 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} tiene hambre", Toast.LENGTH_LONG).show()
            in 201..500 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} ha derrotado un enemigo", Toast.LENGTH_LONG).show()
            in 501..777 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} se ha teletransportado", Toast.LENGTH_LONG).show()

            else -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} tiene hambre", Toast.LENGTH_LONG).show()
        }

    }

    fun play(view: View) {
        var case = (0..777).random()
        when(case) {
            in 0..200 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} ha lanzado su ataque", Toast.LENGTH_LONG).show()
            in 201..500 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} se defendió", Toast.LENGTH_LONG).show()
            in 501..777 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} golpeó a un enemigo", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} golpeó a un enemigo", Toast.LENGTH_LONG).show()
        }
    }

    fun eat(view: View) {
        var case = (0..777).random()
        when(case) {
            in 0..200 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} dice hola", Toast.LENGTH_LONG).show()
            in 201..500 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} te ha atacado", Toast.LENGTH_LONG).show()
            in 501..777 -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} te ha ayudado", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(this, "${charactersList[indexList!!].Nombre} te ha ayudado", Toast.LENGTH_LONG).show()
        }
    }

    fun getPreviousPet(view: View) {
        if ( indexList == 0 ) {
            if ( charactersList.size != 1 ) {
                indexList = charactersList.size-1
            }
        } else {
            indexList = indexList!!-1
        }
        txvInfo.text = "nombre: ${charactersList[indexList!!].Nombre}\npoder: ${charactersList[indexList!!].Poder}\nraza: ${charactersList[indexList!!].Raza}\n"

    }

    fun createNewPet(view: View) {
        var case = (0..777).random()
        var character: Characters
        when(case) {
            in 0..100 -> character = Characters("Son Goku", "Kame Hame Ha", "Saiyajin")
            in 101..200 -> character = Characters("Son Gohan", "Masenko", "Mestizo")
            in 201..300 -> character = Characters("Mastro Roshi", "Mafuba", "Humano")
            in 301..400 -> character = Characters("Piccolo", "Makankosappo", "Namekuseijin")
            in 401..777 -> character = Characters("Vegeta", "Galick Canyon", null)
            else -> character = Characters("Freezer", "Supernova", "Furīza-zoku")
        }

        var newArray = arrayOf<Characters>(*charactersList, character)
        this.charactersList = newArray
        if ( indexList == null ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }

        Toast.makeText(this, "El personaje es: ${character.Nombre}", Toast.LENGTH_LONG).show()
        txvInfo.text = "nombre: ${character.Nombre}\npoder: ${character.Poder}\nraza: ${character.Raza}\n"
    }

    fun getNextPet(view: View) {
        if ( indexList == (charactersList.size-1) ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }
        txvInfo.text = "nombre: ${charactersList[indexList!!].Nombre}\npoder: ${charactersList[indexList!!].Poder}\nraza: ${charactersList[indexList!!].Raza}\n"
    }

}