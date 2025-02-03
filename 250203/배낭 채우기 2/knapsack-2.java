import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[m+1];
        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i <= m; i++) {
            if (dp[i] == Integer.MIN_VALUE) continue;

            for (int j = 0; j < n; j++) {
                if ((i + weight[j]) <= m) {
                    dp[i+weight[j]] = Math.max(dp[i+weight[j]], dp[i] + value[j]);
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
