import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        int total = brown + yellow;
        
        for (int i = 1; i < (int) (Math.sqrt(yellow)) + 1; i++) {
            if (yellow % i == 0) {
                int j = yellow / i;
                int calc = (i+2) * (j+2);
                if (calc == total) {
                    ans[1] = i + 2;
                    ans[0] = j + 2;
                    break;
                }
            }
            
        }
        
        return ans;
    }
}