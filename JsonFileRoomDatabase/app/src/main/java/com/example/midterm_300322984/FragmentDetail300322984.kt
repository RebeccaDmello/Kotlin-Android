package com.example.midterm_300322984

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.midterm_300322984.databinding.DetailFragmentBinding

class FragmentDetail300322984 : Fragment() {


    private lateinit var viewModel: DetailViewModel
    private lateinit var binding : DetailFragmentBinding
    private val args: FragmentDetail300322984Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DetailFragmentBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.currentJob?.observe(viewLifecycleOwner, Observer {

            binding.textViewDetail.setText("Job ID: " + it.JobId.toString() + "\nAgency: " + it.Agency + "\nPosting Type: " + it.PostingType +
                    "\n# of Pos: " + it.NoOfPos + "\nBusiness Title: " + it.BusinessTitle + "\nCivil Service Title: " + it.CivilServiceTitle+
                    "\nJob Category: " + it.JobCategory+ "\nFull-Time/Part-Time indicator: " + it.FtPt + "\nSalary Range: " + it.SalaryF+ "-" +
                    it.SalaryT+ "\nWork Location: " + it.WorkLocation+ "\nDivision/Work Unit: " + it.WorkUnit+ "\nJob Description: " + it.JobDescription.substring(0,80)+
                    "\nPosting Date: " + it.PostingDate)

        })

        viewModel.getJobByJobId(args.jobId)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
        var btnBk = binding.root.findViewById<Button>(R.id.btnBk)
        btnBk.setOnClickListener {
            it.findNavController().navigate(R.id.displayFragment)
        }
    }

}

