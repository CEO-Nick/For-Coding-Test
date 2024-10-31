import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        int idx = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (idx < length) {
            char c = s.charAt(idx);
            char nc = 'a';
            if (idx != length - 1) nc = s.charAt(idx+1);
            
            switch(c) {
                case 'z':
                    sb.append("0");
                    idx += 4;
                    break;
                case 'o':
                    sb.append("1");
                    idx += 3;
                    break;
                case 't':
                    if (nc == 'w') {
                        sb.append("2");
                        idx += 3;
                    } else {
                        sb.append("3");
                        idx += 5;
                    }
                    break;
                case 'f':
                    if (nc == 'o') sb.append("4");
                    else sb.append("5");
                    idx += 4;
                    break;
                case 's':
                    if (nc == 'i') {
                        sb.append("6");
                        idx += 3;
                    } else {
                        sb.append("7");
                        idx += 5;
                    }
                    break;
                case 'e':
                    sb.append("8");
                    idx += 5;
                    break;
                case 'n':
                    sb.append("9");
                    idx += 4;
                    break;
                default:
                    sb.append(c - '0');
                    idx += 1;
                    break;
            }
            // System.out.println(sb);
        }
        
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}