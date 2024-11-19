import java.util.*;

class Solution {
    
    static HashSet<Integer> ans = new HashSet<>();
    static boolean[] visited;
    static String target;
    
    public int solution(String numbers) {
        
        visited = new boolean[numbers.length()];
        target = numbers;
        
        dfs("", 0);
        
        return ans.size();
    }
    
    static void dfs(String temp, int depth) {
        if (!temp.equals("")) {
            int n = Integer.parseInt(temp);
            if (isPrime(n)) ans.add(n);
        }
        
        if (depth > target.length()) return;
        
        for (int i = 0; i < target.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(temp + target.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
        
    }
    
    static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
