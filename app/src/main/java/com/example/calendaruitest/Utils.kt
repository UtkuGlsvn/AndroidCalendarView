package com.example.calendaruitest

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.time.temporal.WeekFields
import java.util.Locale

fun getWeekDaysFromSelectedDate(date: LocalDate): MutableList<String> {
    val daysOfWeekList = mutableListOf<String>()
    val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek

    var day = date.with(firstDayOfWeek)

    for (i in 1..7) {
        val dayName = day.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
        daysOfWeekList.add(dayName)
        day = day.plusDays(1)
    }

    return daysOfWeekList
}

fun monthYearFromDate(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("MMMM yyyy")
    return date.format(formatter)
}

fun daysInMonthArray(date: LocalDate): MutableList<String> {
    val daysInMonthArray = ArrayList<String>()
    val yearMonth = YearMonth.from(date)
    val daysInMonth = yearMonth.lengthOfMonth()
    val firstOfMonth = date.withDayOfMonth(1)
    val dayOfWeekOfFirst = firstOfMonth.get(WeekFields.of(Locale.getDefault()).dayOfWeek())

    val blankCells = if (dayOfWeekOfFirst == 7) 0 else dayOfWeekOfFirst - 1
    repeat(blankCells) {
        daysInMonthArray.add("")
    }

    for (day in 1..daysInMonth) {
        daysInMonthArray.add(day.toString())
    }

    while (daysInMonthArray.size < 42) {
        daysInMonthArray.add("")
    }

    return daysInMonthArray
}