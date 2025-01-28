import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] type = new int[n];
        int[] dp = new int[m+1];
        
        // dp init
        for (int i = 0; i <= m; i++) dp[i] = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            type[i] = Integer.parseInt(st.nextToken());
            dp[type[i]] = 1;
        }

        
        dp[0] = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + type[j] <= m) {
                    dp[i + type[j]] = Math.min(dp[i + type[j]], dp[i] + 1);
                }
            }
        }

        System.out.println(dp[m]);
    }
}
