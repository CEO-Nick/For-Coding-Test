import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> needs = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            needs.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            if (needs.containsKey(discount[i])) {
                needs.put(discount[i], needs.get(discount[i]) - 1);
            }
        }
        answer += isEmpty(needs) ? 1 : 0;
        
        for (int i = 10; i < discount.length; i++) {
            if (needs.containsKey(discount[i-10])) {
                needs.put(discount[i-10], needs.get(discount[i-10]) + 1);
            }
            if (needs.containsKey(discount[i])) {
                needs.put(discount[i], needs.get(discount[i]) - 1);
            }
            
            answer += isEmpty(needs) ? 1 : 0;
        }
        return answer;
    }
    
    
    public static boolean isEmpty(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        
        return true;
    }
}