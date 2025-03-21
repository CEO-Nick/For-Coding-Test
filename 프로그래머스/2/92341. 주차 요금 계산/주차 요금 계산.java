import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inOut = new HashMap<>();
        TreeMap<String, Integer> parkTime = new TreeMap<>();
        
        String[] rec;
        for (String record : records) {
            // 0: 시간 / 1: 차번호 / 2: in or out
            rec = record.split(" ");
            
            // inOut에 차 번호 있으면 입차한 기록이 이미 있고, 현재는 출차하려는 것 -> 누적 주차 시간 기록
            if (inOut.containsKey(rec[1])) {
                int in = inOut.get(rec[1]);
                int out = toMinute(rec[0]);
                int time = parkTime.getOrDefault(rec[1], 0);
                parkTime.put(rec[1], time + (out - in));
                inOut.remove(rec[1]);
            } else {    // inOut에 차 번호 없으면 현재는 입차하려는 것 -> 입차 기록하기
                inOut.put(rec[1], toMinute(rec[0]));
            }
        }
        
        // 입차 기록만 있는 차량들의 주차 시간 계산
        int endTime = toMinute("23:59");
        for (Entry<String, Integer> entry : inOut.entrySet()) {
            int diff = (endTime - entry.getValue());
            int time = parkTime.getOrDefault(entry.getKey(), 0);
            parkTime.put(entry.getKey(), time + diff);
        }
        
        // 누적 주차 시간으로 차량별 주차 요금 계산
        List<Integer> ans = new ArrayList<>();
        for (Entry<String, Integer> entry : parkTime.entrySet()) {
            ans.add(calculateFee(fees, entry.getValue()));
        }
        
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);
        return answer;
    }
    
    // 10:54 문자열 시간을 분으로 변환
    public static int toMinute(String time) {
        int hour = Integer.valueOf(time.substring(0,2));
        int minute = Integer.valueOf(time.substring(3,5));
        return hour * 60 + minute;
    }
    
    // 요금표와 누적 주차시간으로 주차 요금 계산
    public static int calculateFee(int[] fees, int time) {
        if (time <= fees[0]) return fees[1];
        else return fees[1] + (int)(Math.ceil((time - fees[0]) / (double)fees[2])) * fees[3];
    }
}