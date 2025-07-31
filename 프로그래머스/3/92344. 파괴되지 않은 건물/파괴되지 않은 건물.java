import java.util.*;

class Solution {
    // 내구도 0이하 -> 파괴
    // 파괴되었다가 회복을 통해 복구 가능
    // 이미 파괴되었어도 계속 내구도 하락함
    
    // skill 순회하면서 그리디하게 적용하면 시간 초과날 듯
    // 누적 합 활용? -> skill들을 누적합으로 계산 다 해두고 한번에 board에 반영
    // 이게 가능한 이유는 파괴되었어도 내구도 하락했다가 회복으로 복구될 수 있으니까
        // 한번 파괴되면 복구가 안된다면 순차적으로 적용해봐야 함
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[][] prefixSum = new int[n+1][m+1];
        for (int[] sk : skill) {
            int r1 = sk[1], c1 = sk[2], r2 = sk[3], c2 = sk[4];
            int degree = sk[0] == 1 ? -sk[5] : sk[5];
            
            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2+1] -= degree;
            prefixSum[r2+1][c1] -= degree;
            prefixSum[r2+1][c2+1] += degree;
        }
        
        // 누적합 반영하기
        // 행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i][j+1] += prefixSum[i][j];
            }
        }
        
        // 누적합 계산2 : 위쪽 -> 아래쪽
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                prefixSum[i+1][j] += prefixSum[i][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer += (board[i][j] + prefixSum[i][j]) > 0 ? 1 : 0; 
            }
        }
        return answer;
    }
}