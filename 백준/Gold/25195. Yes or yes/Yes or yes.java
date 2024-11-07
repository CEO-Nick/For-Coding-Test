
import java.io.*;
import java.util.*;

// 25195 : Yes or yes
public class Main {

  static int n;
  static int m;
  static int s;

  static List<Integer>[] list;
  static boolean[] visited;

  static Map<Integer, Boolean> fan;

  static boolean met = true;

  public static void main(String[] args) throws IOException {
    // 무조건 만남 -> Yes
    // 못 만나는 길이 존재 -> yes
    // 즉, 안만나고 여행이 끝나는 경우가 있으면 바로 yes 출력하고 탐색 종료
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 인접 리스트 초기화
    list = new ArrayList[n+1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    // 방문 여부 배열 초기화
    visited = new boolean[n+1];

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list[u].add(v);
    }

    // 각 노드에 팬클럽 유무 hashmap에 저장
    s = Integer.parseInt(br.readLine());
    fan = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    while (s-- > 0) {
      fan.put(Integer.parseInt(st.nextToken()), true);
    }

    for (int i = 1; i <= n; i++) {
      if (!fan.containsKey(i)) {
        fan.put(i, false);
      }
    }

    dfs(1);

    // met이 false로 바뀐 적이 없다 -> 팬클럽이 없는 경로가 없다는 의미
    if (met) {
      System.out.println("Yes");
    } else {
      System.out.println("yes");
    }
  }

  static void dfs(int node) {
    visited[node] = true;

    // 현재 노드에 팬클럽이 있다면 해당 경로는 더이상 탐색할 필요가 없음
    if (fan.get(node)) return;

    // 리프노드 -> 팬클럽 없는 경로가 있다는 의미
    if (list[node].isEmpty()) {
      met = false;
    }

    for (int next : list[node]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

}
