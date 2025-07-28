class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String target = Integer.toString(n, k);
        String[] candidates = target.split("0");
        
        for (String str : candidates) {
            if (str.equals("")) continue;
            if (isPrime(str)) answer++;
        }
        return answer;
    }
    
    public static boolean isPrime(String num) {
        long number = Long.parseLong(num);
        
        if (number == 2) return true;
        if (number <= 1) return false;
        
        for (int i = 2; i < (int)(Math.sqrt(number) + 1); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}