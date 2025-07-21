import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        // value(타입 개수)를 가지고 내림차순 정렬
        List<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
        for (int count : list) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}