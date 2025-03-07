import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] prefixSum = new int[N + 1][M + 1];
        
        int answer = 0;
        // 0이하가 되면 파괴 (파괴되어도 공격받으면 내구도 계속 하락) -> 나중에 회복으로 되살릴 수도 있으니까
        // 회복시키면 파괴된 거 복구 가능
        // 스킬에서 type 1 : 적공격 | type 2: 회복 스킬 | degree 만큼 올리고 낮추는
        for (int[] sk : skill) {
            int r1 = sk[1], c1 = sk[2], r2 = sk[3], c2 = sk[4];
            int degree = sk[0] == 1 ? -sk[5] : sk[5];
            
            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2+1] += (-degree);
            prefixSum[r2 + 1][c1] += (-degree);
            prefixSum[r2+1][c2+1] += degree;
        }
        
        // 누적합 계산1 : 왼쪽 -> 오른쪽
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                prefixSum[i][j+1] += prefixSum[i][j];
            }
        }
        
        // 누적합 계산2 : 위쪽 -> 아래쪽
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                prefixSum[i+1][j] += prefixSum[i][j];
            }
        }
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer += (board[i][j] + prefixSum[i][j] > 0 ? 1 : 0); 
            }
        }
        return answer;
    }
}