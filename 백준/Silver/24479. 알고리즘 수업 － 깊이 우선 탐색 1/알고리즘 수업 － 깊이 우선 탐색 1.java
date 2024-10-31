
import java.io.*;
import java.util.*;

// 24479: 알고리즘 수업 - 깊이 우선 탐색 1
public class Main {
  static int n;
  static int m;
  static int r;
  static int depth = 1;
  static int[] visited;
  static List<Integer>[] graph;

  public static void main(String[] args) throws IOException {
    // dfs 노드 방문 순서 출력하기
    // 인접 정점은 오름차순으로 방문
    // 시작 정점에서 방문할 수 없는 경우 -> 0 출력

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    // 인접 리스트 초기화 : 인접 리스트인 이유는 n이 크기 때문에 n x n 2차원 배열 만들면 메모리 부족 예상
    graph = new ArrayList[n+1];
    for (int i = 1; i <=n; i++) {
      graph[i] = new ArrayList<>();
    }

    visited = new int[n+1];

    // 그래프 채우기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    // 인접 정점인 경우 오름차순 방문을 위해 정렬
    for (int i = 1; i <= n; i++) {
      graph[i].sort(Comparator.comparingInt(o -> o));
    }

    dfs(r);

    for (int i = 1; i <= n; i++) {
      System.out.println(visited[i]);
    }
  }

  static void dfs(int node) {
    visited[node] = depth++;
    for (int n : graph[node]) {
      if (visited[n] == 0) {
        dfs(n);
      }
    }
  }

}
