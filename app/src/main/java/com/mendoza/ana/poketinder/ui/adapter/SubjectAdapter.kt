package com.mendoza.ana.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.databinding.ItemSubjectBinding
import com.mendoza.ana.poketinder.ui.model.Subject
import com.mendoza.ana.poketinder.ui.viewmodel.SubjectsViewModel

class SubjectAdapter(
    private var subjects: List<Subject>,
    private val subjectsViewModel: SubjectsViewModel,
    private val onItemClicked: (Subject) -> Unit
) : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = ItemSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding, subjectsViewModel, onItemClicked)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(subjects[position])
    }

    override fun getItemCount(): Int = subjects.size

    fun updateSubjects(newSubjects: List<Subject>) {
        this.subjects = newSubjects
        notifyDataSetChanged()
    }

    class SubjectViewHolder(
        private val binding: ItemSubjectBinding,
        private val subjectsViewModel: SubjectsViewModel,
        private val onItemClicked: (Subject) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        /*fun bind(subject: Subject) {
            binding.tvSubjectTitle.text = subject.title
            binding.tvSubjectDescription.text = subject.description
            binding.tvSubjectAmount.text = subject.amount
            binding.ivFavorite.setImageResource(
                if (subject.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_24
            )
            Glide.with(binding.ivSubjectImage.context)
                .load(subject.imageUrl)
                .into(binding.ivSubjectImage)

            binding.root.setOnClickListener {
                onItemClicked(subject)
            }

            binding.ivFavorite.setOnClickListener {
                subjectsViewModel.toggleFavorite(subject)
            }
        }*/
        fun bind(subject: Subject) {
            binding.tvSubjectTitle.text = subject.title
            binding.tvSubjectDescription.text = subject.description
            binding.tvSubjectAmount.text = subject.amount
            binding.ivFavorite.setImageResource(
                if (subject.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_24
            )

            // Directly set the image from drawable resource
            binding.ivSubjectImage.setImageResource(subject.imageUrl)

            binding.root.setOnClickListener {
                onItemClicked(subject)
            }

            binding.ivFavorite.setOnClickListener {
                subjectsViewModel.toggleFavorite(subject)
            }
        }

    }
}
