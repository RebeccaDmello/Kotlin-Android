package com.example.midterm_300322984

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.midterm_300322984.databinding.MainFragmentBinding
import com.example.midterm_300322984.db.JobEntity
import com.example.midterm_300322984.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.main_fragment.*

class FragmentMain300322984 : Fragment() {

    private val myType = Types.newParameterizedType(List::class.java, JobEntity::class.java)
    private val FILENAME = "nyc_jobs_me.json"
    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel
    //private var jobList : List<MovieEntity>? = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MainFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val text = FileHelper.getDataFromAssets(requireContext(),FILENAME)

        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val json_adapter : JsonAdapter<List<JobEntity>> = moshi.adapter(myType)

        val jobList = json_adapter.fromJson(text)

        viewModel.addData(jobList)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        display_all.setOnClickListener {
            it.findNavController().navigate(R.id.displayFragment)
        }

        search.setOnClickListener{
            it.findNavController().navigate(R.id.searchFragment)
        }

        var btnReg = binding.root.findViewById<Button>(R.id.btnReg)
        btnReg.setOnClickListener {
            it.findNavController().navigate(R.id.registrationFragment)
        }

        var btnLogin = binding.root.findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.loginFragment)
        }
    }

}