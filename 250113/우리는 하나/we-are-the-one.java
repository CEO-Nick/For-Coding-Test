import java.util.*;
import java.io.*;

public class Main {

    static int[] dxs = new int[]{1, 0, -1, 0};
    static int[] dys = new int[]{0, 1, 0, -1};

    static class Point {

        int x;
        int y;
        int value;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    // 각 좌표에서 인접한 도시 방문하기
    static int BFS(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y, grid[x][y]));

        // 현재 k가 2이상일 때는 visited -> curVisted로 복사
        // 직전에서 골라진 도시에 대한 인접한 도시 방문 기록을 유지한 상태에서 진행해야 함
        if (curK > 1) {
            copyOrigin();
        } else {    // k가 1일 때는 새 배열로 유지
            curVisited = new boolean[n][n];
        }
        curVisited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];

                if (!inRange(nx, ny)) {
                    continue;
                }
                if (curVisited[nx][ny]) {
                    continue;
                }
                
                int diff = Math.abs(cur.value - grid[nx][ny]);
                if (u <= diff && diff <= d) {
                    curVisited[nx][ny] = true;
                    q.add(new Point(nx, ny, grid[nx][ny]));
                    count++;
                }
            }
        }

        // (x, y) 도시에서 방문 가능한 도시의 개수 반환
        return count;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }

    static void copyCur() {
        for (int i = 0; i < n; i++) {
            visited[i] = curVisited[i].clone();
        }
    }

    static void copyOrigin() {
        for (int i = 0; i < n; i++) {
            curVisited[i] = visited[i].clone();
        }
    }


    static int n;
    static int K;
    static int u;
    static int d;
    static int[][] grid;
    static boolean[][] visited;
    static boolean[][] curVisited;
    static int curK;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int k = 1; k <= K; k++) {
            curK = k;
            int maxCount = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int res = BFS(i, j);
                        // 도시 개수 최대일 때, curVisted -> visited로 복사
                        if (res > maxCount) {
                            copyCur();
                            maxCount = res;
                        }
                    }
                }
            }
            answer += maxCount;
        }

        System.out.println(answer);
    }
}
