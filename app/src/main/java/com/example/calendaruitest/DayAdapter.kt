package com.example.calendaruitest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendaruitest.databinding.DayLayoutBinding

class DayAdapter(
    private val daysOfMonth: MutableList<String>
) : RecyclerView.Adapter<DayViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DayLayoutBinding.inflate(inflater, parent, false)
        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.dayOfMonth.text = daysOfMonth[position]
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

}