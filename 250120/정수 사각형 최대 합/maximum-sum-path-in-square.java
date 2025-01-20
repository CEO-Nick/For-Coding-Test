import java.util.*;
import java.io.*;

public class Main {

    // 실제 dp 계산 (위에서부터 차례로 진행)
    static void DP() {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int left = dp[i][j-1];
                int up = dp[i-1][j];
                int cur = grid[i][j];
                // 현재 위치의 최대합은 내 왼쪽 or 위쪽에서 오는 경우 중 큰 값 + 내 현재 값
                dp[i][j] = Math.max(left, up) + cur;
            }
        }
    }

    
    // dp 배열 초기화(초기에 확실히 채워줄 수 있는 부분 채워놓기) <- i = 0인 행과 j = 0인 열
    static void init() {
        dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
    }

    static int[] dxs = new int[] {1, 0};
    static int[] dys = new int[] {0, 1};
    static int n;
    static int[][] grid;
    static int[][] dp;  // dp[i][j] << (i, j)까지 왔을 때 최대합

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

        // dp 배열 초기화 및 초기 조건 세팅
        init();

        // DP 진행
        DP();  

        System.out.println(dp[n-1][n-1]);
    }
}
