package com.example.calendaruitest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendaruitest.databinding.CalendarDayLayoutBinding

class CalendarAdapter(
    private val daysOfMonth: MutableList<String>,
    onItemListener: OnItemListener
) : RecyclerView.Adapter<CalendarViewHolder>() {
    private val onItemListener: OnItemListener

    init {
        this.onItemListener = onItemListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CalendarDayLayoutBinding.inflate(inflater, parent, false)
        val view: View = binding.root

        val layoutParams = view.layoutParams
        layoutParams.height = (parent.height * 0.1111).toInt()
        return CalendarViewHolder(binding, onItemListener)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.dayOfMonth.text = daysOfMonth[position]
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

    interface OnItemListener {
        fun onItemClick(position: Int, dayText: String?)
    }
}