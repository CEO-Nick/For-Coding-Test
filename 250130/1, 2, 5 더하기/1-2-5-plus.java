import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] type = new int[] {1, 2, 5};
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[5] = 1;

        // 점화식 << dp[i] += ( dp[i-1] + dp[i-2] + dp[i-5] );
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i - type[j] >= 0) {
                    dp[i] += dp[i-type[j]];
                }
            }
        }

        System.out.println(dp[n]);
    }
}
