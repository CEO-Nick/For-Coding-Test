class Solution {
    static int[] ryan;
    static int[] apeach;
    static int[] answer;
    
    static int N;
    static int MAX = Integer.MIN_VALUE;
    
    static void dp(int idx, int cnt) {
        if (cnt == N) {
            int diff = compare();
            if (diff > MAX) {
                answer = ryan.clone();
                MAX = diff;
            }
            return;
        }
        
        for (int i = idx; i >= 0; i--) {
            // 이미 라이언이 이김
            if (ryan[i] > apeach[i]) continue;
            ryan[i]++;
            dp(i, cnt+1);
            ryan[i]--;
        }
    }
    
    // 라이언이 이기면 점수차이 반환, 어피치가 이기면 -1 반환
    private static int compare() {
        int ryanScore = 0;
        int apeachScore = 0;
        for (int i = 0; i <= N; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            
            if (apeach[i] >= ryan[i]) {
                apeachScore += (10 - i);
            } else {
                ryanScore += (10 - i);
            }
        }
        
        int diff = ryanScore - apeachScore;
        return diff > 0 ? diff : -1;
    }
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        ryan = new int[11];
        N = n;
        
        dp(10, 0);
        
        return MAX == -1 ? new int[] {-1} : answer;
    }
}