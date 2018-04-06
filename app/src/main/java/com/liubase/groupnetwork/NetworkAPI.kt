package com.liubase.groupnetwork

import android.app.*
import com.google.android.gms.tasks.*
import com.google.firebase.auth.*
import com.liubase.groupnetwork.firebase.*
import java.util.concurrent.*

/* Created by Jeffrey Liu on 5/04/2018. */
object NetworkAPI {
    
    fun firebaseAuthState(listener : FirebaseAuth.AuthStateListener) {
        Client.mAuth.addAuthStateListener {listener}
    }
    
    fun firebaseAuthEmail(email : String, password : String,
            listener : OnCompleteListener<AuthResult>) {
        Client.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(listener)
    }
    
    fun firebaseAuthPhone(phone : String, a : Activity,
            callback : PhoneAuthProvider.OnVerificationStateChangedCallbacks) {
        Client.mPhone.verifyPhoneNumber(phone, 30, TimeUnit.SECONDS, a, callback)
    }
    
    fun firebaseAuthCredential(id : String, code : String,
            listener : OnCompleteListener<AuthResult>) {
        val c : PhoneAuthCredential = PhoneAuthProvider.getCredential(id, code)
        Client.mAuth.signInWithCredential(c).addOnCompleteListener(listener)
    }
}