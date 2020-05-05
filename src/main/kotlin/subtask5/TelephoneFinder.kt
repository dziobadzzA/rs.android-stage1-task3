package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var result:Array<String>? = null

        val list_number: List<Char> = listOf('8','2','4','1','3','5','2','6','1','5','7','2','4','6','8','3','5','9','4','8','5','7','9','0','8','6')
        val list_index: List<Char> = listOf('0','1','1','2','2','2','3','3','4','4','4','5','5','5','5','6','6','6','7','7','8','8','8','8','9','9')

        if (number.toInt() > 0)
        {
            var symbol = number.toCharArray()
            var result: MutableList<String> = mutableListOf()

            for (i in 0..symbol.size - 1)
            {
                for (j in 0..list_index.size - 1)
                {
                    if (list_index[j] == symbol[i])
                    {
                        var buf = ""
                        for (x in 0..symbol.size-1)
                        {
                            if (x!=i) { buf += symbol[x] }
                            else {buf += list_number[j]}
                        }
                        result.add(buf)
                    }
                }
            }

            var sbuf = Array<String>(result.size)
            {
                i -> result[i]
            }

            return sbuf
        }

        return result
    }


}
