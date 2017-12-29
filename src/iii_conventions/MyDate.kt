package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            other.year == year && other.month == month && other.dayOfMonth == dayOfMonth -> 0
            other.year <= year && other.month <= month && other.dayOfMonth < dayOfMonth -> 1
            else -> -1
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
