import java.util.*;

class Solution {
    
    static class Point {
        int x, y;
        int time;
        
        Point (int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    
    static char START = 'S';
    static char EXIT = 'E';
    static char LEVER = 'L';
    static char ROAD = 'O';
    static char WALL = 'X';
    
    static int N;
    static int M;
    static char[][] grid;
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        Point start = null;
        Point lever = null;
        Point exit = null;
        grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char type = maps[i].charAt(j);
                grid[i][j] = type;
                if (type == START) start = new Point(i, j, 0);
                else if (type == EXIT) exit = new Point(i, j, 0);
                else if (type == LEVER) lever = new Point(i, j, 0);
            }
        }
        
        int toLever = BFS(start, lever);
        if (toLever == 0) return -1;
        else answer += toLever;
        
        int toExit = BFS(lever, exit);
        if (toExit == 0) return -1;
        else answer += toExit;
        
        return answer;
    }
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static boolean[][] visited;
    
    static int BFS(Point first, Point target) {
        visited = new boolean[N][M];
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(first);
        visited[first.x][first.y] = true;
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            if (cur.x == target.x && cur.y == target.y) {
                return cur.time;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i];
                int ny = cur.y + dys[i];
                
                if (!inRange(nx, ny)) continue;
                if (grid[nx][ny] == WALL) continue;
                if (visited[nx][ny]) continue;
                
                q.add(new Point(nx, ny, cur.time + 1));
                visited[nx][ny] = true;
            }
        }
        return 0;
    }
    
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}