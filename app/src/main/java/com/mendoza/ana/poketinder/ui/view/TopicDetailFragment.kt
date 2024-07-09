package com.mendoza.ana.poketinder.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.FragmentTopicDetailBinding
import com.mendoza.ana.poketinder.ui.model.Topic

class TopicDetailFragment : Fragment(R.layout.fragment_topic_detail) {

    private lateinit var binding: FragmentTopicDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicDetailBinding.bind(view)
        // Activa la flecha de regreso
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val topic = arguments?.getParcelable<Topic>("topic")
        topic?.let {

            binding.tvTopicTitle.text = it.title

            binding.tvTopicDefinition.text = it.definition
            binding.tvTopicTerms.text = it.terms
            binding.tvTopicDescription.text = it.description
        }
    }
}
