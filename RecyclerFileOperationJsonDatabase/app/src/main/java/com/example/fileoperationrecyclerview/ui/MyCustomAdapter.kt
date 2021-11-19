package com.example.fileoperationrecyclerview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fileoperationrecyclerview.R
import kotlinx.android.synthetic.main.list_item.view.*

class MyCustomAdapter(private var list: MutableList<String>):
    RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
      val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.txtFName.text = list[position]
        holder.itemView.txtLName.text = list[position]
        holder.itemView.txtGender.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(v: View) : RecyclerView.ViewHolder(v)
}