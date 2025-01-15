import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x;
        int y;
        int chance;    
        int dist;

        Point(int x, int y, int chance, int dist) {
            this.x = x;
            this.y = y;
            this.chance = chance;
            this.dist = dist;
        }
    }

    static void BFS() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);

        visited = new boolean[n][n];
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == end.x && cur.y == end.y) {
                System.out.println(cur.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                
                if (canGo(nx, ny)) {
                    // 다음 좌표가 벽인 경우
                    if (grid[nx][ny] == 1) {
                        if (cur.chance > 0) {
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny, cur.chance - 1, cur.dist + 1));
                        }
                        // 현재 찬스가 0개 이하라면 더이상 진행할 수 없음
                    } else {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, cur.chance, cur.dist + 1));
                    }
                }
            }
        }

        System.out.println(-1);
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

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        // 0 : 이동 가능
        // 1 : 벽 
            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, k, 0);

        st = new StringTokenizer(br.readLine());
        end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, 0);

        BFS();

    }
}
