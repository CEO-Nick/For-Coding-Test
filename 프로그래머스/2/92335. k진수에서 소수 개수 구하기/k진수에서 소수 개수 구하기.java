import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n, int k) {
        // 조건 : 소수인지 각 자릿수에 0이 없는 소수
    
        int answer = 0;
        
        String baseChanged = changeBase(n, k);
        String[] pList = baseChanged.split("0");
        for (String p : pList) {
            if (p.equals("")) continue;
            
            if (isPrime(Long.parseLong(p))) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(long n) {
        if (n <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) 
            if (n % i == 0) return false;
        
        return true;
    }
    
    // 진법 변환
    public String changeBase(int n, int k) {
        return Long.toString(n, k);
    }
    
    
}