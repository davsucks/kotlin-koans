package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            other.year == year -> when {
                other.month == month -> when {
                    other.dayOfMonth == dayOfMonth -> 0
                    other.dayOfMonth < dayOfMonth -> 1
                    else -> -1
                }
                other.month < month -> 1
                else -> -1
            }
            other.year < year -> 1
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

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>
