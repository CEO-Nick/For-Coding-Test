import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static int r1;
    static int c1;
    static int r2; 
    static int c2;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) grid[i][j] = Integer.parseInt(st.nextToken());
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken())-1;
            c1 = Integer.parseInt(st.nextToken())-1;
            r2 = Integer.parseInt(st.nextToken())-1;
            c2 = Integer.parseInt(st.nextToken())-1;

            blow();
        }

        for (int i = 0; i < n; i++) {
            for (int a : grid[i]) System.out.print(a + " ");
            System.out.println();
        }

    }

    public static void blow() {
        // 윗변
        int tmp1 = grid[r1][c2];
        for (int j = c2; j > c1; j--) {
            grid[r1][j] = grid[r1][j-1];
        } 
        
        // 오른쪽 변
        int tmp2 = grid[r2][c2];
        for (int i = r2-1; i > r1; i--) {
            grid[i+1][c2] = grid[i][c2];
        }
        grid[r1+1][c2] = tmp1;

        // 아랫변
        tmp1 = grid[r2][c1];
        for (int j = c1 + 1; j < c2; j++) {
            grid[r2][j-1] = grid[r2][j];
        }
        grid[r2][c2-1] = tmp2;

        // 왼쪽 변
        for (int i = r1+1; i < r2; i++) {
            grid[i-1][c1] = grid[i][c1];
        }
        grid[r2-1][c1] = tmp1;

        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(grid[i]));
        // }
        // System.out.println();
        sideEffect();

    }

    public static void sideEffect() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = grid[i].clone();
        }
    
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                calcAvg(tmp, i, j);
            }
        }
    }

    static int[] dxs = new int[]{1, 0, -1, 0};
    static int[] dys = new int[]{0, 1, 0, -1};

    public static void calcAvg(int[][] tmp, int x, int y) {
        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(tmp[i]));
        // }
        // System.out.println();

        int sum = tmp[x][y];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                count++;
                sum += tmp[nx][ny];
            }
        }
        grid[x][y] = sum / count;
        // System.out.println("x : " + x + "\ty : " + y + "\tsum : " + sum + "\tcount : " + count);
    }
}