import java.util.*;
import java.io.*;

public class Main {

    static int max = Integer.MIN_VALUE;

    static void recur(int lastIdx, int count) {
        if (count == m) {
            int res = calculate();
            max = Math.max(max, res);
            return;
        }

        if (lastIdx == n) return;

        for (int i = lastIdx; i < n; i++) {
            list.add(arr[i]);
            recur(i+1, count+1);
            list.remove(list.size()-1);
        }
    }

    static int calculate() {
        int res = list.get(0);
        for (int i = 1; i < m; i++) {
            res ^= list.get(i);
        }
        return res;
    }

    static int n;
    static int m;
    static int[] arr;
    static ArrayList<Integer> list;


    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        
        recur(0, 0);
        System.out.println(max);
    }
}