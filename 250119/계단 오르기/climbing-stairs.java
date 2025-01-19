import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] dp = new long[1010];
        dp[3] = 1L;
        dp[2] = 1L;
        
        for (int i = 4; i <= 1000; i++) {
            dp[i] = (dp[i-2] + dp[i-3]);
        }

        System.out.println(dp[n] % 10007);
    }
}