
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int row, col, cost;
        public Point(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    static int[][] maze;
    static int[][] broke;
    static int n;
    static int m;
    static int INF = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        broke = new int[n][m];

        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j) - '0';
                broke[i][j] = INF;
            }
        }

        // 항상 제일 적게 벽 부수는 좌표가 먼저 처리된다
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};

        broke[0][0] = 0;
        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (broke[now.row][now.col] < now.cost) continue;
            if (now.row == n - 1 && now.col == m - 1) break;

            for (int i = 0; i < 4; i++) {
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];

                if (!inRange(nx, ny)) continue;

                if (broke[nx][ny] > broke[now.row][now.col] + maze[nx][ny]) {
                    broke[nx][ny] = broke[now.row][now.col] + maze[nx][ny];
                    pq.offer(new Point(nx, ny, broke[nx][ny]));
                }
            }
        }

        System.out.println(broke[n-1][m-1]);
    }

    static boolean inRange(int i, int j) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }
}
