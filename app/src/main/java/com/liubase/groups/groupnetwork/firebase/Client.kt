package com.liubase.groups.groupnetwork.firebase

import com.google.firebase.auth.*

/* Created by Jeffrey Liu on 5/04/2018. */
class Client {
    internal val mAuth : FirebaseAuth = FirebaseAuth.getInstance()
    internal val mPhone : PhoneAuthProvider = PhoneAuthProvider.getInstance(mAuth)
}