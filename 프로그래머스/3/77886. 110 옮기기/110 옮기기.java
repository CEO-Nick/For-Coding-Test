import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length; i++) {
            String target = s[i];
            sb = new StringBuilder();
            int cnt = 0;
            
            // target에서 "110" 뽑아내고 개수 세기
            for (int j = 0; j < target.length(); j++) {
                int sbLen = sb.length();
                if (sbLen >= 2 && target.charAt(j) == '0') {
                    if (sb.charAt(sbLen-1) == '1' && sb.charAt(sbLen-2) == '1') {
                        cnt++;
                        sb.delete(sbLen-2, sb.length());
                        continue;
                    }
                } 
                sb.append(target.charAt(j));                
            }
        
            // 뽑아내고 난 문자열에서 마지막에서 첫번째로 발견되는 0 뒤에 "110" 붙이는게 가장 작은 경우
            // 0이 발견되지 않으면 idx = -1로 맨앞에 "110"을 붙이면 된다
            int idx = -1;
            for (int j = sb.length()-1; j >= 0; j--) {
                if (sb.charAt(j) == '0') {
                    idx = j;
                    break;
                }
            } 
            
            for (int j = 0; j < cnt; j++) sb.insert(idx+1, "110");
            
            answer[i] = sb.toString();
        }
        return answer;
    }
}