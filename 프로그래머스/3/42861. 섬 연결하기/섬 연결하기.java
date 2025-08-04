import java.util.*;

class Solution {
    // 최소 경로 -> n-1개 간선 선택 
    // costs 배열을 비용으로 오름차순 정렬해서
    // 안겹치게 n-1개 저장하면 되지 않을까?
    
    static class Point implements Comparable<Point> {
        int node;
        int cost;
        
        Point(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        public int compareTo(Point p) {
            return this.cost - p.cost;
        }
        
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<Point>[] arrList = new ArrayList[n];
        for (int i = 0; i < n; i++) arrList[i] = new ArrayList<Point>();
        
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            arrList[a].add(new Point(b, c));
            arrList[b].add(new Point(a, c));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0));
        
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            answer += cur.cost;
            
            for (int i = 0; i < arrList[cur.node].size(); i++) {
                int to = arrList[cur.node].get(i).node;
                int val = arrList[cur.node].get(i).cost;
                
                if (visited[to]) continue;
                
                pq.add(new Point(to, val));
            }
        }
        return answer;
    }
}