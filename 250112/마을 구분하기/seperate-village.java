import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> list;
    static int order;

    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    static void DFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i], ny = y + dys[i];

            if (canGo(nx, ny)) {
                grid[nx][ny] = order++;
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        if (visited[nx][ny] || grid[nx][ny] == 0) return false;

        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
 
    static int n;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());   

        StringTokenizer st;
        grid = new int[n][n];
        visited = new boolean[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == 0) continue;
                
                order = 0;
                visited[i][j] = true;
                grid[i][j] = order++;
                DFS(i, j);
                list.add(order);
            }
        }

        System.out.println(list.size());

        list.sort(Comparator.comparingInt(o -> o));
        for (int num : list) System.out.println(num);

    }
}
