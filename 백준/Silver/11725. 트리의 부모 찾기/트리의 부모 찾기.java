import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer>[] tree;
    public static boolean[] visited;
    public static int[] parents;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            String[] inputs = br.readLine().split(" ");
            int node1 = Integer.parseInt(inputs[0]);
            int node2 = Integer.parseInt(inputs[1]);

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        visited = new boolean[n+1];
        parents = new int[n+1];

        // 1번 노드부터 순회하면서 각 노드의 부모 노드 저장
        traversal(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }

    }

    public static void traversal(int node) {
        visited[node] = true;
        for (int child : tree[node]) {
            if (visited[child]) continue;
            parents[child] = node;
            visited[child] = true;
            traversal(child);
        }
    }
}
