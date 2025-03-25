import java.util.*;

class Solution {
    static class File implements Comparable{
        String head;
        int number;
        int idx;
        
        File(String h, int n, int i) {
            head = h;
            number = n;
            idx = i;
        }
        
        public int compareTo(Object obj) {
            File f = (File) obj;
            if (this.head.equals(f.head)) {
                return this.number - f.number;
            }
            return this.head.compareTo(f.head);
        }
        
        public String toString() {
            return head + "\t" + number;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = {};
        // Head & Number로 구분
        // Head -> Number 순으로 정렬
        
        List<File> ans = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            ans.add(extract(files[i].toLowerCase(), i));
        }
        Collections.sort(ans);
        
        answer = new String[files.length];
        for (int i = 0; i < ans.size(); i++) {
            int index = ans.get(i).idx;
            answer[i] = files[index];
        }
        
        return answer;
    }
    
    public static File extract(String file, int idx) {
        StringBuilder sb = new StringBuilder();
        int n = file.length();
        
        int i = 0;
        while (i < n && !Character.isDigit(file.charAt(i))) {
            sb.append(file.charAt(i));
            i++;
        }
        String head = sb.toString();
        
        sb = new StringBuilder();
        while (i < n && Character.isDigit(file.charAt(i))) {
            sb.append(file.charAt(i));
            i++;
        }
        
        int number = Integer.valueOf(sb.toString());
        return new File(head, number, idx);
    }
}