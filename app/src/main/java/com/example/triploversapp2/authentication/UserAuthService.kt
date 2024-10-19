package com.example.triploversapp2.authentication

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserAuthService {
    private val auth= Firebase.auth


    public fun registrarUsuario(email:String,password:String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener( { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)


                }
            })
    }


    public fun LoguearUsuario(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser

                } else {
                   Log.d(TAG,"No se logro loguear el usuario")
                }
            }
    }

}