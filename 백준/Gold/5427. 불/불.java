
import java.io.*;
import java.util.*;

public class Main {
    static int w;
    static int h;

    static char[][] map;
    static int[][] movePath;
    static int[][] firePath;

    static boolean[][] visited;
    static List<Point> startFireList = new ArrayList<>();

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            String input;
            Point startPoint = null;

            for (int i = 0; i < h; i++) {
                input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '@') startPoint = new Point(i, j);
                    else if (map[i][j] == '*') startFireList.add(new Point(i, j));
                }
            }

            canGoOut(startPoint);

            int answer = Integer.MAX_VALUE;

            // 테두리만 순회해서 시간복잡도 O(w + h)로 만들기
            for (int i = 0; i < h; i++) {
                if (i == 0 || i == h - 1) {
                    for (int j = 0; j < w; j++) {
                        if (visited[i][j]) {
                            answer = Math.min(answer, movePath[i][j]);
                        }
                    }
                } else {
                    if (visited[i][0]) {
                        answer = Math.min(answer, movePath[i][0]);
                    } else if (visited[i][w-1]) {
                        answer = Math.min(answer, movePath[i][w-1]);
                    }
                }
            }

            if (answer == Integer.MAX_VALUE) {
                bw.write("IMPOSSIBLE" + "\n");
            } else {
                bw.write(answer + "\n");
            }
            startFireList.clear();
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void canGoOut(Point startPoint) {
        // 대피 경로 체크
        moveBfs(startPoint);
        // 불길의 경로 체크
        fireBfs();

        // 대피 경로 따라가면서 불길이 왔던적 있는지 확인해보기
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(startPoint);
        visited = new boolean[h][w];
        visited[startPoint.x][startPoint.y] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                // h x w 범위 밖 || 갔던 적 있음 || 벽 -> pass
                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '#') continue;

                // nx, ny 위치에 불이 붙은 적이 없거나, 내가 오고 나서 불이 붙은 경우 -> 갈 수 있는 위치
                if (movePath[nx][ny] != 0 && (firePath[nx][ny] == 0 || movePath[nx][ny] < firePath[nx][ny])) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }

        }
    }

    // 상근이의 대피 경로 체크(불 신경 안쓰고)
    static void moveBfs(Point startPoint) {
        Queue<Point> move = new ArrayDeque<>();
        movePath = new int[h][w];
        movePath[startPoint.x][startPoint.y] = 1;
        move.add(startPoint);
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!move.isEmpty()) {
            Point p = move.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (canGo(nx, ny)) {
                    movePath[nx][ny] = movePath[p.x][p.y] + 1;
                    move.add(new Point(nx, ny));
                }
            }
        }
    }
    

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) return false;

        // 이미 방문했거나 벽이거나
        if (movePath[x][y] != 0 || map[x][y] == '#') return false;

        return true;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < h && 0 <= y && y < w;
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 불의 이동 경로 체크
    static void fireBfs() {
        Queue<Point> fire = new ArrayDeque<>();
        firePath = new int[h][w];

        for (Point point : startFireList) {
            fire.add(point);
            firePath[point.x][point.y] = 1;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!fire.isEmpty()) {
            Point firePoint = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = firePoint.x + dx[i];
                int ny = firePoint.y + dy[i];

                if (canFireGo(nx, ny)) {
                    firePath[nx][ny] = firePath[firePoint.x][firePoint.y] + 1;
                    fire.add(new Point(nx, ny));
                }
            }
        }
    }

    static boolean canFireGo(int x, int y) {
        if (!inRange(x, y)) return false;

        // 이미 방문했거나 벽이거나
        if (firePath[x][y] != 0 || map[x][y] == '#') return false;

        return true;
    }
}