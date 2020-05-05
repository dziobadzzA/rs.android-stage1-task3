package subtask6

class FullBinaryTrees {

    val O_obraz = ",0,0"; val null_obraz = ",null,null"

    fun recursiv(shetchik: Int, string_in: String, level_current: Int): ArrayList<String>
    {
        var res_out: ArrayList<String> = arrayListOf()

        if (shetchik==0) { res_out = arrayListOf(string_in) }
        else
        {
            var level_etap = level_current + 1
            res_out = recursiv( shetchik - 2, string_in + O_obraz,level_current+1)
            if (level_current > 1) res_out.addAll(recursiv( shetchik, string_in + null_obraz,level_current-1))
        }

        return  res_out
    }


    fun stringForNodeCount(count: Int): String
    {
        var result_buf: String = ""

        if(count == 1) { result_buf = "[0]" }
        else
        {
            if (count % 2 != 0)
            {
                val const_one_level = "0";
                var level_one = 1
                for (buf in recursiv(count - 1, const_one_level, level_one))
                {
                    result_buf += "[" + buf + "]"
                }
            }
        }

        val result = "[" + result_buf + "]"
        return result
    }

}

