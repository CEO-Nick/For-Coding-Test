import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // e로 오름차순 정렬
        Arrays.sort(targets, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // 현재 요격하는 x좌표
        int intercept = targets[0][1];
        answer++;
        
        for (int[] target : targets) {
            // 현재 요격 좌표 이상에서 폭격 시작되면 요격 추가 및 갱신
            if (target[0] >= intercept) {
                answer++;
                intercept = target[1];
            }
        }
        
        return answer;
    }
}