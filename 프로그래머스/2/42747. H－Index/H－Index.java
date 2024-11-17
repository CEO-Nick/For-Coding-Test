import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // h번 이상 인용된 논문이 h개, 나머지 논문 h번 이하 -> h의 최댓값
        // 0, 1, 3, 5, 6
        Arrays.sort(citations);
        
        int length = citations.length;
        int start = 0, end = citations[length-1];
        while (start <= end) {
          int mid = (start + end) / 2;
          int ge = 0;
          for (int i = length - 1; i >= 0; i--) {
            if (citations[i] >= mid) ge++;
            if (citations[i] <= mid) break;
          }
          if (ge < mid) {
            end = mid - 1;
          } else {
            answer = mid;
            start = mid + 1;
          }

        }
        
        return answer;
    }
}