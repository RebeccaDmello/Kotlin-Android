package com.example.fileoperation

import Person
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(val context: Context, val personList: List<Person>) : BaseAdapter() {
    private lateinit var firstName: TextView
    private lateinit var lastName: TextView
    private lateinit var cars: TextView

    override fun getCount(): Int {
        return personList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, position1: View?, parent: ViewGroup?): View {
        var convertView = position1
        convertView = LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false)
        firstName = convertView.findViewById(R.id.tvFirstName)
        lastName = convertView.findViewById(R.id.tvLastName)
        cars = convertView.findViewById(R.id.tvCars)

        firstName.text = "First Name: ${personList[position].first_name}"
        lastName.text = "Last Name: ${personList[position].last_name}"

        cars.text = "Cars: ${personList[position].cars.joinToString(", ")}"

        return convertView
    }
}