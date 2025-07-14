import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = triangle[i].clone();
        }
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < dp.length; i++) {
            int len = dp[i].length;
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i-1][j];
                } else if (j == len - 1) {
                    dp[i][j] += dp[i-1][j-1];
                } else {
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        
        for (int j = 0; j < dp[dp.length-1].length; j++) {
            answer = Math.max(answer, dp[dp.length-1][j]);
        }
        return answer;
    }
}