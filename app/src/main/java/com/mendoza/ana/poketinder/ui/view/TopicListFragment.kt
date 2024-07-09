package com.mendoza.ana.poketinder.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.FragmentTopicListBinding
import com.mendoza.ana.poketinder.ui.adapter.TopicAdapter
import com.mendoza.ana.poketinder.ui.model.Subject
import com.mendoza.ana.poketinder.ui.model.Topic
class TopicListFragment : Fragment(R.layout.fragment_topic_list) {

    private lateinit var binding: FragmentTopicListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicListBinding.bind(view)
        // Activa la flecha de regreso
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val subject = arguments?.getParcelable<Subject>("subject")
        subject?.let {
            // Actualizando el mensaje de bienvenida para incluir el nombre del tema
            binding.tvWelcomeMessage.text = "${it.title}"

            val topicAdapter = TopicAdapter(it.topics) { topic ->
                navigateToTopicDetail(topic)
            }
            binding.rvTopics.layoutManager = LinearLayoutManager(context)
            binding.rvTopics.adapter = topicAdapter

            binding.searchViewTopic.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean = true
                override fun onQueryTextChange(newText: String?): Boolean {
                    val filteredTopics = it.topics.filter { topic ->
                        topic.title.contains(newText ?: "", ignoreCase = true)
                    }
                    topicAdapter.updateTopics(filteredTopics)
                    return true
                }
            })
        }
    }

    private fun navigateToTopicDetail(topic: Topic) {
        val bundle = Bundle().apply {
            putParcelable("topic", topic)
        }
        findNavController().navigate(R.id.action_topicListFragment_to_topicDetailFragment, bundle)
    }
}

/*

class TopicListFragment : Fragment(R.layout.fragment_topic_list) {

    private lateinit var binding: FragmentTopicListBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicListBinding.bind(view)


        val subject = arguments?.getParcelable<Subject>("subject")
        subject?.let {
            val topicAdapter = TopicAdapter(it.topics) { topic ->
                navigateToTopicDetail(topic)
            }
            binding.rvTopics.layoutManager = LinearLayoutManager(context)
            binding.rvTopics.adapter = topicAdapter

            binding.searchViewTopic.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean = true
                override fun onQueryTextChange(newText: String?): Boolean {
                    val filteredTopics = it.topics.filter { topic ->
                        topic.title.contains(newText ?: "", ignoreCase = true)
                    }
                    topicAdapter.updateTopics(filteredTopics)
                    return true
                }
            })
        }
    }


    private fun navigateToTopicDetail(topic: Topic) {
        val bundle = Bundle().apply {
            putParcelable("topic", topic)
        }
        findNavController().navigate(R.id.action_topicListFragment_to_topicDetailFragment, bundle)
    }
}
 */