package com.example.fcol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    //Record rec = new Record();
    //var rec = Record("Money", "Heist", "300322984")
    var myList = mutableListOf<Recording>(
        Recording("Lion King","Disney",400),
        Recording("Fantasia","Walt Disney", 300),
        Recording("Shrek","Mike Myers",600),
        Recording("WallE","W Diney",800),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result()
        //Java
        //Button btnAdd = (Button).findViewById(R.id.btnAdd);
        //Kotlin
        val btnAdd = findViewById(R.id.btnAdd) as Button
        val edTit = findViewById(R.id.etTit) as EditText
        val edArt = findViewById(R.id.etArt) as EditText
        val edTime = findViewById(R.id.etTime) as EditText
        val sortTab = findViewById(R.id.SortTab) as TabLayout
        btnAdd.setOnClickListener{
            var titTemp : String = edTit.text.toString().trim()
            var artTemp : String = edArt.text.toString().trim()
            var timeTemp : Int = edTime.text.toString().trim().toInt()
          //  myList.add(Record(edTit.toString().trim(), edArt.toString().trim(), "123"))
            myList.add(Recording(titTemp, artTemp, timeTemp))
           // println(edTime.toString())
            //Toast.makeText(this,edTime.toString().trim().toInt(),Toast.LENGTH_LONG ).show();
            result()
        }
        sortTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 ->{
                        myList = myList.sortedBy {
                            it.artist
                        }.toMutableList()
                    }

                    1 ->{
                        myList = myList.sortedBy {
                            it.title
                        }.toMutableList()
                    }

                    2->{
                        myList = myList.sortedBy {
                            it.time
                        }.toMutableList()
                    }
                }
                result()
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
    private fun result() {
        val tvRes = findViewById(R.id.tvResult) as TextView

        var data : String = String.format("%20s %20s %20s\n", "Title", "Artist", "Time")
        myList.forEach{data += String.format("%20s %20s %15s\n", it.title, it.artist, it.time)}

        tvRes.text = data
    }
    private fun letsPerform() {
    }
}