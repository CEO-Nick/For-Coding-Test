
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] delay;
    static int[] indegree;
    static int[] check;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        // dp + 위상정렬
        // dp[next] = max(dp[now]) + time[i]
            // dp[now] : now 까지의 건물이 완성되는데 걸리는 시간
            // time[i] = i번째 건물이 완성되는데 걸리는 시간
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            delay = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] order = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                order[i] = new ArrayList<>();
            }

            indegree = new int[n+1];
            check = new int[n+1];
            dp = new int[n+1];

            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                order[x].add(y);
                indegree[y]++;
            }

            int w = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    dp[i] = delay[i];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i = 0; i < order[cur].size(); i++) {
                    int next = order[cur].get(i);
                    indegree[next]--;
                    dp[next] = Math.max(dp[next], dp[cur] + delay[next]);
                    if (indegree[next] == 0) q.offer(next);
                }
            }
            sb.append(dp[w]).append("\n");
        }
        System.out.println(sb);
    }
}
