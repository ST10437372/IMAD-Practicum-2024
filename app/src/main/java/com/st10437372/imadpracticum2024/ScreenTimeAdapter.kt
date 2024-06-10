package com.st10437372.imadpracticum2024

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.st10437372.imadpracticum2024.databinding.ItemScreenTimeBinding

class ScreenTimeAdapter(private val data: List<ScreenTimeData>) :
    RecyclerView.Adapter<ScreenTimeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemScreenTimeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(screenTimeData: ScreenTimeData) {
            binding.textViewDate.text = screenTimeData.date
            binding.textViewMorningTime.text = screenTimeData.morningTime.toString()
            binding.textViewAfternoonTime.text = screenTimeData.afternoonTime.toString()
            binding.textViewNotes.text = screenTimeData.notes
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemScreenTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
