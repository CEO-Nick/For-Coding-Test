import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> A = makeList(str1.toLowerCase());
        List<String> B = makeList(str2.toLowerCase());
        
        // 둘 다 공집합인 경우 -> 유사도 1
        if (A.size() == 0 && B.size() == 0) return 1 * 65536;
        // 둘 중 하나만 공집합인 경우 -> 유사도 0
        if (A.size() == 0 || B.size() == 0) return 0;
        
        Collections.sort(A);
        Collections.sort(B);
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: B) {
            int cnt = map.getOrDefault(word, 0);
            map.put(word, cnt+1);
        }
        
        
        int du = 0;
        for (String std : A) {
            if (map.containsKey(std)) {
                du++;
                int cnt = map.get(std);
                if (cnt == 1) map.remove(std);
                else map.put(std, cnt-1);
            } 
        }
        
        int total = A.size() + B.size() - du;
        
        answer = (int)(((double) du / total) * 65536);
        return answer;
    }
    
    public static List<String> makeList(String str) {
        int n = str.length() - 1;
        ArrayList<String> res = new ArrayList<>();
        String tmp;
        for (int i = 0; i < n; i++) {
            tmp = str.substring(i, i + 2);
            // 영문자 쌍일 때만 list에 추가
            if (isOnlyAlpha(tmp)) res.add(tmp);
            
        }
        return res;
    }
    
    public static boolean isOnlyAlpha(String str) {
        if (!Character.isAlphabetic(str.charAt(0))) return false;
        if (!Character.isAlphabetic(str.charAt(1))) return false;
        return true;
    }
}