import java.util.*;
import java.io.*;

public class Main {

    static class Work {
        int start;
        int end;
        int money;

        Work(int s, int e, int m) {
            start = s;
            end = e;
            money = m;
        }
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Work> list = new ArrayList<>();
        int[] dp = new int[n];  // 알바 i할 때 얻을 수 있는 최대 금액

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list.add(new Work(s, e, m));
            dp[i] = m;  // 알바 i만 했을 때 벌 수 있는 돈
        }

        dp[0] = list.get(0).money;
        for (int i = 1; i < n; i++) {
            Work cur = list.get(i);
            for (int j = 0; j < i; j++) {
                // 알바 j를 할 수 있다면(cur과 안겹친다면) (현재 dp값)과 (알바 j했을 때 dp값 + 현재 알바 금액) 을 비교한다
                if (list.get(j).end < cur.start) {
                    dp[i] = Math.max(dp[i], dp[j] + cur.money);
                }
            }
        
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}