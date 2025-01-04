import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int value;
        int dir;

        Point(int v, int d) {
            value = v;
            dir = d;
        }
    }

    static int n;
    static Point[][] grid;
    static int[] dxs = new int[] {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dys = new int[] {0, 0, 1, 1, 1, 0, -1, -1, -1};
    static int r;
    static int c;
    static int max = Integer.MIN_VALUE;

    static void recur(int x, int y, int count) {
        Point cur = grid[x][y];
        int curValue = cur.value;
        int curDir = cur.dir;
        
        int nx = x; int ny = y;
        while (true) {
            nx += dxs[curDir];
            ny += dys[curDir];

            // nxn 범위 안에 있고 현재 숫자보다 큰 경우 -> canGo
            if (canGo(nx, ny, curValue)) {
                recur(nx, ny, count + 1);
            } else {
                max = Math.max(max, count);
                return;
            }
        }
    }

    static boolean canGo(int nx, int ny, int stdValue) {
        if (!inRange(nx, ny)) return false;
        if (grid[nx][ny].value < stdValue) return false;
        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        // 각 칸마다 중복 없는 1 ~ n*n 숫자 & 여덟 방향 중 하나
        // 다음 방향 숫자가 더 커야 이동 가능(방향에 있는 모든 숫자들로 이동 가능)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new Point[n][n];
        StringTokenizer st; 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Point(Integer.parseInt(st.nextToken()), 0);
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j].dir = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        recur(r, c, 1);
        System.out.println(max);
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(grid[i][j].value + " " + grid[i][j].dir + "\t");
        //     }
        //     System.out.println();
        // }
    }
}