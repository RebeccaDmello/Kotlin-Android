package com.example.tiktok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Bundling in Java
        //Button btnPlay = (Button).findViewById(R.id.btnPlay);

        //In Kotlin
        val btnPlay = findViewById(R.id.btnPlay) as Button
        btnPlay.setOnClickListener{
            perform();
        }
    }

    private fun perform() {
        var etInput1 = findViewById(R.id.edInput1) as EditText
        var etInput2 = findViewById(R.id.edInput2) as EditText

        var play1 = etInput1.text.toString().trim();
        var play2 = etInput2.text.toString().trim();

        //Intent in Java
        //Intent i = new Intent();
        //i.put(), i.get();
        //startActivity(i);

        val intent = Intent(this, Games::class.java)
        intent.putExtra("Play1", play1)
        intent.putExtra("Play2", play2)
        startActivity(intent)
    }
}