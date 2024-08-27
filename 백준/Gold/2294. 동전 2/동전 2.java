
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] money;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k+1];
        for (int i = 1; i <= k ; i++) {
            dp[i] = 100001;
        }

        money = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            if (money[i] <= k) {
                dp[money[i]] = 1;
            }
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i + money[j] <= k) {
                    dp[i + money[j]] = Math.min(dp[i + money[j]], dp[i] + 1);
                }
            }
        }

        if (dp[k] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
