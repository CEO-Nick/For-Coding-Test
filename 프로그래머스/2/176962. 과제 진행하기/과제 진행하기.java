import java.util.*;

class Solution {
    static class Plan implements Comparable {
        String name;
        int start;
        int remainingTime;
        
        Plan(String name, int start, int remainingTime) {
            this.name = name;
            this.start = start;
            this.remainingTime = remainingTime;
        }
        
        public void decreaseRemainingTime(int time) {
            remainingTime -= time;
        }
        
        public int compareTo(Object obj) {
            Plan p = (Plan) obj;
            return this.start - p.start;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int answerIdx = 0;
        
        ArrayList<Plan> planList = new ArrayList<>();
        for (String[] p : plans) {
            planList.add(new Plan(p[0], timeToMinute(p[1]), Integer.valueOf(p[2])));
        }
        Collections.sort(planList);
        
        Plan onProgress = planList.get(0);      // 현재 진행 중인 과제
        Stack<Plan> blocking = new Stack<>();   // 잠시 멈춰둔 과제
        
        for (int i = 1; i < planList.size(); i++) {
            Plan curPlan = planList.get(i);
            int timePassed = curPlan.start - onProgress.start;
            
            // 현재 과제 다 못끝낸 경우
            if (timePassed < onProgress.remainingTime) {
                // 지나간 시간만큼 남은 시간 차감
                onProgress.decreaseRemainingTime(timePassed);
                blocking.push(onProgress);
                onProgress = curPlan;
                continue;
            } 
            
            // 현재 과제 딱 맞게 끝내고 새 과제 시작하는 경우
            if (timePassed == onProgress.remainingTime) {
                answer[answerIdx++] = onProgress.name;
                onProgress = curPlan;
                continue;
            }
            
            // 현재 과제 끝내고도 시간이 남은 경우
            // 잠시 멈춰둔 과제가 없는 경우
            if (blocking.isEmpty()) {
                answer[answerIdx++] = onProgress.name;
                onProgress = curPlan;
                continue;
            }
            
            // 시간이 남고 멈춰둔 과제가 있다.
            answer[answerIdx++] = onProgress.name;
            int availableTime = timePassed - onProgress.remainingTime;
            
            // 남은 시간만큼 멈춰둔 과제 하기(다하면 정답에 기록, 다 못하면 남은 시간 차감)
            while (!blocking.isEmpty()) {
                Plan p = blocking.peek();
                
                if (p.remainingTime > availableTime) {
                    p.decreaseRemainingTime(availableTime);
                    break;
                } else if (p.remainingTime == availableTime) {  
                    answer[answerIdx++] = blocking.pop().name;
                    break;
                } else {
                    answer[answerIdx++] = blocking.pop().name;
                    availableTime -= p.remainingTime;
                }
            }
            onProgress = curPlan; 
        }
        
        // 마지막으로 진행 중이던 과제 끝내기
        answer[answerIdx++] = onProgress.name;
        
        // 그다음부터는 잠시 멈춘 과제들 모두 꺼내서 기록
        while (!blocking.isEmpty()) {
            answer[answerIdx++] = blocking.pop().name;
        }
        
        return answer;
    }
    
    // "hh:mm" -> 분 단위로 변환
    public static int timeToMinute(String time) {
        String[] times = time.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }
}