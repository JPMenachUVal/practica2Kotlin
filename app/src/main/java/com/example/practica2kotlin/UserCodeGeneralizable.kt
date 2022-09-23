package com.example.practica2kotlin

interface UserCodeGeneralizable {
    fun generarUserCode(user: Usuario, codUser: String): String {
        val primeraLetraNomb = user.nombre.first().uppercase()
        val ultimaLetraApell = user.apellido.last().uppercase()
        val estadoCivil = if (user.estadoCivil) "C"
        else "S"
        return """
            código: ${"$codUser -> ($primeraLetraNomb$ultimaLetraApell-$estadoCivil-$codUser)"}
        """.trimIndent()
    }
}