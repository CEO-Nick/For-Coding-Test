import java.util.*;
import java.math.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0L;
        long right = 0L;
        for (int t : times) {
            right = Math.max(right, t);
        }
        right *= n;

        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0L;
            for (int time : times) {
                people += (mid / time);
                if (people > n) {
                    break;
                }
            }
            
            if (people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}