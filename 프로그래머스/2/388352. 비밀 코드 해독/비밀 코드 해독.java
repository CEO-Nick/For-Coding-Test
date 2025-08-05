import java.util.*;

class Solution {
    // 정답 조합을 찾아놓고, 역으로 시도해서 ans와 모두 같으면 정답임
    
    static int N;
    static int[][] tries;
    static int[] answer;
    static int count = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        list = new ArrayList<>();
        N = n;
        tries = q;    
        answer = ans;
        
        choose(1);
        return count;
    }
    
    
    static ArrayList<Integer> list;
    
    public static void choose(int num) {
        if (list.size() == 5) {
            HashSet<Integer> set = new HashSet<>(list);
            boolean allCorrect = true;
            
            for (int i = 0; i < tries.length; i++) {
                int cnt = 0;
                
                for (int t : tries[i]) {
                    if (set.contains(t)) cnt++;
                }
                
                // 하나의 시도라도 시스템 응답과 다르면 가능한 조합 아님
                if (answer[i] != cnt) {
                    allCorrect = false;
                    break;
                }
            }
             
            if (allCorrect) count++;
            return;
        }
        
        for (int i = num; i <= N; i++) {
            list.add(i);
            choose(i+1);
            list.remove(list.size()-1);
        }
    }
}