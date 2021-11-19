package com.example.midterm_300322984

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.midterm_300322984.databinding.RegistrationFragmentBinding

class FragmentRegistration300322984 : Fragment() {

    private lateinit var binding: RegistrationFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = RegistrationFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var btnCancel= binding.root.findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            it.findNavController().navigate(R.id.mainFragment)
        }

        var btnSave = binding.root.findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            it.findNavController().navigate(R.id.loginFragment)
        }
    }
}