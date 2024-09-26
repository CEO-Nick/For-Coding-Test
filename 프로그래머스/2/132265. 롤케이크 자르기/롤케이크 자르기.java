import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 각 토핑이 몇 개씩 있는지 조사
        // 동생 먹을거 고르면 조사한거에서 빼면 그게 형이 먹을 개수임
        
        HashMap<Integer, Integer> toppingMap = new HashMap<>();
        for (int t : topping) {
            toppingMap.put(t, toppingMap.getOrDefault(t, 0) + 1);
        }
        
        HashSet<Integer> toppingSet = new HashSet<>();
        
        for (int t : topping) {
            // 동생이 먹을 토핑 추가
            toppingSet.add(t);
            
            // 그 토핑의 개수 빼기
            toppingMap.put(t, toppingMap.get(t) - 1);
            
            // 토핑 다 먹었으면 제거하기
            if (toppingMap.get(t) == 0) toppingMap.remove(t);
            
            // 동생이 먹을 토핑 종류와 남은 토핑 종류(=형이 먹을 토핑 종류)가 같다면
            if (toppingSet.size() == toppingMap.size()) answer ++;
            
        }
        return answer;
    }
}