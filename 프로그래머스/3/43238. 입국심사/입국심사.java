import java.util.*;
import java.math.*;

class Solution {
    static int N;
    static int maxTime;
    static int[] TIMES;
    static long answer = Long.MAX_VALUE;
    
    static void binarySearch() {
        long left = 0L, right = 1000000000000000000L;
        
        while (left <= right) {
            long mid = (left + right) / 2L;  // mid는 걸린 시간 값을 말함
            System.out.println("left: " + left + "\tright: " + right + "\tmid: " + mid);
            
            long result = calc(mid);
            System.out.println("result: " + result);
            
            // mid 시간동안 처리할 수 있는 사람의 수가 N명보다 많은 경우 -> 시간을 줄여본다. 근데 정답일 수도 있으니 정답 갱신도 진행
            if (result >= N) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }           
        }
    }
    
    // time 동안 처리할 수 있는 사람의 수
    static long calc(long time) {
        long res = 0L;
        for (int t : TIMES) {
            res += time / (long) t;
        }
        
        return res;
    }
        
        
    public long solution(int n, int[] times) {
        N = n;
        TIMES = times;
        binarySearch();
        
        return answer;
    }
}