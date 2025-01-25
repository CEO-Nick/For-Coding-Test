import java.util.*;
import java.io.*;

public class Main {

    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int[] dp;
    static int n;
    static ArrayList<Integer>[] list = new ArrayList[1001];
    public static void main(String[] args) throws IOException {
        // 겹치지 않게 가장 많은 수의 선분을 고르기        
        // 끝점 공유도 겹친 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < 1001; i++) {
            list[i] = new ArrayList<>();
        }

        int maxEnd = Integer.MIN_VALUE;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
            maxEnd = Math.max(maxEnd, b);
        }

        // for (int i = 0; i <= 10; i++) {
        //     System.out.println(list[i]);
        // }

        dp = new int[1001];
        for (int i = 1; i <= maxEnd; i++) {
            if (list[i].isEmpty()) {
                dp[i] = dp[i-1];
                continue;
            } 

            for (int start : list[i]) {
                dp[i] = Math.max(dp[i-1], dp[start-1] + 1);
            }
            
        } 

        int max = -1;
        for (int i = 1; i <= maxEnd; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
