import java.util.*;

class Solution {
    static int N;
    
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int work : works) pq.add(work);
        
        while (n > 0 && !pq.isEmpty()) {
            int work = pq.poll();
            work--;
            n--;
            if (work > 0) pq.add(work);
        }
        
        while (!pq.isEmpty()) {
            answer += (int)(Math.pow(pq.poll(), 2));
        }
        
        return answer; 
    }
    
    
}