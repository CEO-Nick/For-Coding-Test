import java.util.*;

class Solution {
    // A팀원을 이길 때, 최소한의 숫자로 이기기
    public int solution(int[] A, int[] B) {
        int answer = 0;
        TreeMap<Integer, Integer> bTeam = new TreeMap<>();
        
        for (int b : B) {
            bTeam.put(b, bTeam.getOrDefault(b, 0) + 1);
        }
        
        for (int a : A) {
            Integer b = bTeam.higherKey(a);
            
            if (b != null) {
                answer++;
                int count = bTeam.get(b);
                if (count == 1) bTeam.remove(b);
                else bTeam.put(b, count-1);
            }
        }
        return answer;
    }
}