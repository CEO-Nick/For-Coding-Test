import java.util.*;
import java.io.*;

public class Main {

    static boolean[] column;
    static ArrayList<Integer> choseCols;
    static int max = Integer.MIN_VALUE;

    static void choose(int row) {
        if (row == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += grid[i][choseCols.get(i)];
            }
            max = Math.max(max, sum);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (column[j]) continue;

            column[j] = true;
            choseCols.add(j);

            choose(row + 1);

            choseCols.remove(choseCols.size() - 1);
            column[j] = false;
        }
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

        column = new boolean[n];
        choseCols = new ArrayList<>(n);
        choose(0);

        System.out.println(max);
    }
}