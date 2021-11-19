package com.example.mynavcompdemo1

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynavcompdemo1.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    /*
        MainViewModel extends ViewModel (which is abstract)
        contains val notesList = MutableLiveData<List<NoteEntity>>()
        and retrieves data from SampleDataProvider.

     */
    private lateinit var viewModel: MainViewModel

    /*
        MainFragmentBinding refers to main_fragment.xml
     */
    private lateinit var binding : MainFragmentBinding // name convention: name of the class + Binding

    /*
        NotesListAdapter is for the RecyclerView
     */
    private lateinit var adapter: NotesListAdapter   // the instance

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater,container,false)

        println ("1. MainFragment -- calling MainViewModel")

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        
        with (binding.recyclerView) {
            println ("3. binding.recyclerView")
            setHasFixedSize(true) // all rows would have a fix size regardless of its contents

            // to create a divider to separate each row
            val divider = DividerItemDecoration (context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.notesList.observe(viewLifecycleOwner, Observer {
            println ("5. viewModel.noteList.observe ... instantiating NoteListAdapter")
            adapter = NotesListAdapter(it)

            println ("6. next stop, binding.recylcerView.adapter")
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })
        println ("4. binding.root is returned")
        return binding.root   // now, have access to all the elements in the main_fragment.xml
    }

}