import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[m+1];
        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - arr[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j-arr[i]] + 1);
                }
            }
        }
        System.out.println(dp[m] < 0 ? "No" : "Yes");

    }
}
