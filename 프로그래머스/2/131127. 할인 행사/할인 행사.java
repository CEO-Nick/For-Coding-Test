import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> needs = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            needs.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> needs10d = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                if (needs.containsKey(discount[j])) {
                    needs10d.put(discount[j], needs10d.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if (needs10d.equals(needs)) {
                answer++;
            }
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