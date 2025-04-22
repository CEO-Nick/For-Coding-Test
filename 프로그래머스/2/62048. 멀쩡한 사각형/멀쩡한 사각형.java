class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        for (int i = 1; i < w; i++) {
            answer += result(w, h, i);
        }
        
        return answer*2;
    }
    
    public static long result(int w, int h, int i) {
        return  ((long) h * i) / w;
    }
}