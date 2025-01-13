import java.util.*;
import java.io.*;

public class Main {

  static int[] dxs = new int[] {1, 0, -1, 0};
  static int[] dys = new int[] {0, 1, 0, -1};

  static class Point {
    int x;
    int y;
    int value;

    Point(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }

  static int BFS(int x, int y) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y, grid[x][y]));

    if (curK > 1) {
        copyOrigin();
    } else {
        curVisited = new boolean[n][n];
    }
    curVisited[x][y] = true;
    int count = 1;

    while (!q.isEmpty()) {
      Point cur = q.poll();
      // System.out.println("cur.x: " + cur.x + "\tcur.y: " + cur.y + "\tcur.value: " + cur.value);
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dxs[i], ny = cur.y + dys[i];

        if (!inRange(nx, ny)) continue;
        if (curVisited[nx][ny]) continue;

        int diff = Math.abs(cur.value - grid[nx][ny]);
        // System.out.println("diff: " + diff);
        if (u <= diff && diff <= d) {
          // System.out.println("nx: " + nx + "\tny: " + ny);
          curVisited[nx][ny] = true;
          q.add(new Point(nx, ny, grid[nx][ny]));
          count++;
        }
      }
    }

    return count;
  }

  static boolean inRange(int nx, int ny) {
    return 0 <= nx && nx < n && 0 <= ny && ny < n;
  }

  static void copyCur() {
    for (int i = 0; i < n; i++) {
        visited[i] = curVisited[i].clone();
    }
  }

    static void copyOrigin() {
        for (int i = 0; i < n; i++) {
            curVisited[i] = visited[i].clone();
        }
    }
  static void print() {
    for (int i = 0; i < n; i++) {
      System.out.println(Arrays.toString(visited[i]));
    }
    System.out.println();
  }

  static int n;
  static int K;
  static int u;
  static int d;
  static int[][] grid;
  static boolean[][] visited;
  static boolean[][] curVisited;
  static int curK;

  public static void main(String[] args) throws IOException {
    // Please write your code here.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    grid = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }


    int answer = 0;
    for (int k = 1; k <= K; k++) {
        curK = k;
        int maxCount = Integer.MIN_VALUE;
        // System.out.println("k : " + k);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int res = BFS(i, j);
                    // System.out.println("i: " + i + "\tj: " + j + "\tres: " + res);
                    if (res > maxCount) {
                        copyCur();
                        maxCount = res;
                    }
                }
            }
        }
        answer += maxCount;
        // print();
    }
    
    System.out.println(answer);
  }
}
