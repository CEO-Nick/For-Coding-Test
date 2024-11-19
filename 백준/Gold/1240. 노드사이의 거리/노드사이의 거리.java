
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;
  static int[][] graph;
  static boolean[] visited;
  static int a;
  static int b;
  static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n+1][n+1];

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int val = Integer.parseInt(st.nextToken());
      graph[a][b] = val;
      graph[b][a] = val;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      visited = new boolean[n+1];
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      visited[a] = true;
      dfs(a, 0);
      sb.append(ans).append("\n");
    }

    System.out.println(sb);
  }

  static void dfs(int node, int distance) {
    if (node == b) {
      ans = distance;
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!visited[i] && graph[node][i] != 0) {
        visited[i] = true;
        dfs(i, distance + graph[node][i]);
      }
    }

  }

}
