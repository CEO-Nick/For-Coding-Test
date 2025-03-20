import java.util.*;

class Solution {
       
    int solution(int[][] land) {
        int n = land.length;
        // dp[i][j] = dp[i-1][0] ~ dp[i-1][3] 중에서 최댓값 + land[i][j]의 값
        int[][] dp = new int[n][4];
        
        for (int j = 0; j < 4; j++) dp[0][j] = land[0][j];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                
                dp[i][j] = max + land[i][j];
            }
            
        }
        
        int answer = -1;
        for (int j = 0; j < 4; j++) answer = Math.max(answer, dp[n-1][j]);
        
        return answer;
    }

}