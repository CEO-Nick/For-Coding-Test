import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cost = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i <= n; i++) {
            if (dp[i] == Integer.MIN_VALUE) continue;

            for (int j = 1; j <= n; j++) {
                if ((i + j) <= n) {
                    dp[i+j] = Math.max(dp[i+j], dp[i] + cost[j]);
                }
            }
        }

        System.out.println(dp[n]);

    }
}
