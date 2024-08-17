import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int t;
    static int l;
    static int x;
    static int y;
    static int tx;
    static int ty;

    static int[][] visited;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        String[] input;
        while (t-- > 0) {
            l = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            tx = Integer.parseInt(input[0]);
            ty = Integer.parseInt(input[1]);

            bfs();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() throws IOException {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));
        visited = new int[l][l];
        visited[x][y] = 1;
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (canGo(nx, ny)) {
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }

                if (nx == tx && ny == ty) {
                    bw.write(visited[nx][ny] - 1 + "\n");
                    return;
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false;

        if (visited[x][y] != 0) return false;

        return true;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < l && 0 <= y && y < l;
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