import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left) + 1;
        int[] answer = new int[len];
//         int[][] arr2 = new int[n][n];
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int max = Math.max(i+1, j+1);
//                 arr2[i][j] = max;
//             }
//         }
        
        int x = (int)(left / n), y = (int)(left % n);
                
        for (int k = 0; k < len; k++) {
            answer[k] = Math.max(x+1, y+1);
            
            if (++y == n) {
                x++;
                y = 0;
            }
        }
        
        return answer;
    }
}