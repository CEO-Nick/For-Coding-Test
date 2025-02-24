import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;
        
        for (int i = pickups.length - 1; i >= 0;) {
            
            // 배달/수거 모두 할 일 없는 집일 때만 pass
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }
            
            calc(deliveries, cap, i);
            calc(pickups, cap, i);
            
            answer += (i + 1) * 2;
        }
        return answer;
    }
    
    static void calc(int[] arr, int cap, int idx) {
        while (idx >= 0) {
            if (cap >= arr[idx]) {
                cap -= arr[idx];
                arr[idx--] = 0;
            } else {
                arr[idx] -= cap;
                break;
            }
        }
    }
}