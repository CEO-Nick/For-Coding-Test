import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> A = makeList(str1.toLowerCase());
        List<String> B = makeList(str2.toLowerCase());
        
        // 둘 다 공집합인 경우 -> 유사도 1
        if (A.size() == 0 && B.size() == 0) return 1 * 65536;
        // 둘 중 하나만 공집합인 경우 -> 유사도 0
        if (A.size() == 0 || B.size() == 0) return 0;
        
        // B만 Map으로 만들기
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: B) {
            int cnt = map.getOrDefault(word, 0);
            map.put(word, cnt+1);
        }
        
        int du = 0;     // 교집합 개수
        for (String std : A) {
            // 문자열이 B의 map에 있으면 교집합으로 인정
            if (map.containsKey(std)) {
                du++;
                int cnt = map.get(std) -1;
                
                // 0개면 map에서 아예 삭제 -> 삭제 안하면 교집합으로 계속 인정됨
                if (cnt == 0) map.remove(std);
                else map.put(std, cnt);
            } 
        }
        
        // 합집합 개수
        int total = A.size() + B.size() - du;
        
        return (int)(((double) du / total) * 65536);
    }
    
    // 문자열을 문자열을 두 글자씩 끊어서 리스트로 반환
    public static List<String> makeList(String str) {
        ArrayList<String> res = new ArrayList<>();
        String tmp;
        
        for (int i = 0; i < str.length() - 1; i++) {
            tmp = str.substring(i, i + 2);
            
            // 영문자 쌍일 때만 list에 추가
            if (isOnlyAlpha(tmp)) res.add(tmp);
        }
        return res;
    }
    
    // 알파벳으로만 이뤄졌는지 검증
    public static boolean isOnlyAlpha(String str) {
        if (!Character.isAlphabetic(str.charAt(0))) return false;
        if (!Character.isAlphabetic(str.charAt(1))) return false;
        return true;
    }
}