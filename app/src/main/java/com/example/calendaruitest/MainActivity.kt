package com.example.calendaruitest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calendaruitest.databinding.ActivityMainBinding
import java.time.LocalDate


class MainActivity : AppCompatActivity(), CalendarAdapter.OnItemListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedDate: LocalDate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        selectedDate = LocalDate.now()
        setMonthView()
        setDayView()
        previousMonthAction()
        nextMonthAction()
    }


    private fun setDayView() {
        binding.dayRecyclerView.adapter = DayAdapter(getWeekDaysFromSelectedDate(selectedDate))
    }


    private fun setMonthView() {
        binding.monthYearTV.text = monthYearFromDate(selectedDate)
        val daysInMonth = daysInMonthArray(selectedDate)
        binding.calendarRecyclerView.adapter = CalendarAdapter(daysInMonth, this)
    }


    private fun previousMonthAction() {
        binding.monthPrevBtn.setOnClickListener {
            selectedDate = selectedDate.minusMonths(1L)
            setMonthView()
        }
    }

    private fun nextMonthAction() {
        binding.monthNextBtn.setOnClickListener {
            selectedDate = selectedDate.plusMonths(1L)
            setMonthView()
        }
    }


    override fun onItemClick(position: Int, dayText: String?) {
        if (dayText != "") {
            val message = "Selected Date " + dayText + " " + monthYearFromDate(selectedDate)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
