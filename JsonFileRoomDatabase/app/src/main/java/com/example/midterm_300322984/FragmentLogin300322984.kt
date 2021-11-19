package com.example.midterm_300322984

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.midterm_300322984.databinding.LoginFragmentBinding

class FragmentLogin300322984 : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = LoginFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var btnLog = binding.root.findViewById<Button>(R.id.btnLog)
        btnLog.setOnClickListener {
            it.findNavController().navigate(R.id.displayFragment)
        }

        var btnGoMain = binding.root.findViewById<Button>(R.id.btnGoMain)
        btnGoMain.setOnClickListener {
            it.findNavController().navigate(R.id.mainFragment)
        }
    }
}