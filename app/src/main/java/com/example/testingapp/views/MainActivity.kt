package com.example.testingapp.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.testingapp.R
import com.example.testingapp.interfaces.Client
import com.example.testingapp.interfaces.Controlador
import com.example.testingapp.interfaces.Inter.Operaciones

class MainActivity : AppCompatActivity(), Operaciones{
    public lateinit var myButtonAdd: ImageView
    public lateinit var myButtonUpdate: ImageView
    public lateinit var myButtonDel: ImageView
    public lateinit var  textV : TextView
    public lateinit var dialogo : Dialog
    public var controller = Controlador()


    companion object{ const val TAG ="---Salida---"}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Esto es el mensaje de inicio log")
        start()
    }

    public fun start(){
        myButtonAdd = findViewById(R.id.myButtonAdd)
        myButtonDel = findViewById(R.id.myButtonDel)
        myButtonUpdate = findViewById(R.id.myButtonUpdate)
        dialogo = Dialog()

        textV = findViewById(R.id.myText)
        dialogo.setListener(this)
        myButtonAdd.setOnClickListener {
            dialogo.show(0)
            textV.setText(controller.showData())
        }
        myButtonDel.setOnClickListener {
            dialogo.show(2)
            textV.setText(controller.showData())
        }
        myButtonUpdate.setOnClickListener {
            dialogo.show(1)
            textV.setText(controller.showData())
        }
    }


    override fun clientAdd(id: Int, nombre: String, apellido : String, telefono : String) {
        controller.insertClientController(Client(id,nombre,apellido, telefono))

        Log.d(TAG, "El cliente $id y nombre $nombre ${controller.showData()}")
    }

    override fun clientEdit(id: Int, nombre: String, apellido : String, telefono : String) {
        controller.editClientController(id, nombre,apellido,telefono)
        Log.d(TAG, "El cliente $id tiene nombre $nombre editado ${controller.showData()}")

    }

    override fun deleteClient(id: Int) {
        controller.deleteClientController(id)
        Log.d(TAG, "El cliente de id $id, ha sido eliminado ${controller.showData()}")
    }





}