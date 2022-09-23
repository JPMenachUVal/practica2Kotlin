package com.example.practica2kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.practica2kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myHandler = Handler(mainLooper)
        binding.btnIniciar.setOnClickListener{
            cargarPantalla()
        }
    }
    //Proceso en segundo plano
    private fun cargarPantalla() {
        Thread {
            try {
                for (i in 0 .. 100){
                    Thread.sleep(100)
                    myHandler.post{
                        binding.apply {
                            if(i/10 != 10){
                                txtPorcentaje.text = "${i/10} s"
                            }else{
                                txtPorcentaje.text = "LISTO"
                                generarCodUser()
                            }
                            pbProgreso.progress = i
                        }
                    }
                }
            }catch (e: InterruptedException){
                e.printStackTrace()
            }
        }.start()
    }

    private fun generarCodUser() {
        val primeraLetra = ('A'..'Z').random()
        val segundaLetra = ('A'..'Z').random()
        val primerNumero = ('0'..'9').random()
        val segundoNumero = ('0'..'9').random()
        pasarPantalla("$primeraLetra$segundaLetra-$primerNumero$segundoNumero")
    }

    private fun pasarPantalla(codUser: String) {
        val intent = Intent(this,RegistroActivity::class.java)
        intent.apply {
            putExtra("codigo", codUser)
        }
        startActivity(intent)
    }
}