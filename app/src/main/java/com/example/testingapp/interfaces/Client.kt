package com.example.testingapp.interfaces

class Client{
    var id : Int = 0
    var nombre : String = "Por defecto"

    constructor(id: Int, nombre: String) {
        this.id = id
        this.nombre = nombre
    }


    override fun toString(): String {
        return "id=$id, nombre='$nombre'\n"
    }


}


