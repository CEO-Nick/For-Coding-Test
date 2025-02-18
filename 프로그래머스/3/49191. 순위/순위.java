import java.util.*;

class Solution {
    // 1 : win, -1 : lose, 0 : ?
    static int[][] total;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        total = new int[n][n];
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0] - 1, loser = results[i][1] - 1;
            
            total[winner][loser] = 1;
            total[loser][winner] = -1;
        }
        
        // k번 선수를 기준으로 i > k > j or i < k < j 관계를 찾으려는 것 
        // i가 k를 이기고, k는 j를 이기면 -> i는 j를 이김 << 이런 관계를 찾아서 total을 채우자
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (total[i][k] == 1 && total[k][j] == 1) {
                        total[i][j] = 1;
                    } else if (total[i][k] == -1 && total[k][j] == -1) {
                        total[i][j] = -1;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            boolean find = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (total[i][j] == 0) {
                    find = false;
                    break;
                }
            }
            if (find) answer++;
        }
        return answer;
    }
}