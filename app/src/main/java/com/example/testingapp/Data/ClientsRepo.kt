package com.example.testingapp.Data

import com.example.testingapp.interfaces.Client

class ClientsRepo {
    companion object { //Solo se puede poner una vez por clase y equicale a un static de objetos de rapido acceso
        var primaryId = 1;

        val listaCLientes : List<Client> = listOf(
            Client(ClientsRepo.autoIncrement(), "patata"),
            Client(ClientsRepo.autoIncrement(), "cebollas"),
            Client(ClientsRepo.autoIncrement(), "ajos")
        )

        fun autoIncrement() : Int = primaryId++
    }

}