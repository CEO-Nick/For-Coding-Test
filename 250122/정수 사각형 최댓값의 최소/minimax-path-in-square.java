import java.util.*;
import java.io.*;

public class Main {
    
    static void DP() {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int up = dp[i-1][j];
                int left = dp[i][j-1];

                dp[i][j] = Math.max(Math.min(up, left), grid[i][j]);
            }
        }
    }

    static void init() {
        dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int k = 1; k < n; k++) {
            dp[0][k] = Math.max(dp[0][k-1], grid[0][k]);
            dp[k][0] = Math.max(dp[k-1][0], grid[k][0]);
        }
    }
    
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

        init();
        DP();

        System.out.println(dp[n-1][n-1]);
    }
}

