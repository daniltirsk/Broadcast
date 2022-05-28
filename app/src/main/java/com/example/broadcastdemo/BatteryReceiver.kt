package com.example.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import android.widget.TextView

class BatteryReceiver (view: TextView) : BroadcastReceiver() {
    var textView = view

    override fun onReceive(context: Context, intent: Intent) {
        textView.text = "Накормите Ждуна, силы на исходе! "
    }
}