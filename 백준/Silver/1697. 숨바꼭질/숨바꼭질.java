import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n;
    static int k;
    static int[] dx = new int[]{1, -1, 2};
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        k = Integer.parseInt(inputs[1]);
        visited = new boolean[200001];
        if (n == k) {
            System.out.println(0);
            return;
        }
        bfs(n);
        System.out.println(ans);
    }

    static void bfs(int start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 3; i++) {
                int nextPoint;
                if (i == 2) nextPoint = node.point * dx[i];
                else nextPoint = node.point + dx[i];

                if (nextPoint > 200000 || nextPoint < 0) {
                    continue;
                }

                if (!visited[nextPoint])  {
                    visited[nextPoint] = true;
                    if (nextPoint == k) {
                        ans = Math.min(ans, node.depth + 1);
                        return;
                    }
                    q.add(new Node(nextPoint, node.depth + 1));
                }
            }
        }
    }

    static class Node {
        int point;
        int depth;

        Node(int point, int depth) {
            this.point = point;
            this.depth = depth;
        }
    }
}
