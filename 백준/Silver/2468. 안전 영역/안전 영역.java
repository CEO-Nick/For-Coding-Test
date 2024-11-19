import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[][] graph;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());

    graph = new int[n][n];
    int maxH = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        maxH = Math.max(maxH, graph[i][j]);
      }
    }

    int ans = Integer.MIN_VALUE;

    for(int i = 0; i <= maxH; i++) {
      visited = new boolean[n][n];
      int count = 0;
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (!visited[j][k] && graph[j][k] > i) {
            count++;
            dfs(j, k, i);
          }
        }
      }
      ans = Math.max(ans, count);
    }

    System.out.println(ans);
  }

  static int[] dxs = new int[]{1, 0 , -1, 0};
  static int[] dys = new int[]{0, 1 , 0, -1};

  static void dfs(int x, int y, int h) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dxs[i], ny = y + dys[i];
      if (canGo(nx, ny, h)) {
        dfs(nx, ny, h);
      }
    }
  }

  static boolean canGo(int nx, int ny, int h) {
    // n x n 범위 밖이거나 방문한 적 있거나 높이가 h 이하면 못감
    if (!inRange(nx, ny)) return false;
    if (visited[nx][ny] || graph[nx][ny] <= h) return false;

    return true;
  }

  static boolean inRange(int nx, int ny) {
    return 0 <= nx && nx < n && 0 <= ny && ny < n;
  }

}
