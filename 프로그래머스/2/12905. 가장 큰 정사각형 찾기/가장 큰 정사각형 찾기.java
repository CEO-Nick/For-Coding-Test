class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;

        if (n == 1 && m == 1) {
            if (board[0][0] == 0) return 0;
            else return 1;
        }
            
        // board[i][j] = 4 -> (i, j)를 우측 하단 꼭짓점으로 하는 정사각형의 가능한 최대 변의 길이가 4이다
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 0) continue;
                // 좌측, 상단, 좌측 대각선 값 중 최솟값 + 1이 현재 좌표에서 만들 수 있는 최대 정사각형 한 변의 길이
                board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        return answer * answer;
    }
}