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
        
        // endDate가 같은 알바끼리 모아두기
        HashMap<Integer, ArrayList<Work>> endMap = new HashMap<>();
        StringTokenizer st;
        int maxEndDate = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            maxEndDate = Math.max(maxEndDate, e);
            if (endMap.containsKey(e)) {
                endMap.get(e).add(new Work(s, e, m));
            } else {
                ArrayList<Work> list = new ArrayList<>();
                list.add(new Work(s, e, m));
                endMap.put(e, list);
            }
        }

        int[] dp = new int[maxEndDate+1];

        for (int i = 1; i <= maxEndDate; i++) {
            if (!endMap.containsKey(i)) {
                dp[i] = dp[i-1];
            }
            else {
                int max = dp[i-1];
                ArrayList<Work> works = endMap.get(i);
                for (Work w : works) {
                    max = Math.max(max, dp[w.start-1] + w.money);
                }
                dp[i] = max;
            }
        }

        int ans = -1;
        for (int i = 0; i <= maxEndDate; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}