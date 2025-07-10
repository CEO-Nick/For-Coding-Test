import java.util.*;

class Solution {
    static class Node {
        int x, y;
        int cost;
        
        Node (int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.add(new Node(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            
            answer += cur.cost;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                
                int diff = Math.abs(land[cur.x][cur.y] - land[nx][ny]);
                int newCost = 0;
                if (diff > height) {
                    newCost += diff;
                } 
                pq.add(new Node(nx, ny, newCost));
            }
        }
        return answer;
    }
}