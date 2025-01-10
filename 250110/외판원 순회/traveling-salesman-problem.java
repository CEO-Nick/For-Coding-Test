import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> order;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void makeOrder(int idx) {
        if (order.size() == n-1) {
            min = Math.min(min, calc());
            return;
        }

        for (int i = 1; i < n; i++) {
            if (visited[i]) continue;
            if (cost[idx][i] == 0) continue;

            visited[i] = true;
            order.add(i);

            makeOrder(i);

            visited[i] = false;
            order.remove(order.size()-1);
        }
    }

    static int calc() {
        if (cost[0][order.get(0)] == 0 || cost[order.get(order.size()-1)][0] == 0) return Integer.MAX_VALUE;
        int sum = cost[0][order.get(0)];
        for (int i = 0; i < order.size() - 1; i++) {
            int c = cost[order.get(i)][order.get(i+1)];
            sum += c;
        }
        sum += cost[order.get(order.size()-1)][0];
        return sum;
    }

    static int n;
    static int[][] cost;

    
    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new ArrayList<>();
        visited = new boolean[n];

        makeOrder(0);
        System.out.println(min);
    }
}