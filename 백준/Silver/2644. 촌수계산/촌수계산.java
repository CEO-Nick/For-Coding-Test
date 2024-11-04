
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static class Relative {
    int n;
    int depth;

    Relative(int n, int depth) {
      this.n = n;
      this.depth = depth;
    }
  }

  static int n;
  static int x;
  static int y;
  static int m;
  static int[][] graph;
  static int[] visited;

  public static void main(String[] args) throws IOException {
    // 부모 - 자식 : 1
    // 나 - 아빠 형제 : 3

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    graph = new int[n+1][n+1];
    visited = new int[n+1];

    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a][b] = 1;
      graph[b][a] = 1;
    }

    bfs();
    if (visited[y] == 0) {
      System.out.println(-1);
      return;
    }

    System.out.println(visited[y]);
  }

  public static void bfs() {
    Queue<Relative> q = new ArrayDeque<>();
    q.add(new Relative(x, 0));
    visited[x] = 0;
    while (!q.isEmpty()) {
      Relative cur = q.poll();

      for (int i = 1; i <= n; i++) {
        // 방문한 적 없는 경우
        if (visited[i] == 0 && graph[cur.n][i] != 0) {
          q.add(new Relative(i, cur.depth+1));
          visited[i] = cur.depth+1;
        }
      }
    }
  }

}
