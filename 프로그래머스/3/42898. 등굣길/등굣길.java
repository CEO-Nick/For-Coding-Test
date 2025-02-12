import java.util.*;

class Solution {
    
    static int X = Integer.MAX_VALUE;
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]-1][puddles[i][0]-1] = X;
        }
        
        // init
        for (int j = 1; j < m; j++) {
            if (dp[0][j] == X) break;
                dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (dp[i][0] == X) break;
                dp[i][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == X) continue;
                
                int left = dp[i][j-1] != X ? dp[i][j-1] : 0;
                int up = dp[i-1][j] != X ? dp[i-1][j] : 0;
                dp[i][j] = (left + up) % 1000000007;
            }
        }
                
        return dp[n-1][m-1];
    }
}