import java.util.*;

class Solution {
    
    static int MAX = 10000000;
    public int solution(String[] strs, String t) {
        int answer = 0;
        
        int[] dp = new int[t.length()];
        Arrays.fill(dp, MAX);
        
        HashSet<String> set = new HashSet<>(Arrays.asList(strs));
        
        // if (set.contains(String.valueOf(t.charAt(0)))) dp[0] = 1;
        
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < 5; j++) {
                int idx = i-j;
                if (idx < 0) break;
                
                String tmp = t.substring(idx, i+1);
                // System.out.println("idx: " + idx + " tmp: " + tmp);
                if (idx == 0) {
                    if (set.contains(tmp)) {
                        dp[i] = Math.min(dp[i], 1);
                    }
                    continue;
                }
                
                if (set.contains(tmp)) {
                    dp[i] = Math.min(dp[i], dp[idx-1] + 1);
                }
            }
                
        }
        
        System.out.println(Arrays.toString(dp));
        
        return dp[t.length()-1] >= MAX ? -1 : dp[t.length()-1];
    }
}