import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // 이름 - 인덱스
        HashMap<String, Integer> enrollMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            enrollMap.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String curSeller = seller[i];
            int curAmount = amount[i] * 100;        
            
            // 현재 seller의 parent
            int curIdx = enrollMap.get(curSeller);
            String parent = referral[curIdx];
            int charge = curAmount * 10 / 100;
            
            while (charge > 0 && !parent.equals("-")) {
                charge = curAmount * 10 / 100;
                answer[curIdx] += (curAmount - charge);
                
                curSeller = parent;
                curIdx = enrollMap.get(parent);
                parent = referral[curIdx];
                curAmount = charge;
            }
            
            // 마지막 center에게 수수료 주고 남은거 더하기
            charge = curAmount * 10 / 100;
            answer[curIdx] += (curAmount - charge);
            
        }
        
        return answer;
    }
}