package com.example.calendaruitest

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendaruitest.databinding.DayLayoutBinding

class DayViewHolder(itemView: DayLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
    val dayOfMonth: TextView

    init {
        dayOfMonth = itemView.cellDayText
    }

}