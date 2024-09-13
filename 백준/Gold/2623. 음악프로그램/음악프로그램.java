
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <=n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        int[] check = new int[n + 1];

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            // a가 b보다 앞
            for (int j = 1; j < Integer.parseInt(inputs[0]); j++) {
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j + 1]);
                list[a].add(b);
                indegree[b]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            check[now] = 1;
            sb.append(now).append("\n");
            for (int node : list[now]) {
                if (check[node] == 1) continue;
                indegree[node]--;
                if (indegree[node] == 0) queue.offer(node);
            }
        }

        // 순서 정하는 것이 불가능한 경우 찾기
        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb);
    }
}
