package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
       
        var poster = array[0]
        var color = array[array.size - 1]
        var result:Int? = null
        
        for (i in 1..color+1)
        {
            var buf = combinator(color, i)

            if (buf == poster)
            {
                result = i
                break
            }
        }

       return result
    }

    fun combinator(n:Int, m: Int): Int
    {
        var result = 1.0

        for (j in n-m+1..n) { result*= j }
        for (j in 1..m) { result/= j }

        return result.toInt()
    }
}
