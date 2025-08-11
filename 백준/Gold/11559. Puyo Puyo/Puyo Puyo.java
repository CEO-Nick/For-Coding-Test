import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /*
    다른 뿌요 나올 때까지 아래로 떨어짐
    같은 색 뿌요가 4개 이상 상하좌우로 연결 -> 연결된 뿌요들 한꺼번에 없어짐 = 1연쇄 시작
    없어지고 위에 다른 뿌요들 있으면 차례로 아래로 떨어짐
    또 4개 이상 같은 색 모이면 또 터짐 -> 1연쇄씩 늘어남
    여러 그룹 동시에 터지더라도 1연쇄임

    뿌요에서 상하좌우로 같은 색인지 확인 -> dfs로 찾아서 개수 카운트 & 임시 배열에 기록
    -> 개수 4개 이상이면 전체 필드 순회 끝나고 임시 배열에 기록된거 터뜨리고 grid에 반영하기
    -> 중력 작용 시키기
    -> 반복
    return: 필드 주어지면 몇 연속 연쇄 일어날지 계산
     */
    static char[][] grid;
    static int N = 12;
    static int M = 6;
    static int count;
    static char std;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new char[N][M];
        int answer = 0;

        String input;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = input.charAt(j);
            }
        }

        while (true) {
            visited = new boolean[N][M];
            boolean isBoom = false;
            ArrayList<int[]> boomList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] || grid[i][j] == '.') {
                        continue;
                    }

                    count = 0;
                    std = grid[i][j];
                    check(i, j);

                    // 터뜨릴 거 기록하기
                    if (count >= 4) {
                        isBoom = true;
                        boomList.add(new int[]{i, j});
                    }
                }
            }

            if (isBoom) {
                answer++;
                // 터뜨리기
                for (int[] boom : boomList) {
                    std = grid[boom[0]][boom[1]];
                    boom(boom[0], boom[1]);
                }
                // 중력 작용하기
                gravity();
            } else {
                break;
            }
        }
        System.out.println(answer);
    }

    static boolean[][] visited;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static void check(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inRange(nx, ny) || visited[nx][ny] || grid[nx][ny] != std) {
                continue;
            }

            check(nx, ny);
        }
    }

    static void boom(int x, int y) {
        grid[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inRange(nx, ny) || grid[nx][ny] != std) {
                continue;
            }

            boom(nx, ny);
        }
    }

    static void gravity() {
        char[][] tmp = new char[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(tmp[i], '.');
        }

        for (int j = 0; j < M; j++) {
            int idx = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (grid[i][j] != '.') {
                    tmp[idx--][j] = grid[i][j];
                }
            }
        }
        grid = tmp;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}
