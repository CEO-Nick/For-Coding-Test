import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (char ch : arr) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                continue;
            }
            
            stack.push(ch);
        }
        
        answer = stack.isEmpty() ? 1 : 0;
        return answer;
    }
}