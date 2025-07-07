import java.util.*;

class Solution {
    
    static class Point {
        int x, y;
        int dir;
        int cost;
        
        Point(int x, int y, int b, int c) {
            this.x = x;
            this.y = y;
            this.dir = b;
            this.cost = c;
        }
    }
    
    
    static int N;
    static int INF = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        N = board.length;
        cost = new int[N][N];
    
        return Math.min(BFS(board, 0), BFS(board, 1));
    }
    
    static int[][] cost;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;
    
    static int BFS(int[][] board, int startDir) {
        ArrayDeque<Point> q = new ArrayDeque<>();    
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], INF);
        }
        
        q.add(new Point(0, 0, startDir, 0));
        cost[0][0] = 0;
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (!inRange(nx, ny)) continue;
                if (board[nx][ny] == 1) continue;
                
                int nextCost = cur.dir == i ? cur.cost + 100 : cur.cost + 600;
                if (nextCost < cost[nx][ny]) {
                    cost[nx][ny] = nextCost;
                    q.add(new Point(nx, ny, i, nextCost));
                }
            }
        }
        
        return cost[N-1][N-1];
    }
    
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }
    
    static boolean isCorner(int before, int current) {
        if (before % 2 == 0 && current % 2 == 1) return true;
        else if (before % 2 == 1 && current % 2 == 0) return true;
        
        return false;
    }
}