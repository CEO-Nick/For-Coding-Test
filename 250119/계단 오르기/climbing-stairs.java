import java.util.*;

public class Main {

    static int climb(int x) {
        if (dp[x] != 0) return dp[x];
        if (x == 2 || x == 3) return 1;
        if (x < 2) return 0;
        dp[x] = climb(x-2) + climb(x-3);
        return dp[x];
    }

    static int[] dp;
    static int n;

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        // dp[5] = dp[3] + dp[2]
        // dp[3] = 1
        // dp[2] = 1
        // dp[1] = 0
        // dp[0] = 0
        n = sc.nextInt();
        dp = new int[1010];
        dp[3] = 1;
        dp[2] = 1;
        dp[1] = 0;
        dp[0] = 0;
        for (int i = 4; i <= 1000; i++) {
            dp[i] = (dp[i-2] + dp[i-3]) % 10007;
        }


        // int res = climb(n);
        // for (int i = 0; i <= n; i++) {
        //     System.out.println(i + ": " + dp[i]);
        // }
        System.out.println(dp[n]);
    }
}