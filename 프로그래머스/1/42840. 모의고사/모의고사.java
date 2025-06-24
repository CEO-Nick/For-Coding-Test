import java.util.*;

class Solution {
    static int NUM = 3;
    
    public int[] solution(int[] answers) {
        int[] idx = new int[NUM];
        int[][] student = new int[][] { 
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] cnt = new int[NUM];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < NUM; j++) {
                int index = i % student[j].length;
                if (answers[i] == student[j][index]) cnt[j]++;
            }
        }
        
        // cnt에서 최댓값 찾고, 최댓값인 index로 새 배열 만들기
        int max = Arrays.stream(cnt).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < NUM; i++) {
            if (cnt[i] == max) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}