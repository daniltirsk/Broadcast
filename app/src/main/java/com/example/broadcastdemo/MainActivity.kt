package com.example.broadcastdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var receiverTime: BroadcastReceiver
    lateinit var receiverBattery: BroadcastReceiver
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.message)
        findViewById<Button>(R.id.button).setOnClickListener {
            tiredOfWaiting()
        }
    }

    override fun onStart() {
        super.onStart()
        receiverTime = TimeReceiver(textView)
        val filterTime = IntentFilter("android.intent.action.TIME_TICK").apply {

        }
        registerReceiver(receiverTime, filterTime)

        receiverBattery = BatteryReceiver(textView)
        val filterBattery = IntentFilter("android.intent.action.BATTERY_LOW").apply {

        }
        registerReceiver(receiverBattery, filterBattery)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiverTime)
        unregisterReceiver(receiverBattery)
    }

    fun tiredOfWaiting(){
        unregisterReceiver(receiverTime)
        Toast.makeText(this,
            "Иди работать",
            Toast.LENGTH_SHORT).show()
    }
}