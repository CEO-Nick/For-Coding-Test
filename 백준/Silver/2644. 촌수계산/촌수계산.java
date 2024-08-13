
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] relation;
    static boolean[] visited;
    static int n;
    static int m;
    static int p1;
    static int p2;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        relation = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }

        // x 부모 | y 자식
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation[x].add(y);
            relation[y].add(x);
        }

        visited = new boolean[n + 1];
        dfs(p1, 0);
        System.out.println(answer);
        br.close();
    }

    static void dfs(int node, int count) {
        visited[node] = true;
        if (node == p2) {
            answer = count;
            return;
        }

        for (int i = 0; i < relation[node].size(); i++) {
            int next = relation[node].get(i);
            if (!visited[next]) {
                dfs(next, count + 1);
            }
        }
    }
}
