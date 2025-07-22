import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challenges = new int[N+2];
        
        for (int stg : stages) challenges[stg]++;
                
        HashMap<Integer, Double> failMap = new HashMap<>();
        double total = stages.length;
        for (int i = 1; i <= N; i++) {
            if (challenges[i] == 0) failMap.put(i, 0.0);
            else failMap.put(i, challenges[i] / total);
            total -= challenges[i];
        }
        
        return failMap.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey)
            .toArray();
    }
}