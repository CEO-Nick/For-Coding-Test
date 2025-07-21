import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        // value(타입 개수)를 가지고 내림차순 정렬
        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .collect(Collectors.toList());
        
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            k -= entry.getValue();
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}