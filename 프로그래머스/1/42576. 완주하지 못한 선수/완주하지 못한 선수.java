import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participants = new HashMap<>();
        
        for (String name : participant) {
            int value = participants.getOrDefault(name, 0);
            participants.put(name, value+1);
        }
        
        for (String name : completion) {
            int value = participants.get(name);
            if (value == 1) participants.remove(name);
            else participants.put(name, value-1);
        }
        
        for (Map.Entry<String, Integer> entry : participants.entrySet()) {
            answer =  entry.getKey();
        }
        
        return answer;
    }
}