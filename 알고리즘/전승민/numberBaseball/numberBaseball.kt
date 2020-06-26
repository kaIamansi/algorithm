fun numberBaseball(baseball: Array<IntArray>): Int {
    var answer = 0
    (123..987).forEach { number ->
        val str = number.toString()
        if(str[0]==str[1]||str[1]==str[2]||str[0]==str[2]||str[0]=='0'||str[1]=='0'||str[2]=='0') return@forEach
        var check = true
        baseball.forEach {
            var strike = 0
            var ball = 0
            (0..2).forEach {i ->
                (0..2).forEach {j ->
                    if(str[i]==it[0].toString()[j]) {
                        if(i==j) strike++
                        else ball++
                    }
                }
            }
            if(strike!=it[1]||ball!=it[2]) check = false
        }
        if(check) answer++
    }
    return answer
}
// https://programmers.co.kr/learn/courses/30/lessons/42841