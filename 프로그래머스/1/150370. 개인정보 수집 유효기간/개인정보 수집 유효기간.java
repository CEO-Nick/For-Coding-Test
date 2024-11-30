import java.util.*;

class Solution {
    
     class Privacy {
        String term;
        Integer year;
        Integer month;
        Integer day;
        
        Privacy(String t, String date) {
            this.term = t;
            this.year = Integer.parseInt(date.substring(0,4));
            this.month = Integer.parseInt(date.substring(5,7));
            this.day = Integer.parseInt(date.substring(8,10));
        }
        
        Integer endPrivacy(int duration) {
            int plusMonth = this.month + duration;
            if (plusMonth % 12 == 0) {
                this.month = 12;
                this.year += (plusMonth / 12) - 1;
            } else {
                this.month = plusMonth % 12;
                this.year += (plusMonth) / 12;
            }
            int temp = this.day - 1;
            if (temp == 0) {
                this.month--;
                this.day = 28;
                if (this.month == 0) {
                    this.year--;
                    this.month = 12;
                }
            } else {
                this.day = temp;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.year));
            if (this.month < 10) {
                sb.append(0);
            }
            sb.append(String.valueOf(this.month));
            if (this.day < 10) {
                sb.append(0);
            }
            sb.append(String.valueOf(this.day));
            return Integer.parseInt(sb.toString());
        }
        
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // 모든 달은 28일까지
        // 파기해야될 개인정보 번호를 오름차순으로
        today = today.replace(".", "");
        int td = Integer.parseInt(today);
        System.out.println(td);
        
        String[] term;
        HashMap<String, Integer> termMap = new HashMap<>();
        
        for (int i = 0; i < terms.length; i++) {
            term = terms[i].split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        
        String[] ps;
        
        for (int i = 0; i < privacies.length; i++) {
            ps = privacies[i].split(" ");
            
            Privacy p = new Privacy(ps[1], ps[0]);
            int endDate = p.endPrivacy(termMap.get(ps[1]));
            if (endDate < td) answer.add(i+1);
        }
        
        int[] arr = answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return arr;
    }
    
    
}