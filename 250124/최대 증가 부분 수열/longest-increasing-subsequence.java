import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int[] arr;
    static int INT_MIN = -100;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }    

        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = INT_MIN;
        }
        dp[0] = 1;

        int ans = INT_MIN;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        System.out.println(ans);
    }
}
