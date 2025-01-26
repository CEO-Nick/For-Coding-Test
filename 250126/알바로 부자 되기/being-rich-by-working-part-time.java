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

        @Override
        public String toString() {
            return "Work{" +
                "start=" + start +
                ", end=" + end +
                ", money=" + money +
                '}';
        }
    }
    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Work> list = new ArrayList<>();
        int[] dp = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list.add(new Work(s, e, m));
            dp[i] = m;
        }

        dp[0] = list.get(0).money;
        for (int i = 1; i < n; i++) {
            Work cur = list.get(i);
            for (int j = 0; j < i; j++) {
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