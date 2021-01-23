package com.example.precisocomprar.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.precisocomprar.R
import com.example.precisocomprar.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        fun launch (context: Context){
            val intent = Intent (context, MainActivity :: class.java)
            //Para retirar a parent activity da pilha do android
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or  Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvListaDeCompras.adapter = MyAdapter()
    }
}