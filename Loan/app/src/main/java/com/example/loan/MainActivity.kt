package com.example.loan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Java
        //Button btnCal = (Button)findViewById(R.id.btnCal);

        //Kotlin
        val btnCal = findViewById(R.id.btnCal) as Button;

        btnCal.setOnClickListener {
            perform()
        }
    }

    private fun perform() {
        var MIN_IVALUE : Double = 5.0
        val MAX_IVALUE : Double = 8.0

        val edAmt = findViewById(R.id.edAmt) as EditText;
        val edYr = findViewById(R.id.edYrs) as EditText;
        val tvRes = findViewById(R.id.tvRes) as TextView;

        var lAmt : Int = edAmt.text.toString().trim().toInt()
        var lYr : Int = edYr.text.toString().trim().toInt()

        var output : String = String.format("%3s  %5s  %7s\n", "Interest Rate", "Monthly Payment", "Total Payment")

        while(MIN_IVALUE <= MAX_IVALUE) {
            val rate: Double = (MIN_IVALUE / 100) / 12.0
            val mon: Int = lYr * 12
            val paymt: Double = (lAmt * rate) / (1 - Math.pow(1 + rate, -mon.toDouble()))
            val tPay: Double = paymt * mon
            val modify = DecimalFormat("##,###.##")

            output += String.format("%10.3f %20.2f %30s\n", MIN_IVALUE, paymt, modify.format(tPay))
            MIN_IVALUE += 0.125
        }
        tvRes.text = output
        tvRes.movementMethod = ScrollingMovementMethod()
    }
}