package com.mendoza.ana.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mendoza.ana.poketinder.databinding.ItemSettingBinding

data class SettingItem(val iconRes: Int, val title: String, val description: String)

class SettingsAdapter(
    private val items: List<SettingItem>,
    private val onItemClick: (SettingItem) -> Unit
) : RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val binding = ItemSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingsViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class SettingsViewHolder(
        private val binding: ItemSettingBinding,
        private val onItemClick: (SettingItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SettingItem) {
            binding.icon.setImageResource(item.iconRes)
            binding.title.text = item.title
            binding.description.text = item.description
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}
