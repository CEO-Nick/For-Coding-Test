import java.util.*;
import java.io.*;

public class Main {

    static void DP(int curx, int cury) {
        for (int i = 0; i < curx; i++) {
            for (int j = 0; j < cury; j++) {
                if (grid[i][j] < grid[curx][cury]) {
                    dp[curx][cury] = Math.max(dp[curx][cury], dp[i][j] + 1);
                }
            }
        }
    }


     
    // 현재 좌표로 점프할 이전 좌표 값이 현재 좌표 값보다 작고, (1, 1) 이상 좌표 차이 발생하는지
    // static boolean canJumpToHere(int curx, int cury, int nx, int ny) {
    //     return grid[nx][ny] < grid[curx][cury] && Math.abs(curx-nx) >= 1 && Math.abs(cury - ny) >= 1;
    // }

    static void init() {
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;
            }
        }
        dp[0][0] = 1;
    }

    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int n;
    static int m;
    static int[][] grid;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        // 현재 값보다 큰 칸으로만 점프 가능
        // 점프할 때 무조건 (1, 1) 이상 

        // 다른 칸에서 자신의 칸으로 올 수 있는 경우의 수 찾아서 업데이트
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

        init();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                DP(i, j);
            }
        }
        
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
