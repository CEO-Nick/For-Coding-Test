import java.util.*;
import java.io.*;

public class Main {

    static int max = Integer.MIN_VALUE;
    
    static int[] dxs = new int[] {1, 0};
    static int[] dys = new int[] {0, 1};

    static void path(int curx, int cury, int min) {
        if (curx == n-1 && cury == n-1) {
            max = Math.max(max, min);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = curx + dxs[i], ny = cury + dys[i];

            if (inRange(nx, ny)) {
                int curMin = Math.min(min, grid[nx][ny]);
                path(nx, ny, curMin);
            }
        }

    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }

    // static void DP() {
    //     for (int i = 1; i < n; i++) {
    //         for (int j = 1; j < n; j++) {
    //             int up = dp[i-1][j];
    //             int left = dp[i][j-1];

    //             if (i == n - 1 && j == n - 1) {
    //                 dp[i][j] = Math.max(up, left);
    //                 continue;  
    //             }

    //             dp[i][j] = Math.min(Math.min(up, left), grid[i][j]);
    //         }
    //     }
    // }

    // static void init() {
    //     dp = new int[n][n];
    //     dp[0][0] = grid[0][0];
    //     for (int k = 1; k < n; k++) {
    //         dp[0][k] = Math.min(dp[0][k-1], grid[0][k]);
    //         dp[k][0] = Math.min(dp[k-1][0], grid[k][0]);
    //     }
    // }
    
    static int n;
    static int MOVE;
    static int[][] grid;
    static int[][] dp;

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

        // init();
        // MOVE = 2 * (n-1);
        // DP();

        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        path(0, 0, grid[0][0]);

        System.out.println(max);
    }
}
