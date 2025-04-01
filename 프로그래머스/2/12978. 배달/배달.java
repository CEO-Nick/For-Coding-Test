import java.util.*;

class Solution {
    static int INF = 500001;
    static class Node {
        int town;
        int cost;
        int before;
        
        Node(int t, int c, int b) {
            this.town = t;
            this.cost = c;
            this.before = b;
        }
        
        public String toString() {
            return "now: " + town + " cost: " + cost + " before: " + before;
        }
    }
    
    static int[][] grid;
    static int[] answer;
    
    public int solution(int N, int[][] road, int K) {
        // 1번 마을 기준으로 모든 도시까지 최단거리 구하기
        // K 이하인 마을 개수 구하기
        grid = new int[N+1][N+1];
        answer = new int[N+1];

        for (int i = 0; i <= N; i++) Arrays.fill(grid[i], INF);
        Arrays.fill(answer, INF);
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];
            // 조건에 도로는 여러 개 있을 수 있다고 함 -> 그 중 최소 비용 도로만 저장
            grid[a][b] = Math.min(grid[a][b], cost);
            grid[b][a] = Math.min(grid[b][a], cost);
        }
        
        bfs(N);
        
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (answer[i] <= K) res++;
        }
        return res;
    }
    
    public static void bfs(int N) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0, 0));
        answer[1] = 0;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int now = cur.town;
            int cost = cur.cost;
            for (int i = 1; i <= N; i++) {
                if (grid[now][i] == INF) continue;
                if (cur.before == i) continue;
                
                int calcCost = answer[now] + grid[now][i];
                if (calcCost < answer[i]) {
                    answer[i] = calcCost;
                    q.add(new Node(i, calcCost, now));
                }
            
            }
        }
    }
}