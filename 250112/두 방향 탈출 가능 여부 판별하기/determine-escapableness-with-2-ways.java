import java.util.*;
import java.io.*;

public class Main {

    static int[] dxs = new int[] {1, 0};
    static int[] dys = new int[] {0, 1};
    static boolean[][] visited;
    static int order = 1;

    static void DFS(int x, int y) {

        for (int i = 0; i < 2; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];

            if (canGO(nx, ny)) {
                grid[nx][ny] = order++;
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }

    }

    static boolean canGO(int nx, int ny) {
        // 범위 밖인 경우
        if (!inRange(nx, ny)) return false;

        // 방문한 적 있거나 뱀이 있는 경우
        if (visited[nx][ny] || grid[nx][ny] == 0) return false;

        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }

    
    static int n;
    static int m;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        grid[0][0] = order++;
        visited[0][0] = true;
        DFS(0, 0);

        // 끝 칸이 1이면 탈출 불가능
        System.out.println(grid[n-1][m-1] == 1 ? 0 : 1);
    }
}
