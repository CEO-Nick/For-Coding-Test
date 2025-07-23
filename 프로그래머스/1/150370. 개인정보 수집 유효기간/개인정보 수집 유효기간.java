import java.util.*;

class Solution {
    // 수집 일자 + 유효기간 <= 오늘 날짜 -> 파기
    public int[] solution(String today, String[] terms, String[] privacies) {
        int now = dateToInt(today);

        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] input = term.split(" ");
            termMap.put(input[0], Integer.parseInt(input[1]) * 28);
        }
        
        int idx = 1;
        ArrayList<Integer> answer = new ArrayList<>();
        for (String privacy : privacies) {
            String[] p = privacy.split(" ");
            int past = dateToInt(p[0]);
            int end = past + termMap.get(p[1]);

            if (end <= now) answer.add(idx);
            idx++;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int dateToInt(String date) {
        String[] dates = date.split("\\.");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        
        return day + (month * 28) + (year * 12 * 28);
    }
    
}