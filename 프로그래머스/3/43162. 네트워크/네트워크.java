class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    static void dfs(int x, int[][] computers) {
        visited[x] = true;
        
        for (int j = 0; j < computers[x].length; j++) {
            if (x == j || visited[j]) continue;
            
            if (computers[x][j] == 1) dfs(j, computers);
        }
    }
}