package com.example.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.TextView

class TimeReceiver (view: TextView) : BroadcastReceiver() {
    var minutes = 0
    var textView = view

    override fun onReceive(context: Context, intent: Intent) {
        minutes += 1
        textView.text = "Время созерцания: " + minutes.toString() + " мин"
    }
}