import java.util.*;

class Solution {

    static int N;
    static boolean[][] visited;
    static int[][] costs;
    static int[][] grid;
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    
    public int solution(int[][] board) {
        N = board.length;
        grid = board;
        visited = new boolean[N][N];

        costs = new int[N][N];
                
        return Math.min(BFS(0, 0, 0, 0), BFS(0, 0, 0, 1));
    }
    
    static class Point {
        int x;
        int y;
        int cost;
        int dir;
        
        Point(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
    
    static boolean canGo(int nx, int ny) {
        // n x n 범위 밖인 경우
        if (nx < 0 || nx >= N || ny < 0 || ny >= N) return false;
        
        // 벽인 경우
        if (grid[nx][ny] == 1) return false;
        
        return true;
    }
    
    static int BFS(int x, int y, int cost, int dir) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y, cost, dir));
        
        initCosts();
                
        while (!q.isEmpty()) {
            Point cur = q.poll();
                      
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                if (!canGo(nx, ny)) continue;
                
                int nCost = cur.dir == i ? cur.cost + 100 : cur.cost + 600;
                
                if (nCost < costs[nx][ny]) {
                    costs[nx][ny] = nCost;
                    q.add(new Point(nx, ny, nCost, i));
                }
                
            }
        }
        return costs[N-1][N-1];
    }
    
    static void initCosts() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}