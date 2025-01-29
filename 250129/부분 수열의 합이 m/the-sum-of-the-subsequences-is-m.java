import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[] arr;

    public void choose(int idx, int sum) {
        if (sum == m) {

        }
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[m+1];
        
        for(int i = 1;i<=m;i++){
            dp[i] = 100000;
        }

        for(int i = 0;i<n;i++){
            for(int j = m;j>=1;j--){
                if(j - arr[i] >= 0){
                    dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
                }
            }
        }

        if(dp[m] == 100000) System.out.println(-1);
        else System.out.println(dp[m]);

    }
}
