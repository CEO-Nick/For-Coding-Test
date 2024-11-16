import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] sum = new int[3];
        int[] std1 = new int[]{1,2,3,4,5};
        int[] std2 = new int[]{2,1,2,3,2,4,2,5};
        int[] std3 = new int[]{3,3,1,1,2,2,4,4,5,5};
    
        
        for (int i = 0; i < answers.length; i++) {
            sum[0] += answers[i] == std1[i % 5] ? 1 : 0;
            sum[1] += answers[i] == std2[i % 8] ? 1 : 0;
            sum[2] += answers[i] == std3[i % 10] ? 1 : 0;
        }
        
        int maxSum = Math.max(sum[0], Math.max(sum[1], sum[2]));
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (sum[i] == maxSum) ans.add(i+1);
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}