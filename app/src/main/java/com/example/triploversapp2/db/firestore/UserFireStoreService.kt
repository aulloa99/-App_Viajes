package com.example.triploversapp2.db.firestore

import com.example.triploversapp2.modelos.Usuario
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class UserFireStoreService {
    private val firestore = Firebase.firestore

    fun crearUsuario(usuario: Usuario) {
        val usuariosCollection = firestore.collection("usuarios")


        val usuarioData = hashMapOf(
            "nombre" to usuario.nombre,
            "intereses" to usuario.intereses,
            "experienciaDeViaje" to usuario.experienciaDeViaje,
            "ofreceServicios" to usuario.ofreceServicios,
            "tipoDeServicio" to usuario.tipoDeServicio,
            "costoDelServicio" to usuario.costoDelServicio,
            "ubicacion" to usuario.ubicacion,
            "calificacion" to usuario.calificacion,
            "resenas" to usuario.resenas,
            "estaDisponible" to usuario.estaDisponible
        )


        usuariosCollection.add(usuarioData)
            .addOnSuccessListener { documentReference ->
                println("Usuario añadido con ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                println("Error al añadir el usuario: $e")
            }
    }


    fun buscarUsuarioPorUID(uid: String, onComplete: (Usuario?) -> Unit) {
        val usuariosCollection = firestore.collection("usuarios")


        usuariosCollection.document(uid).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {

                    val usuario = Usuario(
                        nombre = document.getString("nombre"),
                        intereses = document.getString("intereses"),
                        experienciaDeViaje = document.getString("experienciaDeViaje"),
                        ofreceServicios = document.getBoolean("ofreceServicios") ?: false,
                        tipoDeServicio = document.getString("tipoDeServicio"),
                        costoDelServicio = document.getDouble("costoDelServicio"),
                        ubicacion = document.getString("ubicacion"),
                        calificacion = document.getDouble("calificacion")?.toFloat(),
                        resenas = document.get("resenas") as? List<String>,
                        estaDisponible = document.getBoolean("estaDisponible") ?: true
                    )

                    onComplete(usuario)
                } else {

                    onComplete(null)
                }
            }
            .addOnFailureListener { e ->

                println("Error al buscar el usuario: $e")
                onComplete(null)
            }
    }
}
