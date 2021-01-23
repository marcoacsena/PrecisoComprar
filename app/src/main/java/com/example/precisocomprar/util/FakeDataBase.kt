package com.example.precisocomprar.util

import com.example.precisocomprar.model.LoginRequest
import com.example.precisocomprar.model.LoginResponse
import java.util.HashSet

data class User (val name: String,
                 val email: String,
                 val password: String,
                 val token: String)
{}

class FakeDataBase {

    companion object{

        private var users : HashSet <User> = hashSetOf()

        init {
            users.add(User("Marco", "marco@gmail.com", "1", "marcook"))
            users.add(User("Lu", "lu@gmail.com", "2", "luok"))
        }

        fun login(loginRequest: LoginRequest, response : (LoginResponse?) -> Unit) {
            Thread.sleep(1000)
            val user : User? = users.filter {
                it.email == loginRequest.email && it.password == loginRequest.password
            }.firstOrNull()

            if(user != null){

                response(LoginResponse(user.token))
            }else response(null)
        }
    }

}