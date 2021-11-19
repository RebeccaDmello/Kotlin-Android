package com.example.fileoperationrecyclerview.utilities

import android.content.Context
import java.io.BufferedReader

class JsonFileHandler {
    companion object{
        fun getDataFromAssets(context: Context, fileName: String): String{
            return context.assets.open(fileName).use{
                it.bufferedReader().use{
                    bf:BufferedReader->bf.readText()
                }
            }
        }
    }
}