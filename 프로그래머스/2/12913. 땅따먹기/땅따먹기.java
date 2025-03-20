import java.util.*;

class Solution {
       
    int solution(int[][] land) {
        int n = land.length;
        // dp[i][j] = dp[i-1][0] ~ dp[i-1][3] 중에서 최댓값 + land[i][j]의 값
        int[][] dp = new int[n][4];
        
        for (int j = 0; j < 4; j++) dp[0][j] = land[0][j];
        
        for (int i = 1; i < n; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
        }
        
        int answer = -1;
        for (int j = 0; j < 4; j++) answer = Math.max(answer, land[n-1][j]);
        
        return answer;
    }

}