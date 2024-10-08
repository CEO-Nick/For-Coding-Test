import java.util.*;

class Solution {
    class Word {
        String value;
        int depth;
        
        Word(String v, int d) {
            this.value = v;
            this.depth = d;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // words에 없으면 변환 불가능
        boolean exists = false;
        for (String w : words) {
            if (target.equals(w)) exists = true;
        }
        if (!exists) return 0;
        
        boolean[] visited = new boolean[words.length];
        
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word cur = q.poll();
            
            if (cur.value.equals(target)) {
                answer = cur.depth;
                break;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canTransfer(cur.value, words[i])) {
                    q.add(new Word(words[i], cur.depth + 1));
                    visited[i] = true;
                }
            }   
            
        }
        
        
        
        
        return answer;
    }
    
    public boolean canTransfer(String from, String to) {
        int cnt = 0;
        boolean can = true;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) cnt++;
            if (cnt > 1) {
                can = false;
                break;
            }
        }
        
        return can;
    }
}