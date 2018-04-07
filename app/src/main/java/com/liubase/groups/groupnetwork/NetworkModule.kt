package com.liubase.groups.groupnetwork

import android.util.*
import com.google.android.gms.tasks.*
import com.google.firebase.auth.*
import com.liubase.groups.groupmain.*

/* Created by Jeffrey Liu on 4/04/2018. */
class NetworkModule : BaseModule() {
    
    private val myTag : String = "NetworkModule"
    
    override fun entryPoint() {
        Log.d(myTag, "Start.")
        moduleTest()
    }
    
    private fun moduleTest() {
        NetworkAPI.firebaseAuthEmail("jeffrey.jian.liu@hotmail.com", "Jian1230",
                OnCompleteListener {task ->
                    if (task.isSuccessful) {
                        try {
                            Log.d(myTag, NetworkAPI.firebaseAuthUser()!!.email)
                            NetworkAPI.firebaseAuthEmailVerification(
                                    OnCompleteListener {task ->
                                        if (task.isSuccessful) {
                                            Log.d(myTag, "Email sent.")
                                        }
                                    }
                            )
                        } catch (e : Exception) {
                        
                        }
                    } else {
                        when {
                            task.exception is FirebaseAuthInvalidUserException        -> Log.d(
                                    myTag, "无效的用户名!!!")
                            task.exception is FirebaseAuthInvalidCredentialsException -> Log.d(
                                    myTag, "密码错误!!!")
                            else                                                      -> Log.d(
                                    myTag, "网络错误!!!")
                        }
                    }
                })
    }
}