import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m*t; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        char[] arr = sb.toString().toCharArray();
        
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i % m == p-1) sb.append(arr[i]);
            if (sb.length() == t) break;
        }
        
        return sb.toString().toUpperCase();
    }
}