import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left) + 1;
        int[] answer = new int[len];
        
        int x = (int)(left / n), y = (int)(left % n);
                
        for (int k = 0; k < len; k++) {
            answer[k] = Math.max(x+1, y+1);
            
            if (++y == n) {
                x++;
                y = 0;
            }
        }
        
        return answer;
    }
}