import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = new int[2];
        
        int[] pSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            pSum[i+1] = pSum[i] + sequence[i];
        }
        
        
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 1;
        while (l < r && r <= n) {            
            int diff = pSum[r] - pSum[l];
            
            if (diff == k) {
                // 갱신
                if (r - l < minLen) {
                    minLen = r - l;
                    answer[0] = l; answer[1] = r-1;
                }
                l++;
            } else if (diff < k) {
                r++;    
            } else {
                l++;
            }
        }
        
        return answer;
    }
}