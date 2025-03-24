import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int n = order.length;
        int idx = 0;
        
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            
            while(!stack.isEmpty()) {
                if (stack.peek() == order[idx]) {
                    stack.pop();
                    idx++;
                    cnt++;
                }
                else break;
            }
        }
        
        
        return cnt;
    }
}