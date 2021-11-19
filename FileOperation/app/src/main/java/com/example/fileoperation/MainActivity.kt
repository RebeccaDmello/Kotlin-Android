package com.example.fileoperation

import Car
import Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.tabs.TabLayout

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MainActivity : AppCompatActivity() {
    private val fileContent = "mydata_300322984.json"
    private val dataType = Types.newParameterizedType(List::class.java, Person::class.java)
    var dataList = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt = FileHelper.getDataFromAssets(this, fileContent)

        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Person>> = moshi.adapter(dataType)
        dataList = adapter.fromJson(txt) as MutableList<Person>

        var lstAdapter = MyAdapter(this, dataList)
        val lstRes = findViewById(R.id.lvResult) as ListView
        lstRes.adapter = lstAdapter

        val tabId = findViewById(R.id.sortTab) as TabLayout
        tabId.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    //All content
                    0 -> {
                        //Default
                    }

                    //only last and first name
                    1 -> {
                        dataList =
                            dataList.sortedWith(compareBy({ it.last_name }, { it.first_name }))
                                .toMutableList()
                    }

                    //only cars
                    2 -> {
                        for (i in dataList.indices) {
                            val sortedCars: List<Car> = dataList[i].cars.sortedBy {
                                it.item
                            }.toMutableList()
                            dataList[i].cars = sortedCars
                        }
                    }
                }
                lstAdapter = MyAdapter(baseContext, dataList)
                lstRes.adapter = lstAdapter
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

    }
}