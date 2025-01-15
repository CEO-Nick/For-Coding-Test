import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x;
        int y;
        int order;

        Point(int x, int y, int order) {
            this.x = x;
            this.y = y;
            this.order = order;
        }

        // set 자료구조를 위해 선언
        // 이걸 선언해야 Point p1 = new Point(1, 1, 0);     Point p2 = new Point(1, 1, -1); => Hash 자료구조에서 이 두 Point가 같다고 판단할 수 있다
        // 우리는 좌표만 판단할거니깐 order은 동등성 비교에서 제외

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    // x개의 벽들 중에서 k개 벽 선택
    static void choose(int idx, int count) {
        // k개 벽 선택되면 BFS 진행
        if (count == k) {
            int res = BFS();
            ans = Math.min(ans, res);
            return;
        }

        if (idx == walls.size()) {
            return;
        }

        for (int i = 0; i < walls.size(); i++) {
            if (chose[i]) continue;

            chose[i] = true;
            choseWalls.add(walls.get(i));
            choose(idx + 1, count + 1);
            choseWalls.remove(walls.get(i));
            chose[i] = false;
        }
    }

    // 시작 좌표에서부터 BFS 시작
    static int BFS() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);

        visited = new boolean[n][n];
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.equals(end)) {
                return cur.order;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                
                if (canGo(nx, ny)) {
                    // 다음 좌표가 벽인 경우
                    if (grid[nx][ny] == 1) {
                        // 선택된 벽이라면 계속 탐색
                        if (choseWalls.contains(new Point(nx, ny, 0))) {
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny, cur.order + 1));
                        }
                    } else {
                        // 벽 아니면 계속 탐색 진행
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, cur.order + 1));
                    }
                }
            }
        }

        // end 좌표에 도달하지 못한 경우
        return Integer.MAX_VALUE;
    }

    // 범위 안에 있고 방문한 적 없는지 판단
    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        if (visited[nx][ny]) return false;

        return true;
    }

    // n * n 범위 안에 있는지 판단
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }


    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    static int n;
    static int k;
    static int[][] grid;
    static boolean[][] visited; // BFS에서 사용될 방문 체크 배열
    static Point start;
    static Point end;

    static ArrayList<Point> walls;  // 벽 좌표 리스트
    static Set<Point> choseWalls;   // 선택된 k개의 벽 리스트
    static boolean[] chose;         // backtracking에서 선택 유무 확인을 위한 배열
    static int ans = Integer.MAX_VALUE; // 걸린 시간(답)

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        grid = new int[n][n];
        walls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) walls.add(new Point(i, j, 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        st = new StringTokenizer(br.readLine());
        end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        choseWalls = new HashSet<>();
        chose = new boolean[walls.size()];

        // k개의 벽 선택 후, BFS 진행
        choose(0, 0);

        // 한번도 값이 바뀐 적이 없다면 도달할 수 없는 경우임
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
