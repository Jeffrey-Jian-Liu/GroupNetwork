package com.liubase.groups.groupnetwork

import android.app.*
import com.google.android.gms.tasks.*
import com.google.firebase.auth.*
import com.liubase.groups.groupnetwork.firebase.*
import java.util.concurrent.*

/* Created by Jeffrey Liu on 5/04/2018. */
object NetworkAPI {
    
    private var client : Client = Client()
    
    fun firebaseAuthUser() : FirebaseUser? {
        return client.mAuth.currentUser
    }
    
    fun firebaseAuthState(listener : FirebaseAuth.AuthStateListener) {
        client.mAuth.addAuthStateListener {listener}
    }
    
    fun firebaseAuthEmail(email : String, password : String,
            listener : OnCompleteListener<AuthResult>) {
        client.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(listener)
    }
    
    fun firebaseAuthPhone(phone : String, a : Activity,
            callback : PhoneAuthProvider.OnVerificationStateChangedCallbacks) {
        client.mPhone.verifyPhoneNumber(phone, 30, TimeUnit.SECONDS, a, callback)
    }
    
    fun firebaseAuthCredential(id : String, code : String,
            listener : OnCompleteListener<AuthResult>) {
        val c : PhoneAuthCredential = PhoneAuthProvider.getCredential(id, code)
        client.mAuth.signInWithCredential(c).addOnCompleteListener(listener)
    }
    
    fun firebaseAuthEmailVerification(listener : OnCompleteListener<Void>) {
        client.mAuth.currentUser?.sendEmailVerification()?.addOnCompleteListener(listener)
    }
}