package com.mendoza.ana.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mendoza.ana.poketinder.databinding.ItemTopicBinding
import com.mendoza.ana.poketinder.ui.model.Topic

class TopicAdapter(
    private var topics: List<Topic>,
    private val onTopicClick: (Topic) -> Unit
) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val binding = ItemTopicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicViewHolder(binding, onTopicClick)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(topics[position])
    }

    override fun getItemCount(): Int = topics.size

    fun updateTopics(newTopics: List<Topic>) {
        this.topics = newTopics
        notifyDataSetChanged()
    }

    class TopicViewHolder(
        private val binding: ItemTopicBinding,
        private val onTopicClick: (Topic) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(topic: Topic) {
            binding.tvTopicTitle.text = topic.title

            binding.root.setOnClickListener {
                onTopicClick(topic)
            }
        }
    }
}
