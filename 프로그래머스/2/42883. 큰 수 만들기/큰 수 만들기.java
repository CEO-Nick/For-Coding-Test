import java.util.*;

class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        
        int cnt = 0;
        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            while (cnt < k && !dq.isEmpty() && dq.getLast() < cur) {
                dq.removeLast();
                cnt++;
            } 
            dq.add(cur);
        }
        while (cnt < k) {
            dq.removeLast();
            cnt++;
        }
        Character[] arr = dq.toArray(new Character[0]);
        StringBuilder sb = new StringBuilder();
        for (char c : arr) sb.append(c);
        return sb.toString();
    }
}