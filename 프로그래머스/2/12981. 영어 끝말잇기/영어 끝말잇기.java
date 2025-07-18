import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashSet<String> spokenWords = new HashSet<>();
        
        String beforeWord = words[0];
        spokenWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            
            if (beforeWord.charAt(beforeWord.length()-1) != word.charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
            
            if (spokenWords.contains(word)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
            
            spokenWords.add(word);
            beforeWord = word;
        }

        return answer;
    }
}