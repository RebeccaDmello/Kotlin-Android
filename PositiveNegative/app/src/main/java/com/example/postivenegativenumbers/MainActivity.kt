package com.example.postivenegativenumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Java
        //Button btnCal = (Button)findViewById(R.id.btnCal);
        //Kotlin
        val btnCal = findViewById(R.id.btnCal) as Button

        btnCal.setOnClickListener{
            perform()
        }
    }

    private fun perform() {
        val edNum = findViewById(R.id.edNum) as EditText
        val txtRes = findViewById(R.id.tvRes) as TextView
        val data : String = edNum.text.toString().trim()
        val ary : List<String> = data.split(" ")
        //Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        var pos : Int = 0
        var neg : Int = 0
        var tot : Float = 0.0f
        var avg : Float = 0.00f
        var nZero : Int = 0

        for(elem in ary){
           // Toast.makeText(this, elem, Toast.LENGTH_LONG).show();
            if(elem.toInt() != 0) {
                if (elem.toInt() > 0)
                    pos++;
                else
                    neg++
                tot += elem.toInt()
                nZero++
            }
        }
        avg = tot / nZero
        var res = String.format("The number of positives is " + pos + "\nThe number of negatives is " + neg
        + "\nThe total is " + tot + "\nThe average is " + avg);
        txtRes.text = res
    }
}