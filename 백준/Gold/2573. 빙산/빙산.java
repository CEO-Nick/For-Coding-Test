import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int n;
    public static int m;
    public static int[][] icebergs;
    static boolean allMelt;
    public static boolean[][] visited;
    public static int count = 0;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        // 둘러싸인 바다 수만큼 매년 감소
        // 최소 2개 이상으로 분리될 때까지
        // 빙산 다 녹을 때까지 분리 안되면 0 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        icebergs = new int[n][m];
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                icebergs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            visited = new boolean[n][m];
            // 1. 1년 지나면
            year++;
            // 2. 녹이고
            melt();
            // 3. 덩어리 개수 세고
            countArea();
            // 4-1. 덩어리 개수 판단
            if (count >= 2) {
                System.out.println(year);
                break;
            }
            // 4-2. 모두 다 녹은 경우
            if (allMelt) {
                System.out.println(0);
                break;
            }
        }
        br.close();
    }

    // 빙산 녹이기
    static void melt() {
        allMelt = true;
        int[][] newIcebergs = new int[n][m];
        // 빙산이 전부 0으로 채워져있다면 allMelt = true로 메서드가 끝남
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (icebergs[i][j] != 0) {
                    allMelt = false;
                    int height = icebergs[i][j] - countSea(i, j);
                    newIcebergs[i][j] = Math.max(height, 0);
                } else {
                    newIcebergs[i][j] = 0;
                }
            }
        }
        icebergs = newIcebergs;
    }

    // 현재 좌표 기준 주변 바다의 개수 리턴
    static int countSea(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) continue;

            if (icebergs[nx][ny] == 0) count++;
        }

        return count;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    // 빙산 덩어리 개수 세기
    static void countArea() {
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (icebergs[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        if (!inRange(nx, ny)) return false;
        if (visited[nx][ny] || icebergs[nx][ny] == 0) return false;

        return true;
    }

}
