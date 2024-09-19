
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] cost;
    static boolean[] visited;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        cost = new int[n+1];
        visited = new boolean[n+1];

        // 배열 값 초기화
        for (int i = 0; i <= n; i++) {
            cost[i] = INF;
            for (int j = 0; j <= n; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (graph[src][dist] > cost) {
                graph[src][dist] = cost;
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        cost[start] = 0;
        for (int i = 1; i <= n; i++) {
            int min = INF;
            int minIndex = -1;

            // cost 값이 제일 작은 정점 고르기
            for (int j = 1; j <=n; j++) {
                if (cost[j] < min && !visited[j]) {
                    min = cost[j];
                    minIndex = j;
                }
            }

            if (minIndex == -1) break;
            visited[minIndex] = true;

            // cost 갱신
            for (int j = 1; j <=n; j++) {
                if (cost[j] > cost[minIndex] + graph[minIndex][j]) {
                    cost[j] = cost[minIndex] + graph[minIndex][j];
                }
            }
        }

        System.out.println(cost[end]);
    }
}
