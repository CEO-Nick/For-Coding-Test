import java.util.*;
import java.io.*;

public class Main {
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

        int maxK = 0;
        int am = 0;
        while (am < n*n) {
            am = maxK * maxK + ((maxK+1) * (maxK+1));
            maxK++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l <= n*2+1; l++) {
                    k = l;
                    int amount = k * k + ((k+1) * (k+1));
                    visited = new boolean[n][n];
                    gold = 0;
                    dfs(i, j, 0);
                    if (gold * m - amount >= 0) {
                        max = Math.max(max, gold);
                    //    System.out.println("i : " + i + "\tj : " + j + "\tk : " + k + "\tgold : " + gold);
                    } 
                }
            }
        }

        System.out.println(max);


    }

    public static void dfs(int x, int y, int depth) {
        visited[x][y] = true;
        if (grid[x][y] == 1) gold++;

        if (depth == k) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];
            // 격자 벗어남
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            
            if (!visited[nx][ny]) dfs(nx, ny, depth + 1);
        }
    }
}