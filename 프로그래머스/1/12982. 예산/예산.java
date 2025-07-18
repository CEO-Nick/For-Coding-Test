import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int amount : d) {
            if (budget < amount) break;
            budget -= amount;
            answer++;
        }
        
        return budget >= 0 ? answer : answer - 1;
    }
}