import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Stack<Character> stack = new Stack();
        
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (stack.isEmpty()) return false;
                
                if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                }                
            }
            stack.push(arr[i]);
        }
        
        if (stack.isEmpty()) return true;
        
        return answer;
    }
}