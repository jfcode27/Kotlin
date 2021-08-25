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
        Toast.makeText(this, charactersList[indexList!!].getInfo(), Toast.LENGTH_LONG).show()

    }

    fun play(view: View) {
        Toast.makeText(this, charactersList[indexList!!].play(), Toast.LENGTH_LONG).show()
    }

    fun eat(view: View) {
        Toast.makeText(this, charactersList[indexList!!].eat(), Toast.LENGTH_LONG).show()
    }

    fun getPreviousPet(view: View) {
        if ( indexList == 0 ) {
            if ( charactersList.size != 1 ) {
                indexList = charactersList.size-1
            }
        } else {
            indexList = indexList!!-1
        }
        txvInfo.text = charactersList[indexList!!].getInfo()

    }

    fun createNewPet(view: View) {
        var case = (0..777).random()
        var character: Characters
        when(case) {
            in 0..100 -> character = Hero("Son Goku", "Kame Hame Ha", "Saiyajin")
            in 101..200 -> character = Hero("Son Gohan", "Masenko", "Mestizo")
            in 201..300 -> character = Hero("Mastro Roshi", "Mafuba", "Humano")
            in 301..400 -> character = Villain("Piccolo", "Makankosappo", "Namekuseijin")
            in 401..777 -> character = Villain("Vegeta", "Galick Canyon", null)
            else -> character = Villain("Freezer", "Supernova", "Furīza-zoku")
        }

        var newArray = arrayOf<Characters>(*charactersList, character)
        this.charactersList = newArray
        if ( indexList == null ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }

        Toast.makeText(this, charactersList[indexList!!].getInfo(), Toast.LENGTH_LONG).show()
        txvInfo.text = charactersList[indexList!!].getInfo()
    }

    fun getNextPet(view: View) {
        if ( indexList == (charactersList.size-1) ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }
        txvInfo.text = charactersList[indexList!!].getInfo()
    }

}