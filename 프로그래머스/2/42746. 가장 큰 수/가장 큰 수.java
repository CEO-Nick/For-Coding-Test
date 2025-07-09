import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        ArrayList<String> strList = new ArrayList<>();
        for (int num : numbers) strList.add(String.valueOf(num));
        
        Collections.sort(strList, (s1, s2) -> {
            int a = Integer.parseInt(s1 + s2);
            int b = Integer.parseInt(s2 + s1);
            return Integer.compare(b, a);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str : strList) sb.append(str);
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}