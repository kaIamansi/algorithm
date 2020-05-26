public class TileOrnament {
    public long solution(int N) {
        long[] dp = new long[81];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N-1]*2+dp[N]*2;
    }
}

// https://programmers.co.kr/learn/courses/30/lessons/43104