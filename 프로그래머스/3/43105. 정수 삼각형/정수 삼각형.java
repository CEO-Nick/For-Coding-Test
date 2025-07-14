import java.util.*;

class Solution {
    // 위 -> 아래로 내려가는 방법(내 풀이)
//     public int solution(int[][] triangle) {
//         int answer = 0;
//         int[][] dp = new int[triangle.length][];
//         for (int i = 0; i < triangle.length; i++) {
//             dp[i] = triangle[i].clone();
//         }
        
//         dp[0][0] = triangle[0][0];
        
//         for (int i = 1; i < dp.length; i++) {
//             int len = dp[i].length;
//             for (int j = 0; j < len; j++) {
//                 if (j == 0) {
//                     dp[i][j] += dp[i-1][j];
//                 } else if (j == len - 1) {
//                     dp[i][j] += dp[i-1][j-1];
//                 } else {
//                     dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
//                 }
//             }
//         }
        
//         for (int j = 0; j < dp[dp.length-1].length; j++) {
//             answer = Math.max(answer, dp[dp.length-1][j]);
//         }
//         return answer;
//     }
    
    // 아래에서 위로 올라가는 방법
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }
        
        for (int i = n - 2; i >= 0; i--) {
            // i번째 행의 열 개수는 i+1개 
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        
        return dp[0][0];
    }
}