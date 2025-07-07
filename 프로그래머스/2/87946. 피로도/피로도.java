class Solution {
    
    static int answer;
    static int[][] Dungeons;
    static boolean[] visited;
    
    private static void backtrack(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            // i던전 방문한 적 없고, 현재 피로도로 갈 수 있는 경우
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                
                backtrack(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        backtrack(k, 0);
        return answer;
    }
    
    
}