import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 이름과 index를 매핑해주는 map
        HashMap<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            nameToIndex.put(id_list[i], i);
        }
        
        // 신고받은 사람이 key, 그 사람을 신고한 사람들을 set으로 저장 (중복 신고 제외하려고 set)
        HashMap<String, Set<String>> reportMap = new HashMap<>();
        
        String[] input = null;
        String reporter = null;    // 신고한 사람
        String reported = null;    // 신고받은 사람
        for (int i = 0; i < report.length; i++) {
            input = report[i].split(" ");
            reporter = input[0];
            reported = input[1];
            
            if (reportMap.containsKey(reported)) {
                reportMap.get(reported).add(reporter);
            } else {
                HashSet<String> set = new HashSet<>();
                set.add(reporter);
                reportMap.put(reported, set);
            }
        }
        // reportMap = {muzi=[apeach], neo=[muzi, frodo], frodo=[muzi, apeach]}
        
        for (Entry<String, Set<String>> entry : reportMap.entrySet()) {
            // 신고한 사람이 k명 이상인 경우 
            if (entry.getValue().size() >= k) {
                for (String person : entry.getValue()) {
                    int idx = nameToIndex.get(person);
                    answer[idx]++;  // 받은 메일 수 count
                }
            }
        }
        
        return answer;
    }
}