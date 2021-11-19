package com.example.midterm_300322984

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.midterm_300322984.databinding.SearchFragmentBinding

class SearchFragment : Fragment() {


    private lateinit var viewModel: SearchViewModel
    private lateinit var binding : SearchFragmentBinding
    private var searchValue : String = ""
    private var searchType : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = SearchFragmentBinding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        binding.btnSearch.setOnClickListener {

            if(binding.rdoFt.isChecked){
                searchValue = binding.editTextSearch.text.toString()
                searchType = 1
            }
            else if(binding.rdoPt.isChecked) {
                searchValue = binding.editTextSearch.text.toString()
                searchType = 2
            }
            else if(binding.rdoJobCat.isChecked){
                searchValue = binding.editTextSearch.text.toString()
                searchType = 3

            }
            else if(binding.rdoPosType.isChecked){
                searchValue = binding.editTextSearch.text.toString()
                searchType = 4
            }
            Toast.makeText(requireContext(),searchValue.toString(), Toast.LENGTH_SHORT).show()
            val action = SearchFragmentDirections.actionSearchFragmentToSearchResultsFragment(searchType,searchValue)
            it.findNavController().navigate(action)

        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var btnSearch= binding.root.findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener {
            it.findNavController().navigate(R.id.searchResultsFragment)
        }
    }

}