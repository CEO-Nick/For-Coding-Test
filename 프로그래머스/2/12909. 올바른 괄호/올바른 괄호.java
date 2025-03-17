import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            char cur = arr[i];
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            
            char top = stack.peek();
            
            if (top == '(' && cur == ')') {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;

    }
}