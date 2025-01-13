import java.util.*;
import java.io.*;

public class Main {

    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i], ny = y + dys[i];
            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        if (visited[nx][ny] || grid[nx][ny] <= curRain) return false;

        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx & nx < n && 0 <= ny && ny < m;
    }

    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static int curRain;
    static int minH = Integer.MAX_VALUE;
    static int maxH = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        // Please write your code here.    

        // k이하 잠김
        // k에 따라 안전 영역 개수 구하기
        // 안전 영역 수가 최대가 되는 k와 영역 수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, h);
                maxH = Math.max(maxH, h);
                grid[i][j] = h;
            }
        }

        int[] answer = new int[maxH+1];
        int maxArea = Integer.MIN_VALUE;

        for (int k = minH; k <= maxH; k++) {
            curRain = k;
            int area = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && grid[i][j] > curRain) {
                        DFS(i, j);
                        area++;
                    }
                }
            }
            maxArea = Math.max(maxArea, area);
            answer[k] = area;
        }
        
        for (int i = minH; i <= maxH; i++) {
            if (answer[i] == maxArea) {
                System.out.println(i + " " + answer[i]);
                return;
            }
        }

        return;
    }
}
