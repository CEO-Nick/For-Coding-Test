import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            // 직전 사각형에 2*1 사각형 1개붙이기 + 전전 사각형에 1*2 사각형 2개 붙이기 or 2x2 사각형 1개 붙이기 
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}