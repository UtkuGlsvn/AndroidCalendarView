package com.example.calendaruitest

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val dayOfMonth: TextView

    init {
        dayOfMonth = itemView.findViewById(R.id.cellDayText)
    }

}