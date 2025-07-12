import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n != 0) {
            // 짝수 일 때는 순간이동
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}