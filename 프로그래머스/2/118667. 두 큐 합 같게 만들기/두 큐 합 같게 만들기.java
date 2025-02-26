import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long sum = 0L;
        long sum1 = 0L;
        long sum2 = 0L;
        int len = queue1.length;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            sum += queue1[i] + queue2[i];
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        long std = sum / 2L;
        int count = 0;
        int num = 0;
        while (true) {
            if (sum1 == sum2) {
                return count;
            }
            
            if (count > 600000) return -1;
            
            if (sum1 > std) {
                num = q1.poll();
                if (num > std) return -1;   // 원소 1개가 두 큐의 합의 절반보다 크면 각 큐의 원소 합을 같게 만들 수 없음
                sum1 -= num;
                
                q2.add(num);
                sum2 += num;
            } else {
                num = q2.poll();
                if (num > std) return -1;
                
                sum2 -= num;
                
                q1.add(num);
                sum1 += num;
            }
            count++;
        }
        
    }
}