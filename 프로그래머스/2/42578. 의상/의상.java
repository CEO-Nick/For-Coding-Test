import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    static HashMap<String, List<String>> map;
    static List<String> chosen;
    static List<String> keyList;
    static int answer;
    
    
    public int solution(String[][] clothes) {
        answer = 1;
        map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.get(clothes[i][1]).add(clothes[i][0]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(clothes[i][0]);
                map.put(clothes[i][1], newList);
            }
        }
        
        for (Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            System.out.println(list.size());
            answer *= list.size() + 1;
        }
        
        return answer-1;
    }
    
    // keyList에서 std개만큼 중복 없이 선택
//     public static void choose(int idx, int count, int std) {
//         if (count == std) {
//             int tmp = 1;

//             for (int i = 0; i < chosen.size(); i++) {
//                 tmp *= map.get(chosen.get(i)).size();
//             }
//             answer += tmp;
//             return;
//         }
        
//         for (int i = idx; i < keyList.size(); i++) {
//             chosen.add(keyList.get(i));
//             choose(i+1, count+1, std);
//             chosen.remove(keyList.get(i));
//         }
//     }
}