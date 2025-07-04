import java.util.*;

class Solution {
    
    static class Node {
        int num;
        int cost;
        
        Node (int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] adjList;
    
    public int solution(int N, int[][] road, int K) {
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int n1 = road[i][0];
            int n2 = road[i][1];
            int cost = road[i][2];
            adjList[n1].add(new Node(n2, cost));
            adjList[n2].add(new Node(n1, cost));   
        }
        
        int[] minCost = new int[N+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        pq.add(new Node(1, 0));
        minCost[1] = 0;
        
        boolean[] visited = new boolean[N+1];
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (visited[cur.num]) continue;
            visited[cur.num] = true;
            
            for (Node next : adjList[cur.num]) {
                
                
                if (minCost[next.num] > minCost[cur.num] + next.cost) {
                    minCost[next.num] = minCost[cur.num] + next.cost;
                    pq.add(new Node(next.num, minCost[next.num]));
                }
            }
        }
        
        int answer = 0;
        for (int cost : minCost) {
            if (cost <= K) answer++;
        }

        return answer;
    }
}