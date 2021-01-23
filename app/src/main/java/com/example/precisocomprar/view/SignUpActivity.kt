package com.example.precisocomprar.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.precisocomprar.R

class SignUpActivity : AppCompatActivity() {

    companion object{
        fun launch (context: Context){
            val intent = Intent (context, SignUpActivity :: class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }
}