import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        int cnt;
        int dir;
        
        Point(int x, int y, int cnt, int dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
    
    static int N;
    static int M;
    static char[][] grid;
    static Point start;
    static Point end;
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    
    static int answer = -1;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        grid = new char[N][M];
        
        // grid 배열로 옮기기 & 시작, 끝 점 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = board[i].charAt(j);
                if (grid[i][j] == 'R') start = new Point(i, j, 0, 0);
                if (grid[i][j] == 'G') end = new Point(i, j, 0, 0);
            }
        }
        
        bfs();
        
        return answer;
    }
    
    static boolean[][] visited;
    
    public static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        visited = new boolean[N][M];
        visited[start.x][start.y] = true;
        
        for (int i = 0; i < 4; i++) 
            q.add(new Point(start.x, start.y, 0, i));
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == end.x && cur.y == end.y) {
                answer = cur.cnt;
                return;
            }
            
            int curx = cur.x;
            int cury = cur.y;
            int d = cur.dir;
            while (true) {
                int nx = curx + dxs[d];
                int ny = cury + dys[d];

                if (!canGo(nx, ny)) break;

                curx = nx; cury = ny;
            }
            
            if (visited[curx][cury]) continue;
            
            visited[curx][cury] = true;
            
            if (d % 2 == 0) {
                q.add(new Point(curx, cury, cur.cnt + 1, 1));
                q.add(new Point(curx, cury, cur.cnt + 1, 3));
            } else {
                q.add(new Point(curx, cury, cur.cnt + 1, 0));
                q.add(new Point(curx, cury, cur.cnt + 1, 2));
            }
            
            // System.out.println(q);
        }
    }
    
    // (nx, ny)가 벽이거나 좌표 밖이면 false
    public static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny) || grid[nx][ny] == 'D') return false;
        
        return true;
    }
    
    public static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}