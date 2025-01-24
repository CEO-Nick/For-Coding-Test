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

        // dp[i] << i번째 숫자의 최대 증가 부분 수열의 원소 수 
        // arr = 1, 6, 4, 3, 9, 3 
        // dp =  1, 2, 2, 2, 3, 2
        int[] dp = new int[n];
        
        // 모두 1로 초기화 : 각 좌표에서 부분 수열 시작할 때 최소한 자기 자신은 포함하니깐
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 현재 값보다 작은 경우에만 dp 갱신 (증가하는 부분 수열이어야 하니까)
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = INT_MIN;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
