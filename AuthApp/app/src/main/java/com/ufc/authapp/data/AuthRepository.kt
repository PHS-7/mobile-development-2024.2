package com.ufc.authapp.data

import android.content.Context
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.ufc.authapp.R
import kotlinx.coroutines.tasks.await


class AuthRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    suspend fun registerUser(
        email: String,
        password: String,
        name: String
    ): Boolean{
        return try {

            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid


            // Salvar dados do usuário no Firestore com os parâmetros fornecidos
            if (uid != null) {
                val user = hashMapOf(
                    "uid" to uid,
                    "name" to name,
                    "email" to email,
                    "created.at" to System.currentTimeMillis()
                )

                // adicionando o usuário THE FATOO
                // document: usado para encontrar o usuário, no caso pelo UID
                firestore.collection("users").document(uid).set(user).await()

            }
            Log.e("error", "Error on register")
            true
        } catch (e: Exception) {
            false
        }
    }


    suspend fun loginUser(
        email: String,
        password: String
    ):  Boolean {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            Log.e("error", "Error on login")
            false
        }
    }

    suspend fun resetPassword(email: String): Boolean {
        return try{
            auth.sendPasswordResetEmail(email).await()
            true
        } catch (e: Exception) {
            Log.e("error", "Error when reset password")
            false
        }
    }

    suspend fun getUserName(): String?{
        return try {
            val uid = auth.currentUser?.uid

            if (uid != null) {
                val snapshot = firestore.collection("users").document(uid).get().await()
                snapshot.getString("name")
            } else {
                null
            }

        }catch(e: Exception) {
            null
        }
    }



    fun getGoogleSignInClient(context: Context): GoogleSignInClient{

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(com.ufc.authapp.R.string.default_web_client_id))
            .build()

        return GoogleSignIn.getClient(context, gso)


    }

    suspend fun loginWithGoogle(idToken: String): Boolean{
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val result = auth.signInWithCredential(credential).await()
            val user = result.user

            user?.let {
                val uid = it.uid
                val name = it.displayName ?: "user"
                val email = it.email ?: ""

                val userRef = firestore.collection("users").document(uid)
                val snapshot = userRef.get().await()

                if (!snapshot.exists()){
                    val userData = hashMapOf(
                        "uid" to uid,
                        "name" to name,
                        "email" to email,
                        "created.at" to System.currentTimeMillis()
                    )
                    userRef.set(userData).await()
                }
            }
            true
        } catch (e: Exception) {
            Log.e("error", "Error on login with Google")
            false
        }
    }


    fun logout(){
        auth.signOut()
    }


    fun isUserLogged(): Boolean{
        return auth.currentUser != null
    }



}