package com.example.finalapp

open class Characters {
    var Nombre : String ? = "";
    var Poder : String ? = "";
    var Raza : String ? = "";

    constructor(Nombre : String ?, Poder : String ?, Raza : String ? ) {
        this.Nombre = Nombre;
        this.Poder = Poder;
        this.Raza = Raza;
    }
}