import java.util.*;

class Solution {
    
    public int[] solution(int N, int[] stages) {
        int[] user = new int[N+2];
        
        for (int i = 0; i < stages.length; i++) {
            user[stages[i]]++;
        }
        
        Map<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        for (int i = 1; i <= N; i++) {
            if (user[i] == 0) {
                fails.put(i, 0.);
                continue;
            }
            
            fails.put(i, user[i] / total);
            total -= user[i];
        }
        
        
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}