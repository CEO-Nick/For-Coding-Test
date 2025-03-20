import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scv : scoville) pq.add(scv);
        
        while (pq.peek() < K && pq.size() > 1) {
            answer++;
            int food1 = pq.poll();
            int food2 = pq.poll();
            pq.add(food1 + (food2 * 2));
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}