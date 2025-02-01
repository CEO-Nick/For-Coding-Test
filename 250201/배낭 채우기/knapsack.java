import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] w = new int[n];
        int[] v = new int[n];
        int[] dp = new int[m+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            if (w[i] <= m) dp[w[i]] = v[i];
        }

        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int wei = m; wei >= 0; wei--) {
                if (wei - w[i] >= 0) {
                    dp[wei] = Math.max(dp[wei - w[i]] + v[i], dp[wei]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
