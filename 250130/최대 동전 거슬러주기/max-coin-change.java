import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[10001];

        // dp init
        for (int i = 0; i <= 10000; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            coin[i] = input;
            dp[input] = 1;
        }

        for (int i = 1; i <= m; i++) {
            // 금액 i를 만들 수 없는 경우 -> pass
            if (dp[i] == Integer.MIN_VALUE) continue;
            
            for (int j = 0; j < n; j++) {
                if (i + coin[j] <= m) {
                    dp[i + coin[j]] = Math.max(dp[i + coin[j]], dp[i] + 1);
                }
            }
        }
        
        System.out.println(dp[m] == Integer.MIN_VALUE ? -1 : dp[m]);

    }
}
