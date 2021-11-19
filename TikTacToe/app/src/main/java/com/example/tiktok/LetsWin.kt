package com.example.tiktok

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LetsWin : AppCompatActivity(){
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letswin)

        //Bundling in Java
        //TextView tvRes = (TextView)findViewById(R.id.tvRes);

        //In Kotlin
        val tvRes = findViewById(R.id.tvRes) as TextView;

        var data : String ? = intent.getStringExtra("Winner")
        tvRes.text = data
    }
}