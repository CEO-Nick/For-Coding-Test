import java.util.*;
import java.io.*;

public class Main {

    // 실제 dp 계산 (위에서부터 차례로 진행)
    static void DP() {
        for (int i = 1; i < n; i++) {
            for (int j = n-2; j >= 0; j--) {
                int right = dp[i][j+1];
                int up = dp[i-1][j];
                int cur = grid[i][j];
                // 현재 위치의 최초 합은 내 왼쪽 or 위쪽에서 오는 경우 중 작은 값 + 내 현재 값
                dp[i][j] = Math.min(right, up) + cur;
            }
        }
    }

    
    // dp 배열 초기화(초기에 확실히 채워줄 수 있는 부분 채워놓기) <- i = 0인 행과 j = n-1인 열
    static void init() {
        dp = new int[n][n];
        dp[0][n-1] = grid[0][n-1];
        for (int i = n-2; i >= 0; i--) {
            dp[0][i] = dp[0][i+1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][n-1] = dp[i-1][n-1] + grid[i][n-1];
        }
    }

    static int[] dxs = new int[] {1, 0};
    static int[] dys = new int[] {0, 1};
    static int n;
    static int[][] grid;
    static int[][] dp;  // dp[i][j] << (i, j)까지 왔을 때 최소 합

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

        System.out.println(dp[n-1][0]);
    }
}
