import java.util.*;
import java.io.*;

public class Main {
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


    static void BFS(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y, 1));
        visited = new boolean[n][n];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            answer = Math.max(answer, cur.move);
            int curVal = grid[cur.x][cur.y];

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                if (inRange(nx, ny) && grid[nx][ny] > curVal) {
                    q.add(new Point(nx, ny, cur.move + 1));
                }
            }
        }
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                BFS(i, j);
            }
        }

        System.out.println(answer);

    }
}
