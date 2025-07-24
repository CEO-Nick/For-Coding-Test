import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length; i++) {
            String target = s[i];
            sb = new StringBuilder();
            int cnt = 0;
            
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