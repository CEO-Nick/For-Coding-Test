import java.util.*;

class Solution {
    
    static int K;
    static int N;
    static int M;
    static int R;
    static int C;
    
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        
        // x,y <-> r,c 의 맨하튼 거리(=최소거리) 구하기
        int dist = Math.abs(r-x) + Math.abs(c-y);
        int diff = k - dist;
        
        // 최소거리 이동 거리보다 k 값 작거나, 최소거리로 목적지 도착한 후에 왕복 못하는 경우
        // diff 값이 홀수면 도착지에서 왔다갔다를 할 수 없음
        if (diff < 0 || diff % 2 == 1) return "impossible";
        
        // 애초에 사전순으로 움직이자 (d > l > r > u)
        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            int[] next = next(x, y);
            x += next[0];
            y += next[1];
            sb.append((char)next[2]);
        }
        
        
        
        return sb.toString();
    }
    
    static int[] next(int x, int y) {
        if (x + 1 <= N && Math.abs(x+1 - R) + Math.abs(y - C) <= K) {
            return new int[] {1, 0, 'd'};
        } else if (y - 1 >= 1 && Math.abs(x - R) + Math.abs(y-1 - C) <= K ) {
            return new int[] {0, -1, 'l'};
        } else if (y + 1 <= M && Math.abs(x - R) + Math.abs(y+1 - C) <= K ) {
            return new int[] {0, 1, 'r'};
        } else {
            return new int[] {-1, 0, 'u'};
        }
    }
    
}