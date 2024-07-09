package com.mendoza.ana.poketinder.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.FragmentInformationBinding


class InformationFragment : Fragment(R.layout.fragment_information) {

    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        return binding.root
        // Activa la flecha de regreso
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
