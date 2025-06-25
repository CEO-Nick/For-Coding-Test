import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayDeque<Character> stringStack = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        for (char ch : chs) stringStack.add(ch);
        
        answer += isRight(stringStack.toArray(new Character[0])) ? 1 : 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char front = stringStack.removeFirst();
            stringStack.addLast(front);
            
            answer += isRight(stringStack.toArray(new Character[0])) ? 1 : 0;
        }
        
        return answer;
    }
    
    public static boolean isRight(Character[] arr) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (char ch : arr) {
            if (ch == ']') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                return false;
            }
            
            if (ch == '}') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                return false;
            }
            
            if (ch == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                return false;
            }
            
            stack.push(ch);
        }
        
        if (stack.isEmpty()) return true;
        return false;
    }
}