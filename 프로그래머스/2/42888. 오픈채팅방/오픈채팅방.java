import java.util.*;

class Solution {
    static class User {
        String uid;
        String nickname;
        
        User(String uid, String nickname) {
            this.uid = uid;
            this.nickname = nickname;
        }
        
        void changeNickname(String newNickname) {
            this.nickname = newNickname;
        }
        
        public String toString() {
            return "[uid: " + uid + " nickname: " + nickname + "] ";
        }
    }
    
    
    public String[] solution(String[] record) {
        // 닉변 : 나가고 새롭게 들어오기 OR 그냥 변경하기 (중복 허용)
        // 닉변하면 기존 채팅방에 출력된 메시지 닉네임들도 전부 변경
            // 특정 값을 가리키게 한 후에 그 값을 수정하면 나중에 봤을 때는 다 수정된 걸로 보임
        
        String[] split = null;
        String userId = null;
        String nickname = null;
        
        String ENTER = "Enter";
        String LEAVE = "Leave";
        String CHANGE = "Change";
        
        HashMap<String, User> uidToUser = new HashMap<>();
        ArrayList<String> inOut = new ArrayList<>();
        
        for (String rec : record) {
            split = rec.split(" ");
            userId = split[1];
            
            if (split[0].equals(LEAVE)) {
                inOut.add(rec);
                continue;
            }
            
            nickname = split[2];
            
            if (split[0].equals(ENTER)) {
                // ENTER인데 이미 매핑되어 있음 -> 닉네임 변경
                if (uidToUser.containsKey(userId)) {
                    uidToUser.get(userId).changeNickname(nickname);
                } else {
                    uidToUser.put(userId, new User(userId, nickname));
                }
                inOut.add(split[0] + " " + userId);
            } else {
                uidToUser.get(userId).changeNickname(nickname);
            }
        }
        
        // System.out.println(uidToUser);
        // System.out.println(inOut);
        
        String[] answer = new String[inOut.size()];
        String enterTemplate = "님이 들어왔습니다.";
        String leaveTemplate = "님이 나갔습니다.";
        
        int idx = 0;
        for (String result : inOut) {
            split = result.split(" ");
            if (split[0].equals(ENTER)) answer[idx++] = uidToUser.get(split[1]).nickname + enterTemplate;     
            else answer[idx++] = uidToUser.get(split[1]).nickname + leaveTemplate; 
        }

        return answer;
    }
}