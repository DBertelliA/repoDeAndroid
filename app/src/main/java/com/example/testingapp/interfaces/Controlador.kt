package com.example.testingapp.interfaces

import com.example.testingapp.Data.ClientsRepo

class Controlador {
    private var mutableListOfPeople : MutableList<Client> =  ClientsRepo.listaCLientes.toMutableList()

    fun insertClientController(cli : Client){
        mutableListOfPeople.add(cli)
    }

    fun deleteClientController(idC : Int) : Boolean{
        return mutableListOfPeople.removeIf {it.id == idC}
    }

    fun editClientController(idC : Int, nombreC : String) : Boolean{
        val findClient : Client? = mutableListOfPeople.find {it.id == idC}
        return findClient?.let {
            it.nombre = nombreC
            return true
        }?: false
    }


    fun showData() = mutableListOfPeople.toString()
}