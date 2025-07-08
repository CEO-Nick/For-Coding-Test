class Solution {
    
    static boolean[] visitedCol;
    static boolean[] diagonal1;
    static boolean[] diagonal2;
    static int N;
    static int answer = 0;
    
    private static void backtrack(int c) {
        if (c == N) {
            answer++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visitedCol[i] || diagonal1[i+c] || diagonal2[i-c+N]) continue;
            
            visitedCol[i] = diagonal1[i+c] = diagonal2[i-c+N] = true;
            backtrack(c + 1);
            visitedCol[i] = diagonal1[i+c] = diagonal2[i-c+N] = false;
        }
    }
    
    public int solution(int n) {
        N = n;
        visitedCol = new boolean[N];
        diagonal1 = new boolean[N*2];
        diagonal2 = new boolean[N*2];
        
        backtrack(0);
        
        return answer;
    }
}