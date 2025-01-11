import java.util.*;
import java.io.*;

public class Main {

    // colList.get(i) << grid[i][colList.get(i)] 
    static ArrayList<Integer> colList;
    static int max = Integer.MIN_VALUE;

    static void choose(int row) {
        if (row == n) {
            int res = findMin();
            max = Math.max(max, res);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visited[j]) continue;
            
            visited[j] = true;
            colList.add(j);
            
            choose(row+1);

            visited[j] = false;
            colList.remove(colList.size() - 1);
        }
    }

    static int findMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, grid[i][colList.get(i)]);
        }
        return min;
    }

    static int n;
    static int[][] grid;
    static boolean[] visited;

    
    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        colList = new ArrayList<>();

        choose(0);

        System.out.println(max);
    }
}