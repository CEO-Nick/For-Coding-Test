import java.util.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1); // -1 파라미터는 빈 문자열도 배열에 포함시킴

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + 
                           (words[i].length() > 1 ? words[i].substring(1).toLowerCase() : "");
            }
        }

        return String.join(" ", words);
    }
}