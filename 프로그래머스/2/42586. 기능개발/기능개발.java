import java.util.*;

class Solution {
    static class Work {
        int idx;
        int duration;
        
        Work(int idx, int duration) {
            this.idx = idx;
            this.duration = duration;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        Work[] works = new Work[speeds.length];
        
        for (int i = 0; i < progresses.length; i++) {
            works[i] = new Work(i, (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
    
        
        int cnt = 1;
        int curDuration = works[0].duration;
        
        for (int i = 1; i < works.length; i++) {
            if (works[i].duration > curDuration) {
                answer.add(cnt);
                cnt = 1;
                curDuration = works[i].duration;
                continue;
            }
            
            cnt++;
        }
    
        answer.add(cnt);
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}