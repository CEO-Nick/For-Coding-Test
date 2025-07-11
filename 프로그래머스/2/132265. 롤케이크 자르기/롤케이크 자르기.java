import java.util.*;

class Solution {
    // return: 공평하게 자르는 방법 수 (없으면 0)
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> cheolsu = new HashMap<>();
        HashMap<Integer, Integer> brother = new HashMap<>();
        
        cheolsu.put(topping[0], 1);
        
        for (int i = 1; i < topping.length; i++) {
            int count = brother.getOrDefault(topping[i], 0);
            brother.put(topping[i], count+1);
        }
        
        answer += cheolsu.size() == brother.size() ? 1 : 0;
        
        for (int i = 1; i < topping.length; i++) {
            
            int count1 = cheolsu.getOrDefault(topping[i], 0);
            cheolsu.put(topping[i], count1 + 1);
            
            int count2 = brother.get(topping[i]);
            if (count2 == 1) brother.remove(topping[i]);
            else brother.put(topping[i], count2-1);
            
            answer += cheolsu.size() == brother.size() ? 1 : 0;
        }
        
        return answer;
    }
}