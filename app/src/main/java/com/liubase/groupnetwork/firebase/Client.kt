package com.liubase.groupnetwork.firebase

import com.google.firebase.auth.*

/* Created by Jeffrey Liu on 5/04/2018. */
object Client {
    val mAuth : FirebaseAuth = FirebaseAuth.getInstance()
    val mPhone : PhoneAuthProvider = PhoneAuthProvider.getInstance(mAuth)
}