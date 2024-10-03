import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int answerIdx = 0;
        
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 1; i <= n; i++) number.add(i);
        
        n--;
        
        while (true) {
    
            long div = fact(n--);
            long idx = (k / div);
            long nextK = (k % div);
            if (nextK == 0) idx--;
            answer[answerIdx++] = number.remove((int)idx);
            k = nextK;
            
            // number에 남은 정수들 역순으로 넣고 끝내기
            if (k == 0) {
                for (int j = number.size() - 1; j >= 0; j--) {
                    answer[answerIdx++] = number.get(j);
                }
                break;
            }
            
            // number에 남은 정수들 순서대로 넣기
            if (k == 1) {
                for (int j = 0; j < number.size(); j++) {
                    answer[answerIdx++] = number.get(j);
                } 
                break;
            }
        }
        return answer;
    }
    
    public long fact(int x) {
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        } 
        return result;
    }
}                  