import java.util.*;

class Solution {
    
    static String[] banned;
    static HashMap<String, List<String>> map;
    
    public int solution(String[] user_id, String[] banned_id) {
        // key : banned id
        // value : 일치하는 user id
        map = new HashMap<>();
        
        for (int i = 0; i < banned_id.length; i++) {
            List<String> list = new ArrayList<>();
            
            for (int j = 0; j < user_id.length; j++) {
                if (isSame(user_id[j], banned_id[i])) list.add(user_id[j]);
            }
            
            map.put(banned_id[i], list);
        }
        banned = banned_id;
        userSet = new HashSet<>();
        exist = new HashSet<>();
        choose(0, 0);
        
        return exist.size();
    }
    
    static boolean isSame(String user, String ban) {
        if (user.length() != ban.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (user.charAt(i) != ban.charAt(i)) return false;
        }
        
        return true;
    }
    
    // 제재 아이디 조합 저장
    static HashSet<String> userSet;
    
    // 조합이 이미 있는 조합인지 확인
    static HashSet<HashSet<String>> exist;
    
    static void choose(int idx, int count) {
        if (count == banned.length) {
            if (!exist.contains(userSet)) {
                exist.add(new HashSet<>(userSet));
            }
            return;
        }
        
        for (String user : map.get(banned[idx])) {
            if (userSet.contains(user)) continue;
            userSet.add(user);
            choose(idx+1, count+1);
            userSet.remove(user);
        }
    }
    
}