import java.util.*;

class Solution {
    class UV {
        String u = "";
        String v = "";
        
        UV() {}
        
        UV(String u, String v) {
            this.u = u;
            this.v = v;
        }
    }
    
    public String solution(String p) {
        
        if (p.equals("")) return p;

        // 2. p -> u, v로 분리
        UV uv = split(p);

        if (isRight(uv.u)) {
            return uv.u + solution(uv.v);
        }
        else {
            return "(" + solution(uv.v) + ")" + reverse(uv.u);
        }
           
    }
    
    public UV split(String origin) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        UV uv = new UV();
        
        for (int i = 0; i < origin.length(); i++) {
            char cur = origin.charAt(i);
            
            if (cur == '(') left++;
            else right++;
            sb.append(cur);
            
            if (left == right) {
                uv.u = sb.toString();
                uv.v = origin.substring(i + 1, origin.length());
                break;
            }
        }
        
        return uv;
    }
    
    public boolean isRight(String target) {
        Stack<Character> stk = new Stack<>();
        
        stk.push(target.charAt(0));
        for (int i = 1; i < target.length(); i++) {
            char cur = target.charAt(i);
                
            if (stk.peek() == '(' && cur == ')') {
                stk.pop();
            }
            else stk.push(cur);
        }
        
        if (stk.size() == 0) return true;
        else return false;
    } 
    
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        // 마지막 문자, 첫 문자 제외하고 괄호 뒤집기
        for (int i = 1; i < s.length() - 1; i++) {
            char cur = s.charAt(i);
            if (cur == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
}