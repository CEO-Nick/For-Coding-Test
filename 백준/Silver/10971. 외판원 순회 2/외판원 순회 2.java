import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] costs;
    private static int n;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        costs = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) costs[i][j] = Integer.parseInt(input[j]);
        }

        visited = new boolean[n];
        tsp(0, 0, 0, 0);

        System.out.println(answer);
    }

    private static void tsp(int start, int node, int cost, int count) {
        if (count == n && node == start) {
            answer = Math.min(answer, cost);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 방문한 적 없고, 갈 수 있다면
            if (!visited[i] && costs[node][i] != 0) {
                visited[i] = true;
                tsp(start, i, cost + costs[node][i], count + 1);
                visited[i] = false;
            }
        }
    }
}
