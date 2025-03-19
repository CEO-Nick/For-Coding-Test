import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;        
        int[] answer = new int[n];
        answer[n-1] = -1;
        
        for (int i = n-2; i >= 0; i--) {
            int std = numbers[i];
            
            for (int j = i+1; j < n; j++) {
                // 뒷 큰수 찾은 경우
                if (std < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                } else {    // 뒤의 값들이 현재 값(std)보다 작거나 같은 경우
                    // 뒤의 값의 뒷 큰수가 -1 -> 현재 값의 뒷 큰수도 -1
                    if (answer[j] == -1) {
                        answer[i] = -1;
                        break;
                    } else if (std < answer[j]) {   // 뒤에 수의 가장 가까운 뒷큰수가 곧 내 뒷큰수..
                        answer[i] = answer[j];
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}