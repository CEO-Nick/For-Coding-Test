class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int gcdA = 0;
        int gcdB = 0;
        if (n == 1) {
            gcdA = arrayA[0];
            gcdB = arrayB[0];
        } else {
            gcdA = gcd(arrayA[0], arrayA[1]);
            gcdB = gcd(arrayB[0], arrayB[1]);
        }
        
        for (int i = 1; i < n - 1; i++) {
            gcdA = gcd(gcdA, arrayA[i+1]);
            gcdB = gcd(gcdB, arrayB[i+1]);
        }
        
        boolean find = true;
        for (int i = 0; i < n; i++) {
            if (arrayA[i] % gcdB == 0) {
                find = false;
                break;
            }
        }
        if (find) answer = gcdB;
        
        find = true;
        for (int i = 0; i < n; i++) {
            if (arrayB[i] % gcdA == 0) {
                find = false;
                break;
            }
        }
        if (find) answer = Math.max(answer, gcdA);

        return answer;
    }
    
    public static int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        
        while(true){
           int r = a % b;
           if(r == 0) return b;
           a = b;
           b = r;
        }
    }
}