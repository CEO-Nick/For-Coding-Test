
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid;
    static int[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new int[n][m];
        String input;

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));
        visited[x][y] = 1;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!q.isEmpty()) {
            Point current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i], ny = current.y + dy[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = visited[current.x][current.y] + 1;
                    q.add(new Point(nx, ny));
                }

                if (nx == n - 1 && ny == m - 1) {
                    System.out.println(visited[nx][ny]);
                    return;
                }
            }

        }
    }

    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) {
            return false;
        }

        if (visited[nx][ny] != 0 || grid[nx][ny] == 0) {
            return false;
        }

        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }

    static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
