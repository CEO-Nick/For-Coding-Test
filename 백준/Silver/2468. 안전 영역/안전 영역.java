
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static int maxHeight = Integer.MIN_VALUE;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int amount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        int answer = 1;

        for (int i = 1; i <= maxHeight; i++) {
            amount = i;
            visited = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && graph[j][k] > amount) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (canGo(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }


    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) {
            return false;
        }

        // 이미 방문했거나, 잠긴 지역이라면 못감
        if (visited[nx][ny] || graph[nx][ny] <= amount) {
            return false;
        }

        return true;
    }

    /**
     * n x n 범위 안에 있는지 확인하는 함수
     */
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
}
