package com.example.win12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("714b9f14-381d-4fc4-a93c-28d480557381")

        val buttonPlayers = findViewById<AppCompatButton>(R.id.button_players)
        buttonPlayers.setOnClickListener {
            val intent = Intent(this, TopPlayersActivity::class.java)
            startActivity(intent)
        }
        val buttonMarkets = findViewById<AppCompatButton>(R.id.button_markets)
        buttonMarkets.setOnClickListener {
            val intent = Intent(this, MarketsActivity::class.java)
            startActivity(intent)
        }
        val buttonTips = findViewById<AppCompatButton>(R.id.button_tips)
        buttonTips.setOnClickListener {
            val intent = Intent(this, TipsActivity::class.java)
            startActivity(intent)
        }

    }
}