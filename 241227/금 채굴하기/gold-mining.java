import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x;
        int y;
        int d;

        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int[][] grid;
    static boolean[][] visited;
    static int n;
    static int m;
    static int k;
    static int gold;
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 마름모가 격자 벗어나도 ㄱㅊ
        // K = 0 -> 현재 칸만 채굴
        // 채굴 비용 = 마름모 안의 격자 갯수 
        // 금 비용 - 채굴 비용 >= 0 -> 손해아님
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= n; l++) {
                    k = l;
                    int amount = k * k + ((k+1) * (k+1));
                    visited = new boolean[n][n];
                    gold = 0;
                    bfs(i, j);
                    if (gold * m - amount >= 0) {
                        max = Math.max(max, gold);
                    } 
                    
                }
            }
        }

        System.out.println(max);


    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x,y,0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (grid[cur.x][cur.y] == 1) gold++;
            if (cur.d == k) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i];
                int ny = cur.y + dys[i];
                // 격자 벗어남
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, cur.d + 1));
                }
            }
        }
        
    }
}