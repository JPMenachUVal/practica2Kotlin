package com.example.practica2kotlin

class Usuario (
    val nombre: String,
    val apellido: String,
    val estadoCivil: Boolean
){
    override fun toString(): String {
        val estCivil = if (estadoCivil) "Casado"
        else "Soltero"
        return "Usuario: $nombre $apellido, $estCivil\n"
    }
}