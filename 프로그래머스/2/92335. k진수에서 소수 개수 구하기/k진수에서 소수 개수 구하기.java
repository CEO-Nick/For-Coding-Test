import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String changed = changeBase(n, k);
        
        changed = changed.replaceAll("0", " ");
        String[] numArr = changed.split(" ");
        
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i].equals("")) continue;
            if (isPrime(Long.parseLong(numArr[i]))) answer++;
        }
        return answer;
    }
    
    // 진수 변환 메서드 (10진수 n -> k진수)
    public String changeBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n >= k) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);
        
        return sb.reverse().toString();
    }
    
    
    // 소수 판별 메서드
    public boolean isPrime(long n) {
        if (n == 1) return false;
        int size = (int) Math.sqrt(n);
        for (int i = 2; i < size + 1; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}