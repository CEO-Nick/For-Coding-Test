import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> idMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
        }
        
        HashMap<String, Set<String>> reportMap = new HashMap<>();
        for (String rep : report) {
            String[] input = rep.split(" ");
            
            if (!reportMap.containsKey(input[1])) {
                Set<String> set = new HashSet<>();
                reportMap.put(input[1], set);  
            } 
            
            reportMap.get(input[1]).add(input[0]);
        }
        
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                // 신고한 유저들 목록
                String[] names = entry.getValue().toArray(new String[0]);
                for (String name : names) {
                    answer[idMap.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}