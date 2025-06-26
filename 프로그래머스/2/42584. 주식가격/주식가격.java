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
        
        Stack<Stock> stack = new Stack<>();
        stack.push(new Stock(0, prices[0]));
        for(int i = 1; i < prices.length; i++) {
            if (stack.peek().price <= prices[i]) {
                stack.push(new Stock(i, prices[i]));
                continue;
            }
            
            
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                int peekIdx = stack.peek().idx;
                answer[peekIdx] = i - peekIdx;
                stack.pop();
            }
            stack.push(new Stock(i, prices[i]));
        }
        
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (answer[i] == 0) answer[i] = n-i-1;
        }
        return answer;
    }
}