class Solution {
    public String solution(String new_id) {
        // 길이 : 3~15
        // 소문자, 숫자, -, _, . 만 사용 가능
        // .는 맨 앞, 맨 뒤, 연속 사용 불가능
        
        /*
        1. 소문자로
        2. 소문자, 숫자, -, _, . 제외한 문자 제거
        3. 연속된 .. 들 모두 .으로 
        4. 맨 앞, 맨 뒤의 . 제거
        5. 빈 문자열 -> a 대입
        6. 길이 16 이상 -> 15 초과 문자 모두 제거 (제거 후, 마지막이 .이라면 이것도 제거)
        7. 길이 2 이하 -> 마지막 문자를 길이 3 될 때까지 끝에 붙임
        */
        
        String answer = "";
        
        // 1단계
        answer = new_id.toLowerCase();
        
        // 2단계
        answer = replaces(answer);
        
        // 3단계
        int len = answer.length();
        while(true) {
            answer = answer.replace("..", ".");
            
            if (answer.length() == len) break;
            len = answer.length();
        }
        
        // 4단계
        if (!answer.isEmpty() && answer.charAt(0) == '.') answer = answer.substring(1, len);
        len = answer.length();
        if (!answer.isEmpty() && answer.charAt(len-1) == '.') answer = answer.substring(0, len-1);
        
        // 5단계
        if (answer.isEmpty()) answer = "a";
        
        // 6단계
        len = answer.length();
        if (len >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') answer = answer.substring(0, 14);
        }
        
        // 7단계
        if (len <= 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(answer);
            char end = answer.charAt(len-1);
            while (sb.length() < 3) {
                sb.append(end);
            }
            answer = sb.toString();
        }
        return answer;
    }
    
    static String replaces(String newId) {
        int n = newId.length();
        for (int i = 0; i < n; i++) {
            char cur = newId.charAt(i);
            // 소문자, 숫자, -, _, . 인 경우 pass
            if ((cur >= 97 && cur <= 122) || (cur >= 48 && cur <= 57) || cur == '-' || cur == '_' || cur == '.') continue;
            newId = newId.replace(cur, ' ');
        }
        
        newId = newId.replaceAll(" ", "");
        return newId;
    }
    
}