
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 4 -> 2, 3 -> 1,
        // 가능하면 쉬운 문제부터 풀기 (숫자가 작을수록 쉬움)
        // 3 -> 1 -> 4 -> 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] check = new int[n + 1]; // 풀었는지 체크
        int[] indegree = new int[n + 1]; // 선수문제 있는지 기록 (0: 선수문제 없음, 1: 선수문제 있음)

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            indegree[b]++;
        }

        // 조건 3을 만족하기 위해 우선순위 큐 사용 : 뭘 먼저 풀어도 상관없는 경우 pq에 offer되는데, 그 때 작은값을 먼저 풀기 위해 사용
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            check[now] = 1;
            sb.append(now).append(" ");
            for (int v : list[now]) {
                if (check[v] == 1) continue;
                indegree[v]--;
                if (indegree[v] == 0) pq.offer(v);
            }
        }
        
        System.out.println(sb);
    }
}
