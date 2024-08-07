
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<Integer>[] tree;
    public static List<Integer>[] inputs;
    public static boolean[] check;
    public static int count;
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(
            st.nextToken()), q = Integer.parseInt(st.nextToken());

        inputs = new ArrayList[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            inputs[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]), node2 = Integer.parseInt(input[1]);
            inputs[node1].add(node2);
            inputs[node2].add(node1);
        }

        check = new boolean[n + 1];
        memo = new int[n+1];
        makeTree(r);
        
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int u = Integer.parseInt(br.readLine());
            sb.append(memo[u]).append("\n");
        }
        System.out.println(sb);
    }

    private static int makeTree(int node) {
        check[node] = true;
        if (inputs[node].isEmpty()) {
            memo[node] = 1;
            return 1;
        }
        int count = 0;
        for (int i = 0; i < inputs[node].size(); i++) {
            Integer child = inputs[node].get(i);
            if (!check[child]) {
                tree[node].add(child);
                count += makeTree(child);
            }
        }
        memo[node] = count + 1;
        return memo[node];
    }

}
