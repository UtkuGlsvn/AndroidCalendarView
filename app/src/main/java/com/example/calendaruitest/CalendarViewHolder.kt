package com.example.calendaruitest

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendaruitest.databinding.CalendarDayLayoutBinding

class CalendarViewHolder(itemView: CalendarDayLayoutBinding, onItemListener: CalendarAdapter.OnItemListener) :
    RecyclerView.ViewHolder(itemView.root), View.OnClickListener {
    val dayOfMonth: TextView
    private val onItemListener: CalendarAdapter.OnItemListener

    init {
        dayOfMonth = itemView.cellDayText
        this.onItemListener = onItemListener
        itemView.root.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        onItemListener.onItemClick(layoutPosition, dayOfMonth.text as String)
    }
}
