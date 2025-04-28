import java.util.*;

class Solution {
    public int solution(String[] board) {
        int OCount = 0;
        int XCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') OCount++;
                if (board[i].charAt(j) == 'X') XCount++;
            }
        }
        
        // X가 O보다 많으면 규칙 위반
        if (XCount > OCount) return 0;
        
        // O가 X보다 2개 이상 많으면 규칙 위반
        if (OCount - XCount >= 2) return 0;
        
        // O가 이겼는데 X 개수가 같거나 많으면 규칙 위반
        if (win(board, 'O')) {
            if (XCount >= OCount) return 0;
        }
        
        // X가 이겼는데 O개수가 많으면 규칙 위반
        if (win(board, 'X')) {
            if (OCount > XCount) return 0;
        }
        
        return 1;
    }  
    
    // 매개변수로 들어온 mark가 이겼는지 확인
    public boolean win(String[] board, char mark) {
        // 행 확인
        for (int i = 0; i < 3; i++) {
            boolean isSame = true;
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) != mark) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return true;
        }
        
        // 열 확인
        for (int i = 0; i < 3; i++) {
            boolean isSame = true;
            for (int j = 0; j < 3; j++) {
                if (board[j].charAt(i) != mark) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return true;
        }
        
        // 대각 확인
        if (board[0].charAt(0) == mark && board[1].charAt(1) == mark && board[2].charAt(2) == mark) return true;
        if (board[0].charAt(2) == mark && board[1].charAt(1) == mark && board[2].charAt(0) == mark) return true;
        return false;
    }
}