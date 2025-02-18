import java.util.*;

class Solution {
    static class Node {
        int num;
        int depth;
        
        Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
    
    static boolean[] visited;
    static int maxDepth = 0;
    static int count = 0;
    static void BFS() {
        Queue<Node> q = new ArrayDeque<>();
        
        q.add(new Node(1, 0));
        visited[1] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.depth > maxDepth) {
                maxDepth = cur.depth;
                count = 1;
            } else if (cur.depth == maxDepth) count++;
            
                
            for (int node : adjList[cur.num]) {
                if (!visited[node]) {
                    q.add(new Node(node, cur.depth+1));
                    visited[node] = true;
                }
            }
        }
    }
    
    
    static ArrayList<Integer>[] adjList;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0], b = edge[i][1];
            adjList[a].add(b);
            adjList[b].add(a);
        }
        
        visited = new boolean[n+1];
        
        BFS();
        
        return count;
    }
}