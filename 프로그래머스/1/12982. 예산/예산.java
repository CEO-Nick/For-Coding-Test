import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        for (int amount : d) {
            budget -= amount;
            if (budget < 0) break;
            
            answer++;
        }
        
        return answer;
    }
}