class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1];
        for (int i = 0; i <= y; i++) dp[i] = Integer.MAX_VALUE;
        
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            if (i + n <= y) dp[i+n] = Math.min(dp[i] + 1, dp[i+n]);
            if (i * 2 <= y) dp[i*2] = Math.min(dp[i] + 1, dp[i*2]);
            if (i * 3 <= y) dp[i*3] = Math.min(dp[i] + 1, dp[i*3]);
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}