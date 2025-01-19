import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[1010];
        dp[3] = 1;
        dp[2] = 1;
        dp[1] = 0;
        dp[0] = 0;
        
        for (int i = 4; i <= 1000; i++) {
            dp[i] = (dp[i-2] + dp[i-3]) % 10007;
        }

        System.out.println(dp[n]);
    }
}