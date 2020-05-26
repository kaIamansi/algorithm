function solution(s) {
    if(s.length % 2 == 0)
    {
        return s.slice(parseInt(s.length / 2 - 1) , parseInt(s.length / 2 + 1))
    }
    else
        return s[parseInt(s.length / 2)]
}