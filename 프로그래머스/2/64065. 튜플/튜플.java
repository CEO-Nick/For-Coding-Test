import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-2);
        s = s.replace("{", "");
        String[] arr = s.split("},");
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split(",");
            ArrayList<Integer> l = new ArrayList<>();
            for (String t : tmp) {
                l.add(Integer.parseInt(t));
            };
            list.add(l);
        }
        
        list.sort((l1, l2) -> l1.size() - l2.size());
        
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (ArrayList<Integer> l : list) {
            for (int num : l) {
                if (set.contains(num)) continue;
                
                set.add(num);
                answer.add(num);
                break;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}