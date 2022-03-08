package com.senai.controle_notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //determina o tempo em que a splash vai ficar na tela
        Timer().schedule(2000) { abrirMain() }


    }

    private fun abrirMain(){
        val intent = Intent ( this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}