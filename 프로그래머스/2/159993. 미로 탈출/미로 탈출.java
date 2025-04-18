import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        int time;
        
        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static Point start;
    static Point lever;
    static Point end;
    static char[][] grid;
    static boolean[][] visited;
    static int N;
    static int M;
    static int ans = 0;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        grid = new char[N][M];
        
        // maps -> 2차원 배열 grid로 옮기기
        // 옮기면서 시작, 레버, 끝 지점 저장해두기
        for (int i = 0; i < N; i++) {
            char[] map = maps[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[j] == 'S') start = new Point(i, j, 0);
                else if (map[j] == 'L') lever = new Point(i, j, 0);
                else if (map[j] == 'E') end = new Point(i, j, 0);
                grid[i][j] = map[j];
            }
        }
        
        // 시작 ~ 레버까지 최단시간 ans에 저장
        bfs(start, lever);
        
        // 레버까지 갈 수 없으면 탈출 불가
        if (ans == 0) return -1;
            
        int before = ans;
        // 레버 ~ 출구까지 최단시간 조사
        bfs(lever, end);
        
        // 바뀐게 없으면 출구 도달 불가능
        if (before == ans) return -1;
        
        return ans;
    }
    
    
    // bfs로 최단거리 구하기
    public static void bfs(Point s, Point e) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(s);
        visited = new boolean[N][M];
        visited[s.x][s.y] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            if (cur.x == e.x && cur.y == e.y) {
                ans += cur.time;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i];
                int ny = cur.y + dys[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, cur.time + 1));
                }
            }
        }
    }
    
    // (nx, ny)로 갈 수 있는지 검증
    public static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;
        if (visited[nx][ny] || grid[nx][ny] == 'X') return false;
        
        return true;
    }
    
    // (nx, ny)가 N x M 범위 안에 있는지 검증
    public static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}