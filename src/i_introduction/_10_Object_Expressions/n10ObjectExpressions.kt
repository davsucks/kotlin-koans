package i_introduction._10_Object_Expressions

import java.util.*

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object : java.util.Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            return if (o1 == null) {
                if (o2 == null) 0 else 1
            } else o2?.compareTo(o1) ?: 1
        }
    })
    return arrayList
}
