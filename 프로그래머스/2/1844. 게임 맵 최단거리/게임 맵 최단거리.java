import java.util.*;

class Solution {
    /*
        동서남북 한 칸씩 이동
        맵 내에서 이동
        벽은 못 지나감
        못 도착할 수도 있음
        
        최단거리 -> BFS 활용
        visited 배열에 칸의 개수 최소값 넣기
    */
    
    static class Point {
        int x, y;
        int cnt;
        
        Point (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    
    static int N;
    static int M;
    
    static int[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        
        visited = new int[N][M];
                
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.addLast(new Point(0, 0, 1));
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dxs[i];
                int ny = p.y + dys[i];
                
                // 격자 밖이거나 벽인 경우 pass
                if (!inRange(nx, ny)) continue;
                if (maps[nx][ny] == 0) continue;
                
                if (visited[nx][ny] == 0) {
                    q.addLast(new Point(nx, ny, p.cnt+1));
                    visited[nx][ny] = visited[p.x][p.y] + 1;                    
                }
            }
        }
        
        answer = visited[N-1][M-1] == 0 ? -1 : visited[N-1][M-1];
        return answer;
    }
    
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}