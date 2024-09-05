
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());    //지폐 금액
        int k = Integer.parseInt(br.readLine());    //동전 종류 개수

        // dp[k][t] = k번째 동전까지 사용했을 때 t원을 교환하는 방법의 수
        dp = new int[k + 1][t + 1];
        dp[0][0] = 1;

        StringTokenizer st;
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken()); //단위
            int count = Integer.parseInt(st.nextToken()); //개수

            for (int val = 0; val <= t; val++) {
                for (int cnt = 0; cnt <= count; cnt++) {
                    int nextValue = val + price * cnt;
                    if (nextValue > t) break;
                    dp[i][nextValue] += dp[i - 1][val];
                }
            }
        }

        System.out.println(Math.max(dp[k][t], 0));

    }
}
