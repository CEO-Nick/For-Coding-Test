import java.util.*;

class Solution {
    
    static class Point {
        int x;
        int y;
        int food;
        
        Point(int x, int y, int food) {
            this.x = x;
            this.y = y;
            this.food = food;
        }
    }
    
    static char[][] grid;
    static boolean[][] visited;
    static int N;
    static int M;
    static List<Integer> ans;
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        grid = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            grid[i] = maps[i].toCharArray();
        }
        
        ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] != 'X') {
                    curFood = 0;
                    dfs(new Point(i, j, grid[i][j] - '0'));
                    ans.add(curFood);
                }
            }
        }
        
        if (ans.isEmpty()) return new int[] {-1}; 
        
        int[] answer = new int[ans.size()];
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);
        return answer;
    }
    
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int curFood = 0;
    
    public static void dfs(Point p) {
        visited[p.x][p.y] = true;
        curFood += p.food;
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dxs[i];
            int ny = p.y + dys[i];
            
            if (canGo(nx, ny)) dfs(new Point(nx, ny, (grid[nx][ny] - '0')));
        }
    }
    
    public static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;
        if (visited[nx][ny] || grid[nx][ny] == 'X') return false;
        
        return true;
    }
    
    public static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}