
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 18352 : 특정 거리의 도시 찾기
public class Main {

  static class Node {
    int n;
    int depth;

    Node(int n, int depth) {
      this.n = n;
      this.depth = depth;
    }
  }

  static int n;
  static int m;
  static int k;
  static int x;
  static List<Integer>[] list;
  static List<Integer> answer = new ArrayList<>();
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    // 초기화
    list = new ArrayList[n+1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    visited = new boolean[n+1];

    // 인접리스트 채우기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
    }

    bfs();

    if (answer.isEmpty()) {
      System.out.println(-1);
      return;
    }

    answer.sort(Comparator.comparingInt(o->o));
    for (int n : answer) {
      System.out.println(n);
    }
  }


  static void bfs() {
    Queue<Node> q = new ArrayDeque<>();
    q.add(new Node(x, 0));
    visited[x] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.depth == k) {
        answer.add(cur.n);
      }

      for (int next : list[cur.n]) {
        if (!visited[next]) {
          q.add(new Node(next, cur.depth + 1));
          visited[next] = true;
        }
      }
    }
  }
}
