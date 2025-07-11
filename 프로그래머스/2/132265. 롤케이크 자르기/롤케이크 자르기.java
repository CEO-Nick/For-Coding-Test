import java.util.*;

class Solution {
    // return: 공평하게 자르는 방법 수 (없으면 0)
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> cheolsu = new HashSet<>();
        HashMap<Integer, Integer> brother = new HashMap<>(); 
        
        for (int i = 0; i < topping.length; i++) {
            int count = brother.getOrDefault(topping[i], 0);
            brother.put(topping[i], count+1);
        }
                
        for (int i = 0; i < topping.length; i++) {
            cheolsu.add(topping[i]);
            
            brother.put(topping[i], brother.getOrDefault(topping[i], 0) - 1);
            if (brother.get(topping[i]) == 0) brother.remove(topping[i]);
            
            answer += cheolsu.size() == brother.size() ? 1 : 0;
        }
        
        return answer;
    }
}