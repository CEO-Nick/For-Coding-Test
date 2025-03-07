import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> size = new HashSet<>(Arrays.asList(gems));
        int max = size.size();
        int l = 0, r = 0;
        int al = 1, ar = gems.length;
        int min = Integer.MAX_VALUE;
        
        HashMap<String, Integer> map = new HashMap<>();
        while (r < gems.length) {
            int count = map.getOrDefault(gems[r], 0) + 1;
            map.put(gems[r++], count);
            while (map.size() == max) {
                if (min > r - l) {
                    min = r - l;
                    al = l + 1;
                    ar = r;
                }
                count = map.get(gems[l]) - 1;
                if (count == 0) map.remove(gems[l]);
                else map.put(gems[l], count);
                l++;
            }
            
        }
        return new int[] {al, ar};
    }
}