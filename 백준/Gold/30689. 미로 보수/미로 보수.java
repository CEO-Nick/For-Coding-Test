
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;

  static int[][] mazes;
  static int[][] costs;
  static boolean[][] visited;

  // dfs 횟수를 줄이기 위해 순환경로, 탈출경로 저장
  static boolean[][] circled;
  static boolean[][] passed;

  static int[] dxs = new int[]{1, 0, -1, 0};
  static int[] dys = new int[]{0, 1, 0, -1};

  static int ans = 0;
  static int minCost;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    mazes = new int[n][m];
    String input;
    for (int i = 0; i < n; i++) {
      input = br.readLine();
      for (int j = 0; j < m; j++) {
        char direction = input.charAt(j);
        int idx = 0;
        switch (direction) {
          case 'D':
            idx = 0;
            break;
          case 'R':
            idx = 1;
            break;
          case 'U':
            idx = 2;
            break;
          case 'L':
            idx = 3;
            break;
        }
        mazes[i][j] = idx;
      }
    }

    costs = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        costs[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[n][m];
    passed = new boolean[n][m];


    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 순환고리가 아니고 탈출 경로도 아닌 경우에만 dfs 진행
        if (!passed[i][j]) {
          dfs(i, j);
        }
      }
    }

    System.out.println(ans);
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;
    int nx = x + dxs[mazes[x][y]], ny = y + dys[mazes[x][y]];

    // 탈출 성공 -> dfs 탐색 종료
    if (!inRange(nx, ny)) {
      passed[x][y] = true;
      return;
    }

    if (passed[nx][ny]) {
      passed[x][y] = true;
      return;
    }

    // 순환 고리 발견
    else if (visited[nx][ny]) {
      int min = costs[x][y];  // 현재 위치부터 시작
      int cx = nx, cy = ny;

      // 순환 고리를 따라가면서 최소 비용 찾기
      while (true) {
        min = Math.min(min, costs[cx][cy]);
        int nextX = cx + dxs[mazes[cx][cy]];
        int nextY = cy + dys[mazes[cx][cy]];

        if (nextX == nx && nextY == ny) break;
        cx = nextX;
        cy = nextY;
      }
      ans += min;
      passed[x][y] = true;
    }
    else dfs(nx, ny);

    passed[x][y] = true;
  }

  static boolean inRange(int nx, int ny) {
    return 0 <= nx && nx < n && 0 <= ny && ny < m;
  }

}
