import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;
        int time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static void BFS(Point start) {
        q = new ArrayDeque<>();
        q.add(start);
        visited = new boolean[n][n];
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxs[i], ny = cur.y + dys[i];
                
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    answer[nx][ny] = Math.min(answer[nx][ny], cur.time + 1);
                    q.add(new Point(nx, ny, cur.time + 1));
                }
            }
        } 
    } 

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }

    // n x n 범위 밖에 벗어나거나, 방문한 적이 있거나, 빈 칸인 경우 -> 계속 진행 X
    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;

        if (visited[nx][ny] || grid[nx][ny] == 0) return false;

        return true;
    }

    static void initAnswer() {
        answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void printAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int res = answer[i][j];
                // 값이 수정된 적 없는 경우
                if (answer[i][j] == Integer.MAX_VALUE) {
                    if (grid[i][j] == 0) res = -1;  // 빈칸인 경우
                    else res = -2;  // 귤인 경우 -> 끝까지 상하지 않은 경우
                }
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int n;
    static int k;
    static int[][] grid;    // 격자 정보
    static int[][] answer;  // 귤이 상한 시간을 저장할 배열
    static boolean[][] visited; // BFS 탐색 시, 사용할 방문 배열
    static ArrayList<Point> rotten; // 초기에 썩은 귤 좌표 리스트
    static Queue<Point> q;
    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        // 0 : 빈칸
        // 1 : 귤
        // 2 : 상한 귤
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        rotten = new ArrayList<>();
        initAnswer();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) {
                    rotten.add(new Point(i, j, 0));
                    answer[i][j] = 0;
                }
            }
        }


        for (Point r : rotten) BFS(r);
        
        printAnswer();
    }
}
