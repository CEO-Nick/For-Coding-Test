import java.util.*;

class Solution {
    
    static class Word {
        String value;
        int depth;
        
        Word(String value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        // begin -> target
        // 한 번에 1개의 알파벳만 바꿀 수 있음. 근데 그 단어 words에 있어야 함
        boolean[] visited = new boolean[words.length];
        
        ArrayDeque<Word> q = new ArrayDeque<>();
        q.add(new Word(begin, 0));
        while (!q.isEmpty()) {
            Word cur = q.poll();
            if (target.equals(cur.value)) {
                return cur.depth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(cur.value, words[i])) {
                    visited[i] = true;
                    q.add(new Word(words[i], cur.depth + 1));
                }
            }
        }
        
        return 0;
    }
    
    // a -> b로 변환 가능한지
    public boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            char aa = a.charAt(i), bb = b.charAt(i);
            if (aa != bb) diff++;
            if (diff >= 2) return false;
        }
        
        return true;
    }
}