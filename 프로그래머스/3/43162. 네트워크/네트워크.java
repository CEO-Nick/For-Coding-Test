class Solution {
    
    static int[][] networks;
    static boolean[] visited;
    static int N;
    
    static void DFS(int x) {
        visited[x] = true;

        for (int j = 0; j < N; j++) {
            if (x == j) continue;
            if (!visited[j] && networks[x][j] == 1) {
                DFS(j);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        N = n;
        networks = computers;
        
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            // 방문한 노드 pass
            if (visited[i]) continue;
            
            // 노드 i가 갈 수 있는 컴퓨터들 모두 방문 => 1개의 네트워크 
            DFS(i);
            answer++;
        }
        return answer;
    }
}