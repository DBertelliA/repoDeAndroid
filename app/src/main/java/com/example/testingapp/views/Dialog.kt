package com.example.testingapp.views

import com.example.testingapp.interfaces.Controlador
import com.example.testingapp.interfaces.Inter.Operaciones
import kotlin.math.roundToInt

class Dialog {
    private var listener : Operaciones? = null
    private var accion : Int = 0;

    //carga del listener para el botón
    fun setListener(_listener : Operaciones) {
        listener = _listener
    }

    //Lo que muestra el dialogo
    fun show(numberAction : Int){
        listener?.let {
            val posibleName = "No se, solo son pruebas"
            val posibleID = (Math.random() + 99).roundToInt()
            when(numberAction){
                0 -> addClient()
                1 -> onDelete(posibleID)
                2 -> onEdit(posibleID,posibleName)
            }

        }
    }

    private fun addClient(id : Int = (Math.random() + 99).roundToInt(), nombre : String = "Ni puta idea"){
        listener!!.clientAdd(id, nombre)
        listener.toString()
    }

    private fun onDelete(id : Int){
        listener!!.deleteClient(id)
        listener.toString()
    }

    private fun onEdit(id : Int, nombre : String){
        listener!!.clientEdit(id, nombre)
        listener.toString()
    }

}