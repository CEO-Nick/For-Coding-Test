import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }
        int num = 27;
        
        List<Integer> ans = new ArrayList<>();
        int n = msg.length();
        int idx = 0;
        StringBuilder sb;
        
        while (idx < n) {
            int i = idx;
        
            sb = new StringBuilder();
            sb.append(msg.charAt(i));
            int res = 0;
            while (dict.containsKey(sb.toString())) {
                res = dict.get(sb.toString());
                i++;
                if (i >= n) break;
                sb.append(msg.charAt(i));
            }
            dict.put(sb.toString(), num++);
            ans.add(res);
            idx = i;
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}