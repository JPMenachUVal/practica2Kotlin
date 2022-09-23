package com.example.practica2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.practica2kotlin.databinding.ActivityMainBinding
import com.example.practica2kotlin.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity(), UserCodeGeneralizable {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.swECivil.setOnCheckedChangeListener { compoundButton, b -> evalECivil() }
        binding.btnRegistrar.setOnClickListener{
            if(binding.etNombre.text.isNotEmpty() || binding.etApellido.text.isNotEmpty())
            registrarUsuario()
            else
                Toast.makeText(this, "No puede haber campos vacíos", LENGTH_SHORT).show()
        }
    }

    private fun registrarUsuario() {
        val usuario: Usuario = Usuario(binding.etNombre.text.toString(),binding.etApellido.text.toString(),binding.swECivil.isChecked)
        mostrarDatosUsuario(usuario)
    }

    private fun mostrarDatosUsuario(usuario: Usuario) {
        val textoDatosUsuario = usuario.toString() +
        generarUserCode(usuario, intent.getStringExtra("codigo").toString()) + "\nRegistrado satisfactoriamente"
        binding.txtMostrar.text = textoDatosUsuario
    }

    private fun evalECivil() {
        if(binding.swECivil.isChecked)
            binding.swECivil.text = "Casado"
        else
            binding.swECivil.text = "Soltero"
    }
}