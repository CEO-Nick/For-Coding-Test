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

        // @Override
        // public boolean equals(Object o) {
        //     if (this == o) {
        //         return true;
        //     }
        //     if (o == null || getClass() != o.getClass()) {
        //         return false;
        //     }
        //     Point point = (Point) o;
        //     return x == point.x && y == point.y;
        // }

        // @Override
        // public int hashCode() {
        //     return Objects.hash(x, y);
        // }

        // @Override
        // public String toString() {
        //     return "Point{" +
        //         "x=" + x +
        //         ", y=" + y +
        //         ", order=" + order +
        //         '}';
        // }
        
    }

    static Set<Point> choseWalls;
    static boolean[] chose;
    static int ans = Integer.MAX_VALUE;

    static void choose(int idx, int count) {
        if (count == k) {
            int res = BFS();
            ans = Math.min(ans, res);
            // System.out.println(choseWalls);
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

    static int BFS() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);

        visited = new boolean[n][n];
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == end.x && cur.y == end.y) {
                return cur.order;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                
                if (canGo(nx, ny)) {
                    // 다음 좌표가 벽인 경우
                    if (grid[nx][ny] == 1) {
                        if (choseWalls.contains(new Point(nx, ny, 0))) {
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny, cur.order + 1));
                        }
                        // 현재 찬스가 0개 이하라면 더이상 진행할 수 없음
                    } else {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, cur.order + 1));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        if (visited[nx][ny]) return false;

        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }


    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    static int n;
    static int k;
    static int[][] grid;
    static boolean[][] visited;
    static Point start;
    static Point end;
    static ArrayList<Point> walls;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        // 0 : 이동 가능
        // 1 : 벽 
            
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

        choose(0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
