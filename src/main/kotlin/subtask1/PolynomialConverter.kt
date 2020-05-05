package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        var result: String? = null
        var len = numbers.size - 1

        var i = 0
        if (len > 0) {result = ""}

        while(len >= 0)
        {
            if (numbers[i] != 0)
            {
                if (i != 0)
                {
                    if (numbers[i] > 0) {result += "+ "}  else { result += "- "}
                }

                when (len)
                {
                    0 -> { if ((numbers[i].absoluteValue) != 0) result += (numbers[i].absoluteValue.toString()) }
                    1 -> { if ((numbers[i].absoluteValue) != 1) {result += (numbers[i].absoluteValue.toString() + "x ")} else { result += "x "} }
                    else -> { if ((numbers[i].absoluteValue) != 1) {result += (numbers[i].absoluteValue.toString() + "x^" + len.toString()) + " "} else { result += "x^" + len.toString() + " "} }
                }
            }
            len--
            i++
        }

        return  result
    }
}
