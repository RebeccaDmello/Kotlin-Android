package com.example.simplerecylerviewjson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplerecylerviewjson.databinding.ListItemBinding

class DataListAdapter(private val dataList: List<DataEntity>):
    RecyclerView.Adapter<DataListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        val binding = ListItemBinding.bind(itemView)

        init{
            println("ViewHolder")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        println("onCreateViewHolder")
        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val note = dataList[position]
        println("onBindViewHolder $position")

        with(holder.binding){
            theNoteTxt.text = note.text
        }
    }

}