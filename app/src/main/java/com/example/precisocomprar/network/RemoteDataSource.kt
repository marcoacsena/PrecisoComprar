package com.example.precisocomprar.network

import com.example.precisocomprar.model.LoginRequest
import com.example.precisocomprar.util.FakeDataBase

class RemoteDataSource {

    fun login(loginRequest : LoginRequest, onUserLoggedIn: (String?, Throwable?) -> Unit) {

        Thread{
            FakeDataBase.login(loginRequest){ res ->
                if(res != null){
                    onUserLoggedIn(res.token, null)
                }else{onUserLoggedIn(null,null)}
            }
//            //Código para simular um delay
//            Thread.sleep(2000)
//            onUserLoggedIn("Atraso", null)

        }.start()

    }
}