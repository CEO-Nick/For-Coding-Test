import java.util.*;

class Solution {
    
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            visited = new boolean[n+1];
            
            // 해당 전선 삭제
            adjList[wire[0]].remove(new Integer(wire[1]));
            adjList[wire[1]].remove(new Integer(wire[0]));   
            
            // 한 쪽 전력망 크기 구하기
            count = 0;
            dfs(1);
            answer = Math.min(answer, Math.abs((n - count) - count));
            
            // 전선 복구
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        
        return answer;
    }
    
    
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int count;
    
    static void dfs(int node) {
        visited[node] = true;
        count++;
        
        for (int next : adjList[node]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}