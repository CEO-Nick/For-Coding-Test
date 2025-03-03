import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        int move;
        
        Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    
    static boolean[][] visited;
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    
    static void BFS() {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        answer[0][0] = 1;
        
        while (!q.isEmpty()) {
            Point cur = q.poll();    
            
            if (cur.x == n-1 && cur.y == m-1) {
                answer[cur.x][cur.y] = Math.min(answer[cur.x][cur.y], cur.move);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, cur.move + 1));
                    answer[nx][ny] = answer[nx][ny] == 0 ? cur.move + 1 : Math.min(answer[nx][ny], cur.move + 1);
                }
            }
        }
        
    }
    
    static boolean canGo(int nx, int ny) {
        // 범위 밖인 경우
        if (!inRange(nx, ny)) return false;
        
        // 방문했거나 벽인 경우
        if (visited[nx][ny] || grid[nx][ny] == 0) return false;
        
        return true;
    }
    
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }
    
    static int[][] answer;
    static int[][] grid;
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        grid = maps;
        visited = new boolean[n][m];
        answer = new int[n][m];
        
        BFS();
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
        return answer[n-1][m-1] == 0 ? -1 : answer[n-1][m-1];
    }
}