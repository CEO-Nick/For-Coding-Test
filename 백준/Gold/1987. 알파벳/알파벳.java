
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int r;
    public static int c;
    public static int[][] grid;
    public static boolean[] check;
    public static boolean[][] visited;
    public static int count = 0;
    public static int[] dxs = new int[]{1, 0, -1, 0};
    public static int[] dys = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        // 같은 알파벳 적힌 칸을 두 번 지날 수 없음
        // 최대 몇 칸 지날 수 있는지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        grid = new int[r][c];
        String input;
        for (int i = 0; i < r; i ++) {
            input = br.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = input.charAt(j) - 'A';
            }
        }

        check = new boolean[26];
        visited = new boolean[r][c];
        check[grid[0][0]] = true;
        count++;
        int ans = solution(0, 0);
        System.out.println(ans);
        br.close();
    }

    public static int solution(int i, int j) {
        int result = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dxs[k];
            int ny = j + dys[k];
            if (canGo(nx, ny)) {
                check[grid[nx][ny]] = true;
                result = Math.max(result, solution(nx, ny));
                check[grid[nx][ny]] = false;
            }
        }

        return result + 1;
    }

    static boolean canGo(int nx, int ny) {
        // RxC 범위 밖이면 -> false
        if (!inRange(nx, ny)) return false;

        // 이미 해당 알파벳 간 적 있거나 방문한적 있으면 -> false
        if (check[grid[nx][ny]]) return false;

        return true;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}
