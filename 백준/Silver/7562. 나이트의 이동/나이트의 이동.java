
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 7562 - 나이트의 이동
public class Main {

  static class Point {

    int x;
    int y;
    int depth;

    Point(int x, int y, int depth) {
      this.x = x;
      this.y = y;
      this.depth = depth;
    }
  }

  static int t;
  static int n;
  static int[][] grid;
  static int[][] visited;
    
  static int x1;
  static int y1;

  static int x2;
  static int y2;

  static int[] dxs = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] dys = new int[]{1, 2, 2, 1, -1, -2, -2, -1};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      grid = new int[n][n];
      visited = new int[n][n];

      st = new StringTokenizer(br.readLine());
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());

      int result = bfs();
      sb.append(result).append("\n");
    }

    System.out.println(sb);

  }

  static int bfs() {
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x1, y1, 0));
    visited[x1][y1] = 1;

    while (!q.isEmpty()) {
      Point cur = q.poll();

      if (cur.x == x2 && cur.y == y2) {
        return cur.depth;
      }
      for (int i = 0; i < dxs.length; i++) {
        int nx = cur.x + dxs[i];
        int ny = cur.y + dys[i];

        if (inRange(nx, ny) && visited[nx][ny] == 0) {
          q.add(new Point(nx, ny, cur.depth + 1));
          visited[nx][ny] = 1;
        }
      }
    }

    return 0;
  }

  static boolean inRange(int nx, int ny) {
    return 0 <= nx && nx < n && 0 <= ny && ny < n;
  }


}
