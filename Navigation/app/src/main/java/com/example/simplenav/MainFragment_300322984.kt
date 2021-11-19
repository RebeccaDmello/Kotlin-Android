package com.example.simplenav

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.main_fragment_300322984.*

class MainFragment_300322984 : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate layout for this fragment
        val v = inflater.inflate(R.layout.main_fragment_300322984, container, false)
        val btn = v.findViewById<Button>(R.id.btn_main_page)
        btn.setOnClickListener{
            val secondFragment = SecondFragment_300322984()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.navHostFragment, secondFragment)
            transaction.commit()
        }
        return  v
    }

}