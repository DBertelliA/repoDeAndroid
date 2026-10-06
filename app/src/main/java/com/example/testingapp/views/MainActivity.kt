package com.example.testingapp.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapp.R
import com.example.testingapp.interfaces.Client
import com.example.testingapp.interfaces.Controlador
import com.example.testingapp.interfaces.Inter.Operaciones

class MainActivity : AppCompatActivity(), Operaciones {
    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView

    private lateinit var myDialog : Dialog
    companion object{ const val TAG ="---Salida---"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Esto es el mensaje de inicio log")
        start()
    }

    private fun start(){
        myButtonAdd = findViewById(R.id.myButtonAdd)
        myButtonDel = findViewById(R.id.myButtonDel)
        myButtonUpdate = findViewById(R.id.myButtonUpdate)
        //myDialog = Dialog(Controlador())

        //myDialog.setListener(this)

        //he eliminado toda referencia de que dialog pille la referencia de controler y le he pasado las referencias de los metodos a los set on actions para que
        //Hagan las acciones correspondientes
        myButtonAdd.setOnClickListener {
            //myDialog.show(0)
            clientAdd(100, "Patata")
        }

        myButtonDel.setOnClickListener {
            //myDialog.show(1)
            deleteClient(100)
        }

        myButtonUpdate.setOnClickListener {
            //myDialog.show(2)
            clientEdit(100, "Testeo")
        }


    }


    override fun clientAdd(id: Int, nombre: String) {
        Controlador().insertClientController(Client(id,nombre))

        Log.d(TAG, "El cliente $id y nombre $nombre")
    }

    override fun clientEdit(id: Int, nombre: String) {
        Controlador().editClientController(id, nombre)
        Log.d(TAG, "El cliente $id tiene nombre $nombre editado")

    }

    override fun deleteClient(id: Int) {
        Controlador().deleteClientController(id)
        Log.d(TAG, "El cliente de id $id, ha sido eliminado")
    }



}