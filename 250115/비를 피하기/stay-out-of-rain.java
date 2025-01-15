import java.util.*;
import java.io.*;

public class Main {

    static class Point{
        int x;
        int y;
        int dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static boolean[][] visited;

    static void BFS(Point s) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(s);
        visited = new boolean[n][n];
        visited[s.x][s.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                
                // 다음 칸이 범위 안에 있고, 벽이 아닌 경우
                if (canGo(nx, ny)) {
                    // 사람이 있는 칸인 경우
                    if (grid[nx][ny] == 2) {
                        answer[nx][ny] = Math.min(answer[nx][ny], cur.dist + 1);
                    }
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, cur.dist + 1));
                }
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        if (visited[nx][ny] || grid[nx][ny] == 1) return false;

        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }

    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    static int n;
    static int h;
    static int m;
    static int[][] grid;
    static int[][] answer;
    static ArrayList<Point> shelters;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        // 0 : 이동 가능한 칸
        // 1 : 벽 (이동 불가능한 칸)
        // 2 : 사람 존재한다는 칸
        // 3 : 비를 피할 수 있는 칸
        // 한 칸당 1초 소요
        // 벽이 아닌 곳은 전부 이동 가능 = 1 빼고 모두 이동 가능
        // 각 사람마다 비를 피할 수 있는 가장 가까운 공간까지의 거리
        // 절대 비 못피하면 << -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        answer = new int[n][n];
        shelters = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 3) shelters.add(new Point(i, j, 0));
            }
        }

        init(); // answer 배열 초기화(모두 MAX_VALUE로)

        for (Point shelter : shelters) {
            BFS(shelter);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ans = answer[i][j];
                if (ans == Integer.MAX_VALUE) {
                    if (grid[i][j] == 2) ans = -1;
                    else ans = 0;
                } 
                System.out.print(ans + " ");
            }
            System.out.println();
        }


    }
}
