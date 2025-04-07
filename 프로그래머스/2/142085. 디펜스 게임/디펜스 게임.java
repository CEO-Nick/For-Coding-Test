import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int en : enemy) {
            pq.add(en);
            if (pq.size() <= k) {
                answer++;
                continue;
            }
            
            n -= pq.poll();
            if (n < 0) break;
            answer++;
        }
        return answer;
    }
}