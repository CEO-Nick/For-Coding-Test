import java.util.*;

class Solution {
    static String DIAMOND = "diamond";
    static String IRON = "iron";
    static String STONE = "stone";
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPick = picks[0] + picks[1] + picks[2];
        
        // group[i][0] = 5개 광물 피로도 합 | group[i][1] = 다이아 개수 [2] = 철 개수 [3] = 돌 개수 
        int[][] group = new int[minerals.length / 5 + 1][4];
        
        for (int i = 0; i < minerals.length; i++) {
            // 광물이 더 많은 경우
            if (totalPick * 5 <= i) break;
            
            if (minerals[i].equals(DIAMOND)) {
                group[i/5][0] += 25;
                group[i/5][1]++;
            } else if (minerals[i].equals(IRON)) {
                group[i/5][0] += 5;
                group[i/5][2]++;
            } else if (minerals[i].equals(STONE)) {
                group[i/5][0] += 1;
                group[i/5][3]++;
            }
        }
        
        // 피로도 높은 순으로 정렬
        Arrays.sort(group, (a, b) -> b[0] - a[0]);
        
        System.out.println(Arrays.deepToString(group));
        
        // 피로도 계산하기
        int groupIdx = 0;
        int fatigue = 0;
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0) continue;
            
            while (groupIdx < group.length && picks[i]-- > 0) {
                if (i == 0) {
                    fatigue += group[groupIdx][1] + group[groupIdx][2] + group[groupIdx][3];
                } else if (i == 1) {
                    fatigue += group[groupIdx][1] * 5 + group[groupIdx][2] + group[groupIdx][3];
                } else if (i == 2) {
                    fatigue += group[groupIdx][1] * 25 + group[groupIdx][2] * 5 + group[groupIdx][3];
                }
                groupIdx++;
            }
        }
        return fatigue;
    }
    

}