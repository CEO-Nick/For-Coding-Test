import java.util.*;
import java.io.*;

public class Main {

    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int count;

    static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i], ny = y + dys[i];

            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                count++;
                DFS(nx, ny);
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        if (visited[nx][ny] || grid[nx][ny] != curValue) return false;

        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
    
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int curValue;
    
    public static void main(String[] args) throws IOException {
        // Please write your code here.    

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int block = 0;
        int maxSize = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    curValue = grid[i][j];
                    DFS(i, j);
                    if (count >= 4) {
                        block++;
                    }
                    maxSize = Math.max(maxSize, count);
                }
            }
        }

        System.out.println(block + " " + maxSize);

    }
}
