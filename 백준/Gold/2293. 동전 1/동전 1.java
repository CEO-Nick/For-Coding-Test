
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] money;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        money = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + money[i] <= k; j++) {
                dp[j + money[i]] += dp[j];
            }
        }

        System.out.println(dp[k]);

    }
}
