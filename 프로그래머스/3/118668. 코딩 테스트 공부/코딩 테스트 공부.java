import java.util.*;

class Solution {
    // 0이상 정수
    // 알고력 1 높이기 = 1시간 (코딩력도 동일)
    // 각 문제 풀면 능력 올라감
    // 같은 문제 여러 번 풀기 가능
    
    // return : 주어진 문제 모두 풀 수 있는 최단 시간 -> 실제 모든 문제 풀으라는 말이 아님
    
    // 문제를 풀 수 있는 순서로 정렬해야 된다. 요구 알고력, 코딩력 낮은 순으로 -> 같은 경우 효율 높은 순
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int alpMax = 0;
        int copMax = 0;
        
        for (int[] problem : problems) {
            alpMax = Math.max(alpMax, problem[0]);
            copMax = Math.max(copMax, problem[1]);
        }
        
        alpMax = Math.max(alpMax, alp);
        copMax = Math.max(copMax, cop);
        
        // 이미 모든 문제 풀 능력 갖춤
        if (alp >= alpMax && cop >= copMax) return 0;
        
        // dp[10][15] = 알고력 10, 코딩력 15를 갖기 위한 최소 시간
        int[][] dp = new int[alpMax+1][copMax+1];
        
        for (int i = 0; i <= alpMax; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE-10000);
        }
        
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= alpMax; i++) {
            for (int j = cop; j <= copMax; j++) {
                if (i < alpMax) dp[i+1][j] = Math.min(dp[i][j] + 1, dp[i+1][j]);
                if (j < copMax) dp[i][j+1] = Math.min(dp[i][j] + 1, dp[i][j+1]);
                
                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nextAlp = Math.min(alpMax, i + problem[2]);
                        int nextCop = Math.min(copMax, j + problem[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        
        return dp[alpMax][copMax];
    }
}