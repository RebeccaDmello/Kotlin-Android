package com.example.simplerecylerviewjson

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplerecylerviewjson.databinding.MainFragment300322984Binding
import java.util.List.of
import java.util.stream.Collector.of

class MainFragment_300322984 : Fragment(){

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragment300322984Binding

    private lateinit var adapter: DataListAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate layout for this fragment
//        val v = inflater.inflate(R.layout.main_fragment_300322984, container, false)
//        val btn = v.findViewById<Button>(R.id.btn_main_page)
//        btn.setOnClickListener{
//            val secondFragment = SecondFragment_300322984()
//            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
//            transaction.replace(R.id. navHostFragment, secondFragment)
//            transaction.commit()
//        }
//        return  v

        binding = MainFragment300322984Binding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(binding.recyclerView){
            setHasFixedSize(true)
            val divider = DividerItemDecoration(context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.datasList.observe(viewLifecycleOwner, Observer{
            adapter = DataListAdapter(it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })
        return binding.root
    }
}