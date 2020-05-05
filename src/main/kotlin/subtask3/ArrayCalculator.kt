package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {

        var result = 0
        val pow = 1

        var i = 0
        var res: MutableList<Int> = mutableListOf()
        var arr_pol: MutableList<Int> = mutableListOf()
        var arr_otr: MutableList<Int> = mutableListOf()

        while(i < itemsFromArray.size)
        {
            try
            {
                var buf = itemsFromArray[i] as Int
                if (buf > 0) {arr_pol.add(buf)}
                if (buf < 0) {arr_otr.add(buf)}
            }
            catch (e:Exception) {;}
            finally  { i++; }
        }

        arr_pol.sort()
        arr_otr.sort()

        i = 0
        var oj = false

        while (i < numberOfItems)
        {
            if ((arr_pol.size > 0) or (arr_otr.size > 0))
            {
                if (arr_pol.size > 0)
                {
                    if (arr_otr.size != 0)
                    {
                        if ((arr_pol[arr_pol.size - 1] > arr_otr[0].absoluteValue) or (oj))
                        {
                            if (result == 0) { result = arr_pol[arr_pol.size - 1] } else { result *= arr_pol[arr_pol.size - 1] }
                            arr_pol.remove(arr_pol[arr_pol.size - 1]);
                            i++;
                        }
                        else
                        {
                            if ((arr_pol.size > 2) and (arr_otr.size > 2))
                            {
                                if ((arr_pol[arr_pol.size - 1] * arr_pol[arr_pol.size - 2]) < (arr_otr[0] * arr_otr[1]))
                                {
                                    if (result == 0) { result = (arr_otr[0] * arr_otr[1]) }
                                    else { result *= (arr_otr[0] * arr_otr[1]) }
                                    arr_otr.remove(arr_otr[0])
                                    arr_otr.remove(arr_otr[0])
                                    i += 2
                                }
                            } else { oj = true }
                        }
                    }
                    else
                    {
                        if (result == 0) { result = arr_pol[arr_pol.size - 1] }
                        else { result *= arr_pol[arr_pol.size - 1] }
                        arr_pol.remove(arr_pol[arr_pol.size - 1]);
                        i++;
                    }
                }
                else
                {
                    if (arr_otr.size > 0)
                    {
                        if (result == 0) {result = arr_otr[0]} else {result*=arr_otr[0]}
                        arr_otr.remove(arr_otr[0])
                        i++
                    }
                }

            }
            else { i = numberOfItems}
        }

        return result
    }
}
