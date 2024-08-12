
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static boolean[] visited;
    public static int[] reliability;
    static List<Integer>[] canHacking;

    public static void main(String[] args) throws IOException {
        // a가 b를 신뢰 = b 해킹하면 a도 해킹 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        canHacking = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            canHacking[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            canHacking[a].add(b);
        }

        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        reliability = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, reliability[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (reliability[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : canHacking[node]) {
                if (visited[child]) continue;
                reliability[child]++;
                visited[child] = true;
                q.add(child);
            }
        }
    }
}
