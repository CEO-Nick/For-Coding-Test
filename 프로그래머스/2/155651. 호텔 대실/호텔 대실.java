import java.util.*;

class Solution {
    static class Event implements Comparable{
        int time;
        boolean isCheckIn;
        
        Event(int t, boolean c) {
            this.time = t;
            this.isCheckIn = c;
        }
        
        public int compareTo(Object obj) {
            Event e = (Event) obj;
            // 같은 시간이면 checkout 먼저 처리
            if (this.time == e.time) {
                return this.isCheckIn ? 1 : -1;
            }
            return this.time - e.time;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Event> list = new ArrayList<>();
        
        for (int i = 0; i < book_time.length; i++) {
            int inTime = toMinute(book_time[i][0]);
            int outTime = Math.min(toMinute(book_time[i][1]) + 10, 1439);
            list.add(new Event(inTime, true));
            list.add(new Event(outTime, false));
        }
        Collections.sort(list);
        
        int cnt = 0;
        for (Event e : list) {
            if (e.isCheckIn) cnt++;
            else cnt--;
            
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    
    // HH:MM 형식의 문자열을 분으로 변환
    public static int toMinute(String time) {
        return (Integer.valueOf(time.substring(0,2)) * 60) + Integer.valueOf(time.substring(3, 5));
    }

}