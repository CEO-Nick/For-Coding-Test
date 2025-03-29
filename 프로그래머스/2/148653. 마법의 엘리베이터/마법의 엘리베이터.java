import java.util.*;

class Solution {    
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int remain = storey % 10;
            storey /= 10;
            
            if (remain < 5) {
                answer += remain;
            } else if (remain > 5) {
                answer += (10 - remain);
                storey++;
            } else { 
                answer += remain;
                if (storey % 10 >= 5) storey++;
            }
        }
        return answer;
    }
}