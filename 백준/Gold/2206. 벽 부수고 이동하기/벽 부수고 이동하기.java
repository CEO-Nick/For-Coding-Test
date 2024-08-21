
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    static int[][] map;
    static int[][][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 : 벽  0 : 이동 가능
        // 1, 1 -> N, M으로 이동
        // 최단 경로 (시작, 끝 칸도 포함해서 카운트)
        // 벽 최대 1개 부술 수 있음 -> 벽 부수고 가는 걸 "찬스 사용" 이라고 하겠음
        // 불가능하면 -1 출력

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String input;
        map = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j-1) - '0';
            }
        }

        bfs();

        if (visited[n][m][0] == 0 && visited[n][m][1] == 0) System.out.println(-1);
        
        br.close();
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(1, 1, 0));
        visited = new int[n+1][m+1][2];
        visited[1][1][0] = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == n && cur.y == m) {
                System.out.println(visited[cur.x][cur.y][cur.useChance]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 밖이거나 방문했으면 pass
                if (notInRange(nx, ny)) continue;

                // 아직 방문한 적 없다면
                if (visited[nx][ny][cur.useChance] == 0) {
                    // 갈 수 있는 곳이라면
                    if (map[nx][ny] == 0) {
                        visited[nx][ny][cur.useChance] = visited[cur.x][cur.y][cur.useChance] + 1;
                        q.add(new Point(nx, ny, cur.useChance));
                    }
                    // 벽인데 찬스가 있다면
                    else if (map[nx][ny] == 1 && cur.useChance == 0) {
                        visited[nx][ny][1] = visited[cur.x][cur.y][cur.useChance] + 1;
                        q.add(new Point(nx, ny, 1));
                    }
                }
            }
        }
    }
    static boolean notInRange(int i, int j) {
        return i <= 0 || i > n || j <= 0 || j > m;
    }

    static class Point {
        int x;
        int y;
        int useChance;

        Point(int x, int y, int useChance) {
            this.x = x;
            this.y = y;
            this.useChance = useChance;
        }
   }
}