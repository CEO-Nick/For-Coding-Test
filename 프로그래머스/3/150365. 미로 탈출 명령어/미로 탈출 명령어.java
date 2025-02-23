import java.util.*;

class Solution {
    
    static class Point {
        int x;
        int y;
        int move;
        String path;
        
        Point(int x, int y, int move, String path) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.path = path;
        }
        
        @Override
        public String toString() {
          return "Relative{" +
              "x=" + x +
              ", y=" + y +
              ", move=" + move +
              ", path='" + path + '\'' +
              '}';
        }
    }
    
    // index 0 = d, 1 = l, 2 = r, 3 = u
    static int[] dxs = new int[] {1, 0, 0, -1};
    static int[] dys = new int[] {0, -1, 1, 0};
    static String answer;
    
    static void BFS(int startX, int startY) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(startX, startY, 0, ""));
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            // System.out.println(cur);
            
            if (cur.move == K && cur.x == R && cur.y == C) {
                answer = cur.path;
                break;
            } 
            
            if (cur.move >= K) continue;
            
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                if (inRange(nx, ny)) {
                    q.add(new Point(nx, ny, cur.move + 1, cur.path + direction.get(i)));
                }
            }
        }
    }
    
    // 격자 안에 있는지
    public static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
    
    static int[][] maze;
    static int K;
    static int N;
    static int M;
    static int R;
    static int C;
    
    static HashMap<Integer, String> direction;
    
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