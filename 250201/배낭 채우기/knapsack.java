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
            dp[w[i]] = v[i];
        }

        for (int i = 0; i < n; i++) {
            int curW = w[i];
            int curV = v[i];

            for (int j = 0; j < i; j++) {
                if (curW + w[j] <= m) {
                    dp[curW + w[j]] = Math.max(dp[curW + w[j]], curV + v[j]); 
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
