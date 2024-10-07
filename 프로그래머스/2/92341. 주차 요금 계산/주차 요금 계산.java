import java.util.*;
// import java.Math.*;

class Solution {
    public HashMap<String, String> inMap = new HashMap<>();
    public HashMap<String, Integer> accumulatedTime = new HashMap<>();
    public TreeMap<String, Integer> feeMap = new TreeMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        // 입차만 하고 출차 기록 없으면 23:59에 출차한걸로 간주
        // 차량별 누적 주차 시간 계산 -> 요금 계산
        // 기본 시간(180분) "이하" -> 5000원
        // 기본 시간 "초과" -> 5000 + 단위 요금 청구
            // 초과 시간이 15분 -> [11 / 10] = 2  (올림)
                
        // 누적 주차 시간 계산
        for (String record : records) {
            calcAccTime(record);
        }
        
        // 출차 안한 차량 주차 시간 계산
        calcRemain();
        
        // 주차 요금 계산
        calcFee(fees);
        
        // 차량 번호 순으로 오름차순 출력
        int[] answer = new int[feeMap.size()];
        int idx = 0;
        for (String key : feeMap.keySet()) {
            answer[idx++] = feeMap.get(key);
        }
        
        return answer;
    }
    
    // 누적 주차 시간 계산
    public void calcAccTime(String record) {
        String[] rs = record.split(" ");
        // rs[0] : 시간   rs[1] : 차량번호    rs[2] : IN or OUT
        if (rs[2].equals("IN")) {
            inMap.put(rs[1], record);
        }
        else {
            String entrance = inMap.get(rs[1]).split(" ")[0];
            String exit = rs[0];
            
            // 주차 시간 계산
            int diffMin = calcDiffMin(entrance, exit);
            
            // 주차 시간 누적
            accumulatedTime.put(rs[1], accumulatedTime.getOrDefault(rs[1], 0) + diffMin);
            
            inMap.remove(rs[1]);
        }
        
    }
    
    // 두 문자열 시간의 분 차이 계산
    public int calcDiffMin(String en, String ex) {
        String inHour = en.split(":")[0];
        String inMin = en.split(":")[1];
        
        int enMin = Integer.parseInt(inHour) * 60 + Integer.parseInt(inMin);
        
        String outHour = ex.split(":")[0];
        String outMin = ex.split(":")[1];
        
        int exMin = Integer.parseInt(outHour) * 60 + Integer.parseInt(outMin);
        
        return exMin - enMin;
    }
    
    // 입차만 한 차량 출차 기록
    public void calcRemain() {
        for (String key : inMap.keySet()) {
            int diffMin = calcDiffMin(inMap.get(key).split(" ")[0], "23:59");
            accumulatedTime.put(key, accumulatedTime.getOrDefault(key, 0) + diffMin);   
        }
    }
    
    // 누적 요금 계산
    public void calcFee(int[] fees) {
        int fee = 0;
        for( Map.Entry<String, Integer> elem : accumulatedTime.entrySet()) {
            String key = elem.getKey();
            int diffMin = elem.getValue();
            if (diffMin <= fees[0]) {
                fee = fees[1];
            } else {
                int over = diffMin - fees[0];
                fee = fees[1] + ((int)(Math.ceil((double)over/fees[2])) * fees[3]);
            }
            feeMap.put(key, feeMap.getOrDefault(key, 0) + fee);
        }        
    }       
}