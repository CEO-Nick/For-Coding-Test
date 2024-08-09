
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int n;
    static int m;
    static int v;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.comparingInt(o -> o));
        }


        visited = new boolean[n+1];
        dfs(v);
        bw.write("\n");

        visited = new boolean[n+1];
        bfs(v);

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node) throws IOException {
        visited[node] = true;
        bw.write(node + " ");

        for (int i = 0; i < graph[node].size(); i++) {
            int child = graph[node].get(i);
            if (!visited[child]) dfs(child);
        }
    }


    static void bfs(int node) throws IOException {
        List<Integer> queue = new ArrayList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int v = queue.remove(0);
            bw.write(v + " ");

            for (int i = 0; i < graph[v].size(); i++) {
                int child = graph[v].get(i);
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

    }
}
