import java.util.*;

class Solution {
    // 사라진 인형 개수 구하기
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        
        // 스택 배열 선언 및 초기화
        ArrayDeque<Integer>[] boards = new ArrayDeque[N+1];
        for (int i = 1; i <= N; i++) {
            boards[i] = new ArrayDeque<Integer>();
        }
        
        // 2차원 배열을 stack 배열로 옮기기
        for (int j = N-1; j >= 0; j--) {
            for (int i = N-1; i >= 0; i--) {
                if (board[i][j] == 0) continue;
                boards[j+1].push(board[i][j]);
            }
        }
        
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        
        for (int idx : moves) {
            // 해당 라인이 빈 경우 pass
            if (boards[idx].isEmpty()) continue;
            
            int doll = boards[idx].pop();
            if (!basket.isEmpty() && basket.peek() == doll) {
                answer += 2;
                basket.pop();
                continue;
            }
            
            basket.push(doll);
        }
        
        return answer;
    }
}