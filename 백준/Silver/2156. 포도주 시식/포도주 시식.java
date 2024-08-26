import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] amount;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        amount = new int[n+1];
        int[][] dp = new int[3][n+1];
        for (int i = 1; i <= n; i++) amount[i] = Integer.parseInt(br.readLine());
        dp[0][1] = 0;
        dp[1][1] = amount[1];
        dp[2][1] = amount[1];

        for (int i = 2; i <= n ; i++) {
            dp[0][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]);
            dp[1][i] = dp[0][i-1] + amount[i];
            dp[2][i] = dp[1][i-1] + amount[i];
        }

        System.out.println(Math.max(Math.max(dp[0][n], dp[1][n]), dp[2][n]));
        
    }
}
