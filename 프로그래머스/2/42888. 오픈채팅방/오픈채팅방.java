import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> idNameMap = new HashMap<>();
        
        for (String rec : record) {
            if (rec.startsWith("E") || rec.startsWith("C")) {
                String[] input = rec.split(" ");
                idNameMap.put(input[1], input[2]);
            }
        } 
                
        StringBuilder sb;
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            sb = new StringBuilder();
            String[] input = record[i].split(" ");
            
            if (input[0].startsWith("E")) {
               answer.add(sb.append(idNameMap.get(input[1]))
                    .append("님이 들어왔습니다.")
                    .toString());
            } else if (input[0].startsWith("L")) {
                answer.add(sb.append(idNameMap.get(input[1]))
                    .append("님이 나갔습니다.")
                    .toString());
            }
        }
        
        return answer.toArray(new String[0]);
    }
}