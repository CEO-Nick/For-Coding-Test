import java.util.*;

class Solution {
    
    static char[][] tmp;
    static char[][] cur;
    static int N;
    static int M;
    
    // 아래 / 오른쪽 / 대각 아래
    static int[] dxs = new int[] {1, 0, 1};
    static int[] dys = new int[] {0, 1, 1};
    
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N = m;
        M = n;
        tmp = new char[N][M];
        cur = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cur[i][j] = board[i].charAt(j);
            }
        }
        
        copy(cur, tmp);
        
        int before = 0;
        while (true) {
            copy(cur, tmp);
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < M - 1; j++) {
                    if (cur[i][j] != 'x' || cur[i][j] != '\0') {
                        erase(i, j);
                    }
                }
            }
            
            int count = countErased();
            if (count == 0) break;
            answer += count;
            before = count;
            gravity();
            copy(tmp, cur);
            // System.out.println(Arrays.deepToString(tmp));
        }
        

        return answer;
    }
    
    // 중력 적용
    static void gravity() {
        for (int j = 0; j < M; j++) {
            char[] newArr = new char[N];
            int idx = N - 1;
            
            for (int i = N - 1; i >= 0; i--) {
                if (tmp[i][j] == 'x') continue;
                newArr[idx--] = tmp[i][j];
            }
            for (int i = 0; i < N; i++) {
                tmp[i][j] = newArr[i];
            }
        }
    }
    
    
    // from 내용을 to로 복사
    static void copy(char[][] from, char[][] to) {
        for (int i = 0; i < N; i++) {
            to[i] = from[i].clone();
        }
    }
    
    // 해당 사이클에서 지워진 개수 확인
    static int countErased() {
        int count = 0;
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < M; j++) 
                if (tmp[i][j] == 'x') count++;
        
        return count;
    }
    
    // 날릴 수 있는지 확인
    static void erase(int x, int y) {
        char std = cur[x][y];
        for (int i = 0; i < 3; i++) {
            int nx = x + dxs[i], ny = y + dys[i];
            char next = cur[nx][ny];
            if (next == '\0') return;
            if (std != next) return;
        }
        
        // 여기 도달했다는건 2x2 지울 수 있다는거 -> tmp 배열에 기록
        tmp[x][y] = 'x';
        for (int i = 0; i < 3; i++) {
            int nx = x + dxs[i], ny = y + dys[i];
            tmp[nx][ny] = 'x';
        }
        return;
    }
}