package com.example.testingapp.views

import com.example.testingapp.interfaces.Controlador
import com.example.testingapp.interfaces.Inter.Operaciones
import kotlin.math.roundToInt

class Dialog{
    private var listener: Operaciones? = null  //Ya si eso lo creo.
    //Carga el listener para el botón
    fun setListener ( _listener : Operaciones){
        listener = _listener

    }

    //muestra el dialogo
    fun show(typeAction : Int){
        listener?.let{
            val posibleId = (Math.random() + 99).roundToInt()//me da un aleatorio. -1 está vacío para editar/borrar.
            when (typeAction){
                0 -> addClient() //simulamos que ahora pulsamos el botón aceptar de un nuevo

                1 ->
                    if (posibleId != -1)
                        onEdit(posibleId, "CAMBIADO")

                2 ->
                    if (posibleId != -1)
                        onDelete(posibleId)

            }

        }
    }

    private fun addClient(id : Int = (Math.random() + 99).roundToInt(), nombre : String = "Ni puta idea", apellido : String = "Obra maestra", telefono : String = "cccccccccc"){
        listener!!.clientAdd(id, nombre, apellido, telefono)
        listener.toString()
    }

    private fun onDelete(id : Int){
        listener!!.deleteClient(id)
        listener.toString()
    }

    private fun onEdit(id : Int, nombre : String, apellido : String = "Obra maestra", telefono : String = "cccccccccc"){
        listener!!.clientEdit(id, nombre, apellido, telefono)
        listener.toString()
    }
}
