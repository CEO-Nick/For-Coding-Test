import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int idx = 0;
        int length = word.length();
        int diff = 781; // 1 + 5 + 25 + 125 + 625
        while (idx < length) {
            char ch = word.charAt(idx++);
            
            switch(ch) {
                case 'A':
                    answer += diff * 0 + 1;
                    break;
                case 'E':
                    answer += diff * 1 + 1;
                    break;
                case 'I':
                    answer += diff * 2 + 1;
                    break;
                case 'O':
                    answer += diff * 3 + 1;
                    break;
                case 'U':
                    answer += diff * 4 + 1;
                    break;
                    
            }
            diff -= (int) Math.pow(5, 5-idx);
        }
        return answer;
    }
    
}