package com.example.testingapp.interfaces

import android.util.Log
import com.example.testingapp.Data.ClientsRepo
import com.example.testingapp.interfaces.Inter.Operaciones
import com.example.testingapp.views.Dialog
import com.example.testingapp.views.MainActivity
import com.example.testingapp.views.MainActivity.Companion.TAG

class Controlador {


    private var mutableListOfPeople : MutableList<Client> =  ClientsRepo.listaCLientes.toMutableList()
    var dialogo = Dialog()

    fun insertClientController(cli : Client){
        mutableListOfPeople.add(cli)
        showData()
    }

    fun deleteClientController(idC : Int) : Boolean{
        if(mutableListOfPeople.removeIf{it.id == idC}){
            print(showData())
            return true
        }
        return false
    }

    fun editClientController(idC : Int, nombreC : String, apellidoC : String, telefonoC : String) : Boolean{
        val findClient : Client? = mutableListOfPeople.find {it.id == idC}
        return findClient?.let {
            it.nombre = nombreC
            showData()
            return true
        }?: false
    }


    fun showData() = mutableListOfPeople.toString()

}