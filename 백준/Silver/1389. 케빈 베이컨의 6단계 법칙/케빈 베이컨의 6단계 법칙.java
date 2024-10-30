
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// 1389 : 케빈 베이컨의 6단계
public class Main {
  static int n;
  static int m;
  static int[][] graph;
  static boolean[] visited;
  static int[][] kb;
  static int[] ans;

  static class Person {

    int n;
    int depth;

    Person(int n, int depth) {
      this.n = n;
      this.depth = depth;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n+1][n+1];
    kb = new int[n+1][n+1];
    ans = new int[n+1];

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a][b] = 1;
      graph[b][a] = 1;
    }

    for (int i = 1; i <= n; i++) {
      bfs(i);
    }

    int min = Integer.MAX_VALUE;
    ans[0] = min;
    for (int n : ans) {
      min = Math.min(n, min);
    }
      
    for (int i = 1; i <=n; i++) {
      if (ans[i] == min) {
        System.out.println(i);
        return;
      }
    }

  }


  public static void bfs(int start) {
    Queue<Person> q = new ArrayDeque<>();

    for (int i = 1; i <= n; i++) {
      if (i == start) continue;
      if (kb[start][i] != 0) {
        ans[start] += kb[start][i];
        continue;
      }

      // 초기화
      visited = new boolean[n+1];
      q.add(new Person(start, 0));
      visited[start] = true;


      while (!q.isEmpty()) {
        Person cur = q.poll();
        if (cur.n == i) {
          kb[start][i] = cur.depth;
          kb[i][start] = cur.depth;
          q.clear();
          break;
        }
        for (int j = 1; j <= n; j++) {
          if (!visited[j] && graph[cur.n][j] != 0) {
            q.add(new Person(j, cur.depth + 1));
            visited[j] = true;
          }
        }
      }
      ans[start] += kb[start][i];
    }


  }
}
