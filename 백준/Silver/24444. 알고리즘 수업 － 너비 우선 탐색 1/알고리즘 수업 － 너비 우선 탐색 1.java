
import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int m;
  static int r;
  static List<Integer>[] graph;
  static int[] visited;
  static int order = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n+1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }
    visited = new int[n+1];

    int a, b;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 1; i <= n; i++) {
      graph[i].sort(Comparator.comparingInt(o -> o));
    }


    // 시작 정점에서 방문할 수 없는 경우
    if (graph[r].isEmpty()) {
      System.out.println(0);
      return;
    }

    bfs();
    
    for (int i = 1; i <= n; i++) {
      System.out.println(visited[i]);
    }
  }

  static void bfs() {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(r);
    visited[r] = order++;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int n : graph[cur]) {
        if (visited[n] == 0) {
          q.add(n);
          visited[n] = order++;
        }
      }
    }
  }
}
