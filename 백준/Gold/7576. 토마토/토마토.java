import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[][] storage;
    static int[][] visited;
    static List<Point> startPointList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        storage = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이미 모든 토마토가 익어있는 상태 -> 0
        // 토마토가 모두 익지는 못하는 상태 -> -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == 1) {
                    startPointList.add(new Point(i, j));
                }
            }
        }

        bfs();
        
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (visited[i][j] == 0) {
                    // 안익은 토마토가 있음
                    if (storage[i][j] != -1) {
                        System.out.println(-1);
                        return;
                    }
                }
                ans = Math.max(ans, visited[i][j]);
            }
        }

        if (ans == 1) {
            System.out.println(0);
        } else {
            System.out.println(ans - 1);
        }
        br.close();
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        visited = new int[n][m];

        for (Point point : startPointList) {
            q.add(new Point(point.x, point.y));
            visited[point.x][point.y] = 1;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (canGo(nx, ny)) {
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false;

        if (visited[x][y] != 0 || storage[x][y] == -1) return false;

        return true;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
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

