import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        
        dp[n-1] = land[n-1].clone();
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    max = Math.max(dp[i+1][k], max);
                }
                dp[i][j] = land[i][j] + max;
            }
            
        }
        
        return Arrays.stream(dp[0]).max().getAsInt();
    }
}