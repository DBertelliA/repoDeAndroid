package com.example.testingapp.interfaces

import android.util.Log
import com.example.testingapp.Data.ClientsRepo
import com.example.testingapp.interfaces.Inter.Operaciones
import com.example.testingapp.views.Dialog
import com.example.testingapp.views.MainActivity
import com.example.testingapp.views.MainActivity.Companion.TAG

class Controlador (val actividad: MainActivity) : Operaciones {


    private var mutableListOfPeople : MutableList<Client> =  ClientsRepo.listaCLientes.toMutableList()
    var dialogo = Dialog()
    fun start(){
        dialogo.setListener(this)
        actividad.myButtonAdd.setOnClickListener {
            dialogo.show(0)
        }
        actividad.myButtonDel.setOnClickListener {
            dialogo.show(1)
        }
        actividad.myButtonUpdate.setOnClickListener {
            dialogo.show(2)
        }
        actividad.textV.setText(showData())
    }

    fun insertClientController(cli : Client){
        mutableListOfPeople.add(cli)
        actividad.textV.setText(showData())
        showData()
    }

    fun deleteClientController(idC : Int) : Boolean{
        if(mutableListOfPeople.removeIf{it.id == idC}){
            actividad.textV.setText(showData())
            print(showData())
            return true
        }
        return false
    }

    fun editClientController(idC : Int, nombreC : String) : Boolean{
        val findClient : Client? = mutableListOfPeople.find {it.id == idC}
        return findClient?.let {
            it.nombre = nombreC
            actividad.textV.setText(showData())
            showData()
            return true
        }?: false
    }


    fun showData() = mutableListOfPeople.toString()

    override fun clientAdd(id: Int, nombre: String) {
        insertClientController(Client(id,nombre))

        Log.d(TAG, "El cliente $id y nombre $nombre ${showData()}")
    }

    override fun clientEdit(id: Int, nombre: String) {
        editClientController(id, nombre)
        Log.d(TAG, "El cliente $id tiene nombre $nombre editado ${showData()}")

    }

    override fun deleteClient(id: Int) {
        deleteClientController(id)
        Log.d(TAG, "El cliente de id $id, ha sido eliminado ${showData()}")
    }

}