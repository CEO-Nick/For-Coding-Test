import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] room = new int[1440];
        for (int i = 0; i < book_time.length; i++) {
            int inTime = toMinute(book_time[i][0]);
            int outTime = Math.min(toMinute(book_time[i][1]) + 10, 1439);
            for (int k = inTime; k < outTime; k++) room[k]++;
        }
        
        for (int i = 0; i < 1440; i++) {
            answer = Math.max(answer, room[i]);
        }
        return answer;
    }
    
    // HH:MM 형식의 문자열을 분으로 변환
    public static int toMinute(String time) {
        return (Integer.valueOf(time.substring(0,2)) * 60) + Integer.valueOf(time.substring(3, 5));
    }

}