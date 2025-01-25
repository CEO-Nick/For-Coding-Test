import java.util.*;
import java.io.*;

public class Main {

    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    static int[] dp;    // i번째 선분을 끝으로 겹치지 않게 선택할 수 있는 최대 선분의 수
    static int n;
    static ArrayList<Integer>[] list = new ArrayList[1001]; // 인덱스 = 끝점, ArrayList는 인덱스를 끝점으로 갖는 시작점들의 리스트
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

        dp = new int[1001];
        for (int i = 1; i <= maxEnd; i++) {
            // i를 끝점으로 하는 선분이 없으면 이전 dp값 그대로 가져가기
            if (list[i].isEmpty()) {
                dp[i] = dp[i-1];
                continue;
            } 
            
            // i를 끝점으로 하는 각 선분에 대해서 최대 선분의 개수 계산
            // dp[start-1] + 1의 의미 << 시작점 바로 이전의 dp값에 현재 선분을 더하면 dp[i]의 선분의 개수를 계산한거다
            // 근데 그 선분이 여러 개 있으니까 
            int max = -1;
            for (int start : list[i]) {
                max = Math.max(Math.max(dp[i-1], dp[start-1] + 1), max);
            }
            dp[i] = max;
        } 

        int ans = -1;
        for (int i = 1; i <= maxEnd; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
