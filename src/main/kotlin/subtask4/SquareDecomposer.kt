package subtask4

import kotlin.math.roundToInt
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        var result: Array<Int>? = null
        var buf: MutableList<Int> = mutableListOf()

        var first = 0
        var popyt = 0
        var ok = true

        if ((number > 4) and (number != null))
        {
            var summa = (number - 1) * (number - 1)
            buf.add(number - 1)

            first = sqrt((number * number - summa).toFloat()).toInt()
            var map_table: MutableMap<Int, Int> = mutableMapOf()

             while (ok)
             {
                 first = sqrt((number * number - summa).toFloat()).toInt() - popyt
                 summa += (first * first)
                 buf.add(first)

                 for (x in 1..first-1) { map_table.put(x, x*x) }

                 var pp = 1

                 // уровень поиска 1
                 while (map_table.size > 0)
                 {
                        var x = first - pp
                        while (number * number > summa)
                        {
                            if (number * number - summa >= map_table[x]!!)
                            {
                                summa+=map_table[x]!!
                                buf.add(x)
                            }
                            if (x !=1) { x--; if (x==11){x--;}}
                        }

                        var len = buf.size

                        if (buf.distinct().size == len) { break }
                        else
                        {
                            buf.clear()
                            summa = (number - 1) * (number - 1) + first * first
                            buf.add(number - 1)
                            buf.add(first)
                            map_table.remove(first-pp)
                            pp++
                        }

                 }

                var len = buf.size

                if ((buf.distinct().size == len) and (summa == (number*number))) { ok = false }
                else
                {
                    buf.clear()
                    summa = (number - 1) * (number - 1)
                    buf.add(number - 1)
                    popyt++
                }
            }

        }

        if (buf.size > 0)
        {
            var result: Array<Int> = Array(buf.size, {0})
            var i = buf.size - 1
            while(i >= 0)
            {
                result[i] = buf.first()
                buf.remove(buf.first())
                i--
            }
            return result
        }

        return result
    }
}
