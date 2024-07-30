
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static List<Integer>[] tree;
    public static boolean[] check;
    public static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int superior = Integer.parseInt(input[i]);
            if (superior == -1) {
                continue;
            }
            tree[superior].add(i+1);
        }

        check = new boolean[n + 1];
        count = new int[n+1];

        HashMap<Integer, Integer> inputs = new HashMap<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            if (inputs.containsKey(i)) {
                inputs.put(i, inputs.get(i) + w);
            } else {
                inputs.put(i, w);
            }
        }
        for( Map.Entry<Integer, Integer> entry : inputs.entrySet() ){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            check = new boolean[n + 1];
            praise(key, value);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(count[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void praise(int node, int amount) {
        check[node] = true;
        count[node] += amount;

        for (int i = 0; i < tree[node].size(); i++) {
            Integer child = tree[node].get(i);
            if (!check[child]) {
                praise(child, amount);
            }
        }
    }
}
