import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    int res = findRect(grid, i, j);
                    max = Math.max(max, res);
                }
            }
        }

        System.out.println(max);
    }

    public static int findRect(int[][] arr, int x, int y) {
        int minLen = Integer.MAX_VALUE;
        int maxRect = Integer.MIN_VALUE;
        int h = 1;
        int start = x; 

        do {
            int end = y;
            while (end < m && arr[start][end] > 0) {
                end++;
            }
            int len = end - y;
            minLen = Math.min(minLen, len);
            int rect = h * minLen;
            maxRect = Math.max(maxRect, rect);    
            // System.out.println("h : " + h + "\tlen : " + len + "\trect : " + rect);            
            h++;
            start++;

        } while (start < n && arr[start][y] > 0);

        return maxRect;
    }
    
}