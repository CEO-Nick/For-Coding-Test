import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder tmp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != ' ') {
                tmp.append(cur);
            } else {
                if (tmp.length() == 0) {
                    answer.append(" ");
                } else {
                    answer.append(jadenCase(tmp.toString())).append(" ");
                    
                }
                tmp = new StringBuilder();
            }
        }
        
        if (tmp.length() != 0) answer.append(jadenCase(tmp.toString()));
        
        
        return answer.toString();
    }
    
    public static String jadenCase(String word) {
        char first = word.charAt(0);
        
        if (Character.isAlphabetic(first)) {
            String fstr = String.valueOf(first).toUpperCase();
            return fstr + word.substring(1, word.length()).toLowerCase();
        } else {
            return word.toLowerCase();
        }
    }
}