import java.util.*;

class Solution {
    // 당첨 번호, 내 번호 비교 시 hashset이 떠오름
    // 당첨 번호를 hashset에 넣구, 현재 lottos에서 맞는 숫자 개수 구하기 -> 최저 순위
    // 거기에 0인 개수 더한 경우 -> 최고 순위

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> winning = new HashSet<>();
    
        for (int win : win_nums) winning.add(win);
        
        int zero = 0;
        int count = 0;
        for (int my : lottos) {
            if (my == 0) {
                zero++;
                continue;
            }
            
            if (winning.contains(my)) count++;
        }
        
        // 최저 순위
        if (count <= 1) answer[1] = 6;
        else answer[1] = 7 - count;
        
        // 최고 순위
        count += zero;
        if (count <= 1) answer[0] = 6;
        else answer[0] = 7 - count;
        
        return answer;
    }
}