import java.util.*;

class Solution {
    static class Stock {
        int idx;
        int price;
        
        Stock(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int peekIdx = stack.peek();
                answer[peekIdx] = i - peekIdx;
                stack.pop();
            }
            stack.push(i);
        }
        
        // stack에 남아있는거 기간 계산하기
        int n = prices.length - 1;
        while (!stack.isEmpty()) {
            answer[stack.peek()] = n - stack.peek();
            stack.pop();
        }
        
        return answer;
    }
}