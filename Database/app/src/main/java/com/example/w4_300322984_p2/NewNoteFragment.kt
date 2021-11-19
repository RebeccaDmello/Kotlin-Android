package com.example.w4_300322984_p2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.w4_300322984_p2.databinding.FragmentNewNoteBinding
import java.util.*


class NewNoteFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentNewNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        binding.btnSave.setOnClickListener {
            val newNoteStr = binding.etNewNote.text.toString().trim()
            viewModel.addNewNote(NoteEntity(Date(), newNoteStr))
            it.findNavController().navigate(R.id.action_newNoteFragment_to_mainFragment)
        }
        return binding.root
    }

}