import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for (int i = 0; i < n+2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        ArrayDeque<Integer> delete = new ArrayDeque<>();
        k++;
        
        for (String c : cmd) {
            if (c.startsWith("C")) {
                delete.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            }       
            else if (c.startsWith("Z")) {
                int restore = delete.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.valueOf(s[1]);
                
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for (int idx : delete) {
            answer[idx - 1] = 'X';
        }
        return new String(answer);
    }
}