
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;
  static int h;

  static int[][][] boxes;
  static boolean[][][] visited;
  static boolean[][][] alreadyRipe;

  static int[] dxs = new int[] {1, 0, -1, 0, 0, 0};
  static int[] dys = new int[] {0, 1, 0, -1, 0, 0};
  static int[] dzs = new int[] {0, 0, 0, 0, 1, -1};

  static int maxDay = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    boxes = new int[h][n][m];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < m; k++) {
          boxes[i][j][k] = Integer.parseInt(st.nextToken());
        }
      }
    }

    visited = new boolean[h][n][m];

    bfs();

    // 익지 않은 토마토가 있는 경우 -> -1 출력
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (!visited[i][j][k] && boxes[i][j][k] == 0) {
            System.out.println(-1);
            return;
          }
        }
      }
    }

    System.out.println(maxDay);
  }

  static class Point{
    int x, y, z;
    int day;

    Point(int x, int y, int z, int day) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.day = day;
    }
  }

  public static void bfs() {
    Queue<Point> q = new ArrayDeque<>();

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (boxes[i][j][k] == 1) {
            q.add(new Point(j, k, i, 0));
            visited[i][j][k] = true;
          }
        }
      }
    }
    while (!q.isEmpty()) {
      Point cur = q.poll();
      maxDay = Math.max(maxDay, cur.day);

      for (int idx = 0; idx < 6; idx++) {
        int nx = cur.x + dxs[idx], ny = cur.y + dys[idx], nz = cur.z + dzs[idx];
        if (inRange(nx, ny, nz) && !visited[nz][nx][ny] && boxes[nz][nx][ny] == 0) {
          q.add(new Point(nx, ny, nz, cur.day + 1));
          visited[nz][nx][ny] = true;
        }
      }
    }
  }

  public static boolean inRange(int nx, int ny, int nz) {
    return 0 <= nz && nz < h && 0 <= nx && nx < n && 0 <= ny && ny < m;
  }


}
