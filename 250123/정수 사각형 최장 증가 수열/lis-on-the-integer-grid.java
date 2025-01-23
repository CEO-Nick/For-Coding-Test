import java.util.*;
import java.io.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int value;
        
        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }   

        @Override
        public int compareTo(Point p) {
            return this.value - p.value;
        }
    }


    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int n;
    static int[][] grid;
    static int[][] dp;
    static int answer = Integer.MIN_VALUE;
    static ArrayList<Point> points;

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

        points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                points.add(new Point(i, j, grid[i][j]));
            }
        }

        // dp 값 초기화
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        // 값으로 오름차순 정렬
        Collections.sort(points);

        int ans = 0;
        // 값이 제일 작은 좌표에서부터 4방향에 대해 dp 값 갱신
        for (int i = 0; i < points.size(); i++) {
            int cur_x = points.get(i).x;
            int cur_y = points.get(i).y;

            for (int j = 0; j < 4; j++) {
                int nx = cur_x + dxs[j], ny = cur_y + dys[j];
                if (inRange(nx, ny) && grid[nx][ny] > grid[cur_x][cur_y]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[cur_x][cur_y] + 1);
                    ans = Math.max(ans, dp[nx][ny]);
                }
            }
        }

        System.out.println(ans);

    }
}
