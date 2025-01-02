import java.util.*;
import java.io.*;

public class Main {

    // 폭탄 위치를 저장할 클래스
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 2번 타입 폭탄용 dx, dy
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    // 3번 타입 폭탄용 dx, dy
    static int[] dxs2 = new int[] {1, -1, -1, 1};
    static int[] dys2 = new int[] {1, 1, -1, -1};

    // 폭탄을 터뜨리거나(bomb = 1) 복원하는(bomb = -1) 메서드
    static void change(int method, int x, int y, int bomb) {
        bombed[x][y] += bomb;
        switch(method) {
            // 1번 폭탄
            case 0:
                for (int i = x-2; i <= x+2; i++) {
                    if (inRange(i, y)) bombed[i][y] += bomb;
                }
                break;

            // 2번 폭탄
            case 1:
                for (int i = 0; i < 4; i++) {
                    int nx = x + dxs[i];
                    int ny = y + dys[i];
                    if (inRange(nx, ny)) {
                        bombed[nx][ny] += bomb;
                    }
                }
                break;

            // 3번 폭탄
            case 2:
                for (int i = 0; i < 4; i++) {
                    int nx = x + dxs2[i];
                    int ny = y + dys2[i];
                    if (inRange(nx, ny)) {
                        bombed[nx][ny] += bomb;
                    }
                }
                break;
        }
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }

    static void recur(int cnt) {
        if (cnt == bombNum) {
            int res = count();
            max = Math.max(max, res);
            return;
        }

        Point cur = bombs.get(cnt);
        for (int i = 0; i < 3; i++) {
            change(i, cur.x, cur.y, 1);
            recur(cnt+1);
            change(i, cur.x, cur.y, -1);
        }
    }

    static int count() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombed[i][j] > 0) sum++;
            }
        }
        return sum;
    }

    static ArrayList<Point> bombs;
    static int n;
    static int[][] grid;
    static int[][] bombed;
    static int bombNum;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        grid = new int[n][n];
        bombed = new int[n][n];
        bombs = new ArrayList<>();
        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                grid[i][j] = input;
                if (input == 1) bombs.add(new Point(i, j));
            }
        }
        // 폭탄 개수
        bombNum = bombs.size();

        recur(0);
        System.out.println(max);
    }
}