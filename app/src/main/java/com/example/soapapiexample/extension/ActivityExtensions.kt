package com.example.soapapiexample.extension

import android.app.Activity
import android.content.Intent
import android.widget.Toast

fun <T> Activity.open(activityClass: Class<T>){
    startActivity(Intent(this,activityClass))
}

fun Activity.toast(msg:String?){
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}