package com.example.precisocomprar.network

import com.example.precisocomprar.model.LoginRequest

class RemoteDataSource {

    fun login(loginRequest : LoginRequest, onUserLoggedIn: (String?, Throwable?) -> Unit) {

        Thread{
            //Código para simular um delay
            Thread.sleep(2000)
            onUserLoggedIn("atraso", null)

        }.start()

    }
}