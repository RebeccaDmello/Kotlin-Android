package com.example.fileoperationrecyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fileoperationrecyclerview.database.AppDatabase
import com.example.fileoperationrecyclerview.database.model.Employee
import com.example.fileoperationrecyclerview.ui.MyCustomAdapter
import com.example.fileoperationrecyclerview.utilities.JsonFileHandler
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.sql.Types

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            prepopulate(this, "employee.json")
        }catch (e: Exception){
            d("MyLog:","prepopulate failed")
        }

        var empList = AppDatabase.getDatabase(this).appDao().getAllEmployees()

        var emps= mutableListOf<String>()

        empList?.forEach {
            var str = it.firstName + " " + it.lastName + " "+ it.gender
            emps.add(str)
        }

        var myAdapter = MyCustomAdapter(emps!!)

        rv_mainActivity.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_mainActivity.adapter = myAdapter

        var job = GlobalScope.launch{
            some()
        }
    }

    suspend fun some(){

    }

    private fun prepopulate(ctx: Context, fileName: String) {
        val myType = com.squareup.moshi.Types.newParameterizedType(List::class.java, Employee::class.java)

        val inputTxt = JsonFileHandler.getDataFromAssets(ctx, fileName)

        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<List<Employee>> = moshi.adapter(myType)
        var empList = adapter.fromJson(inputTxt)

        Log.d("MyTag:",empList?.get(0).toString())

        empList?.forEach {
            AppDatabase.getDatabase(ctx).appDao().insertEmployees(it)
            Log.d("MyTag:",it.firstName)
        }
    }

}