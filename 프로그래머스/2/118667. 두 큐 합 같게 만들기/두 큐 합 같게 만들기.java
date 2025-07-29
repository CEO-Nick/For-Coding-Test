import java.util.*;

class Solution {
    // 현재 큐의 합이 큰 쪽에서 pop해서 다른 쪽에 insert 하기
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        
        while (true) {
            if (sum1 < sum2) {
                int num = q2.poll();
                q1.offer(num);
                sum1 += num;
                sum2 -= num;
                answer++;
            } else if (sum1 > sum2) {
                int num = q1.poll();
                q2.offer(num);
                sum1 -= num;
                sum2 += num;
                answer++;
            } else {
                break;
            }
            
            if (answer >= 700000) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}