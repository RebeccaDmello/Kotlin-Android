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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm_300322984.databinding.DisplayFragmentBinding

class FragmentDisplay300322984 : Fragment(), JobAdapter.ListItemListener {

    private lateinit var binding: DisplayFragmentBinding
    private lateinit var adapter: JobAdapter

    companion object {
        fun newInstance() = FragmentDisplay300322984()
    }

    private lateinit var viewModel: DisplayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DisplayFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(DisplayViewModel::class.java)
        with (binding.recyclerView) {
            setHasFixedSize(true)
            val divider = DividerItemDecoration (context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.jobList?.observe(viewLifecycleOwner, Observer{
            adapter = JobAdapter(it, this@FragmentDisplay300322984)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var btnGoLogin= binding.root.findViewById<Button>(R.id.btnGoLogin)
        btnGoLogin.setOnClickListener {
            it.findNavController().navigate(R.id.loginFragment)
        }
    }

    override fun itemClicked(JobId: Int) {
        val action = FragmentDisplay300322984Directions.actionDisplayFragmentToDetailFragment(JobId)
        findNavController().navigate(action)
    }

}