package com.example.precisocomprar.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.precisocomprar.R
import com.example.precisocomprar.model.LoginRequest
import com.example.precisocomprar.network.RemoteDataSource
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showProgress
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    //Indica que o objeto será instanciado mais tarde, quando for necessário de fato
    private val remoteDataSource: RemoteDataSource by lazy {
        RemoteDataSource()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        tvCadastrar.setOnClickListener {
            SignUpActivity.launch(this@SignInActivity)
        }

        btnLogin.setOnClickListener{

            if(validateForm()){
                // Show progress with "Loading" text
                btnLogin.showProgress() {

                    buttonTextRes = R.string.loading
                    progressColor = Color.WHITE
                }
                doLogin()
            }

        }
    }

    private fun validateForm () : Boolean{
        val email = tieEmail.text.toString()
        val password = tieSenha.text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this@SignInActivity,
                R.string.email_and_password_incorrects,
                Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

    private fun doLogin() {
        val email = tieEmail.text.toString()
        val password = tieSenha.text.toString()

        remoteDataSource.login(LoginRequest(email, password)){token, throwable ->
            //Se o último parâmetro de uma função (que está na classe RemoteDataSource.kt) for outra função, ele pode ser
            //passado como bloco de código {}.
            runOnUiThread{
                //btnLogin.hideProgress(R.string.button_login)

                //Esse código só será executado mais tarde
                if(token != null){
                    //Abrir tela principal
                    MainActivity.launch(this)

                }else{
                    Toast.makeText(this, R.string.campos_invalidos,
                        Toast.LENGTH_LONG).show()
                }


            }

        }
    }


}