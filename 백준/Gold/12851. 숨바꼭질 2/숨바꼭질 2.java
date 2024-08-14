
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n;
    static int k;
    static int[] count;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);

        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        visited = new int[100001];
        count = new int[100001];

        bfs(n);
        System.out.println(visited[k] - 1);
        System.out.println(count[k]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = 1;
        count[start] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            int[] next = new int[] {node + 1, node - 1, 2 * node};
            for (int i = 0; i < 3; i++) {
                int nextPoint = next[i];
                if (!inRange(nextPoint)) continue;

                if (visited[nextPoint] == 0)  {
                    visited[nextPoint] = visited[node] + 1;
                    count[nextPoint] = count[node];
                    q.add(nextPoint);
                } else if (visited[nextPoint] == visited[node] + 1) {
                    count[nextPoint] += count[node];
                }
            }
        }
    }

    static boolean inRange(int point) {
        return 0 <= point && point <= 100000;
    }
}
