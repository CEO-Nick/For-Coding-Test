import java.util.*;

class Solution {
    static int N;
    static int[] ryan;
    static int[] apeach;
    static int[] answer;
    static int max = -1;
    
    
    // idx : 점수 (10-idx) 점
    public void dp(int count, int start) {
        if (count == N) {
            int res = compare();
            if (res > max) {
                answer = ryan.clone();
                max = res;
            }
            return;
        }
        
        // 10 - i 인 이유는 낮은 점수부터 조합 만들기 위해서
        for (int i = start; i <= 10; i++) {
            if (apeach[10-i] < ryan[10-i]) continue;  // 이미 ryan이 이겼는데 거기에 화살을 추가할 필요 없음
            ryan[10-i]++;
            dp(count+1, i);
            ryan[10-i]--;
        }
        
        
    }
    
    // ryan 이기면 점수 차이 반환 | 지면 -1 반환
    public int compare() {
        int a_score = 0;
        int r_score = 0;
        for (int i = 0; i <= 10; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            else if (apeach[i] >= ryan[i]) a_score += (10 - i);
            else r_score += (10 - i);
        }
        
        return r_score > a_score ? (r_score - a_score) : -1;
    }
    
    public int[] solution(int n, int[] info) {
        N = n;
        ryan = new int[11];
        answer = new int[11];
        apeach = info;
        
        dp(0, 0);
        
        System.out.println(Arrays.toString(answer));
        System.out.println(max);
        if (max == -1) {
            answer = new int[] {-1};
        }
        return answer;
    }
}