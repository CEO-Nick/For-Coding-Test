
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
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            list[a].add(b);
            indegree[b]++;  // a -> b 이니깐 b의 진입 차수 1 증가
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            check[now] = 1;
            sb.append(now).append(" ");
            for (int node : list[now]) {
                if (check[node] == 1) continue;
                indegree[node]--;
                if (indegree[node] == 0) queue.offer(node);
            }
        }
        System.out.println(sb);
    }
}
