package i_introduction._11_SAM_Conversions

import java.util.Collections

fun task11(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList) { o1, o2 ->
        if (o1 == null) {
            if (o2 == null) 0 else 1
        } else o2?.compareTo(o1) ?: 1
    }
    return arrayList
}
