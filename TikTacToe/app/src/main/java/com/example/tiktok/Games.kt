package com.example.tiktok

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Games : AppCompatActivity() {
    //Instance Variables
    var input1: String? = ""
    var input2: String? = ""
    var toss: Int = 0
    var charDisplay: Char = 'X'
    val gridCnt = mutableListOf<Char>(' ', ',', ',', ',', ',', ',', ',', ',', ' ')
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        //Intents
        input1 = intent.getStringExtra("Play1")
        input2 = intent.getStringExtra("Play2")

        val adapterData = ArrayAdapter(this, R.layout.grid_layout, gridCnt)
        val gridId = findViewById(R.id.gridId) as GridView;
        gridId.adapter = adapterData
        gridId.setOnItemClickListener { adapterView, view, i, l ->
            gridCnt[i] = charDisplay
            toss++
            result()
            if (charDisplay == '0') {
                charDisplay = 'X'
            } else
                charDisplay = '0'
            adapterData.notifyDataSetChanged()
        }
    }

    private fun result() {
        // TODO("Not yet implemented")
        if (toss < 9) {
            if ((gridCnt[0] == 'X' && gridCnt[1] == 'X' && gridCnt[2] == 'X') || (gridCnt[0] == 'O' && gridCnt[1] == 'O' && gridCnt[2] == 'O')
                || (gridCnt[3] == 'X' && gridCnt[4] == 'X' && gridCnt[5] == 'X') || (gridCnt[3] == 'O' && gridCnt[4] == 'O' && gridCnt[5] == 'O')
                || (gridCnt[6] == 'X' && gridCnt[7] == 'X' && gridCnt[8] == 'X') || (gridCnt[6] == 'O' && gridCnt[7] == 'O' && gridCnt[8] == 'O')
                || (gridCnt[0] == 'X' && gridCnt[4] == 'X' && gridCnt[8] == 'X') || (gridCnt[0] == 'O' && gridCnt[4] == 'O' && gridCnt[8] == 'O')
                || (gridCnt[2] == 'X' && gridCnt[4] == 'X' && gridCnt[6] == 'X') || (gridCnt[2] == 'O' && gridCnt[4] == 'O' && gridCnt[6] == 'O')
                || (gridCnt[0] == 'X' && gridCnt[3] == 'X' && gridCnt[6] == 'X') || (gridCnt[0] == 'O' && gridCnt[3] == 'O' && gridCnt[6] == 'O')
                || (gridCnt[2] == 'X' && gridCnt[5] == 'X' && gridCnt[8] == 'X') || (gridCnt[2] == 'O' && gridCnt[5] == 'O' && gridCnt[8] == 'O')
            ) {
                val win: String? = if (charDisplay == 'X') {
                    input1
                } else {
                    input2
                }
                val intent = Intent(this, LetsWin::class.java)
                intent.putExtra("Winner", win + " WINS! ")
                startActivity(intent)
            }
        } else {
            val intent = Intent(this, LetsWin::class.java);
            intent.putExtra("Winner", "DRAW!!!!");
            startActivity(intent);
        }
    }
}
