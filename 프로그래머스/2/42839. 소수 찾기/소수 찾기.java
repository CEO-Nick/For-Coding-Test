import java.util.*;

class Solution {
    static int STOP;
    static String num;
    static int N;
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        N = numbers.length();
        int answer = 0;
        num = numbers;
        visited = new boolean[N];
        
        // 1자리 숫자부터 N자리 숫자까지 가능한 모든 숫자 조합 만들기 
        for (int i = 1; i <= N; i++) {
            STOP = i;
            choose(0, "");
        }    
        
        List<Integer> list = new ArrayList<>(set);
        for (int n : list) answer += isPrime(n) ? 1 : 0;
        
        return answer;
    }
    
    static boolean[] visited;
    public static void choose(int cnt, String str) {
        if (cnt == STOP) {
            set.add(Integer.valueOf(str));
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            
            str += num.charAt(i);
            visited[i] = true;
            
            choose(cnt+1, str);
            str = str.substring(0, str.length()-1);
            visited[i] = false;
        }   
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        
        for (int i = 2; i < (int)(Math.sqrt((double)num) + 1.0); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}