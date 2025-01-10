import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + y + ")";
        }
    }

    static boolean[] row;
    static boolean[] column;
    static ArrayList<Point> chosePoints;
    static int max = Integer.MIN_VALUE;

    static void choose(int count) {
        if (count == n) {
            // for (Point p : chosePoints) System.out.print(p + " ");
            // System.out.println();
            int res = calculate();
            max = Math.max(max, res);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (row[i]) continue;
            for (int j = 0; j < n; j++) {
                if (column[j]) continue;
                
                row[i] = true;
                column[j] = true;
                chosePoints.add(new Point(i, j));
                choose(count + 1);

                row[i] = false;
                column[j] = false;
                chosePoints.remove(chosePoints.size() - 1);
            }
        }
    }

    static int calculate() {
        int sum = 0;
        for (Point p : chosePoints) {
            sum += grid[p.x][p.y];
        }

        return sum;
    }

    static int n;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = null;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        row = new boolean[n];
        column = new boolean[n];
        chosePoints = new ArrayList<>(n);
        choose(0);

        System.out.println(max);
    }
}