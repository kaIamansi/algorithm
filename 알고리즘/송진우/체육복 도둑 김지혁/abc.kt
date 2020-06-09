class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size //잃어버린애들 전체 수에서 빼주기

        //잃어버린애가 두벌가져온애인지 확인(참 : -10 대입, reserve자격박탈)
        for (i in reserve.indices) {
            for (j in lost.indices) {
                //자격박탈된애들 빼주기
                if (lost[j] == -10 && reserve[i] == -10) {
                    continue
                }
                //reserve 자격 박탈
                if (lost[j] == reserve[i]) {
                    lost[j] = -10
                    reserve[i] = -10
                    answer++
                }
            }
        }
        for (i in lost.indices) {
            for (j in reserve.indices) {
                if (lost[i] == -10 || reserve[j] == -10) {
                    continue
                }
                //바로
                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    answer++
                    reserve[j] = -10
                    break
                }
            }
        }

        return answer
    }
}
