import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  static int[][] friends;
  static int[][] points;
  static boolean[] visited;
  static int n;
  static int[] maxDepth;

  static class Friend {

    int n;
    int d;

    Friend(int n, int d) {
      this.n = n;
      this.d = d;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    friends = new int[n + 1][n + 1];
    points = new int[n + 1][n + 1];
    maxDepth = new int[n + 1];

    int a = sc.nextInt(), b = sc.nextInt();

    while (a != -1 && b != -1) {
      friends[a][b] = 1;
      friends[b][a] = 1;

      a = sc.nextInt();
      b = sc.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      bfs(i);
    }

    int minVal = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      minVal = Math.min(minVal, maxDepth[i]);
    }

    StringBuilder sb1 = new StringBuilder();  // 회장 후보의 점수와 후보의 수를 출력할 sb
    StringBuilder sb2 = new StringBuilder();  // 회장 후보 오름차순으로 출력할 sb
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (maxDepth[i] == minVal) {
        count++;
        sb2.append(i).append(" ");
      }
    }

    sb1.append(minVal).append(" ").append(count);

    System.out.println(sb1);
    System.out.println(sb2);
  }

  static void bfs(int start) {
    Queue<Friend> q = new ArrayDeque<>();

    for (int i = 1; i <= n; i++) {
      if (i == start) {
        continue;
      }

      // 이미 친구 사이 몇 depth인지 알고 있는 경우
      if (points[start][i] != 0) {
        maxDepth[start] = Math.max(maxDepth[start], points[start][i]);
        continue;
      }

      q.add(new Friend(start, 0));
      visited = new boolean[n + 1];
      visited[start] = true;

      while (!q.isEmpty()) {
        Friend cur = q.poll();
        if (cur.n == i) {
          points[start][cur.n] = cur.d;
          points[cur.n][start] = cur.d;
        }
        for (int j = 1; j <= n; j++) {
          if (!visited[j] && friends[cur.n][j] != 0) {
            q.add(new Friend(j, cur.d + 1));
            visited[j] = true;
          }
        }
      }

      // 가장 먼 친구 관계가 그 사람의 회장 자격 값을 결정
      maxDepth[start] = Math.max(maxDepth[start], points[start][i]);
    }
  }


}
