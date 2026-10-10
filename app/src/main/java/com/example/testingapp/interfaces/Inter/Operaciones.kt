package com.example.testingapp.interfaces.Inter

interface Operaciones {
    fun clientAdd(id : Int, nombre : String, apellido : String, telefono : String)
    fun clientEdit(id : Int, nombre : String, apellido : String, telefono : String)
    fun deleteClient(id : Int)
}