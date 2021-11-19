package com.example.midterm_300322984

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm_300322984.databinding.DisplayFragmentBinding
import com.example.midterm_300322984.databinding.SearchResultsFragmentBinding

class SearchResultsFragment : Fragment() {

    private lateinit var viewModel: SearchResultsViewModel
    private lateinit var binding : SearchResultsFragmentBinding
    private val args: SearchResultsFragmentArgs by navArgs()
    private lateinit var adapter: SearchResultAdapter

    companion object {
        fun newInstance() = FragmentDisplay300322984()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SearchResultsFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(SearchResultsViewModel::class.java)
        with (binding.recyclerViewSearch) {
            setHasFixedSize(true)
            val divider = DividerItemDecoration (context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.jobList?.observe(viewLifecycleOwner, Observer{
            adapter = SearchResultAdapter(it)
            binding.recyclerViewSearch.adapter = adapter
            binding.recyclerViewSearch.layoutManager = LinearLayoutManager(activity)
        })

        viewModel.getJOBSById(args.searchType,args.searchValue)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchResultsViewModel::class.java)

    }

}