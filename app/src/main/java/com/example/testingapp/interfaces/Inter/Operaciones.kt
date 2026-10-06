package com.example.testingapp.interfaces.Inter

interface Operaciones {
    fun clientAdd(id : Int, nombre : String)
    fun clientEdit(id : Int, nombre : String)
    fun deleteClient(id : Int)
}