
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] field;
    static boolean[][] visited;
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] answer = new int[T];
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] inputs = br.readLine().split(" ");
            M = Integer.parseInt(inputs[0]);
            N = Integer.parseInt(inputs[1]);
            int K = Integer.parseInt(inputs[2]);

            field = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                String[] input = br.readLine().split(" ");
                int y = Integer.parseInt(input[0]);
                int x = Integer.parseInt(input[1]);
                field[x][y] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] != 1 || visited[i][j]) continue;

                    answer[t]++;
                    dfs(i, j);
                }
            }
            sb.append(answer[t]).append("\n");
        }

        System.out.println(sb);
    }

    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (field[nx][ny] == 0|| visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

}
