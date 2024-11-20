import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int[][] tree;
    static int count;
    
    public int solution(int n, int[][] wires) {
        n = n;
        int answer = Integer.MAX_VALUE;
        
        // for문을 돌면서 끊을 전선 정보 선택
        // 해당 전선 끊겼다고 가정하고 각각 dfs해서 개수 차이 구하기
        // 굳이 직접 끊을 필요 없이 dfs 돌기전에 두 노드 visited = true 처리하면 될 듯
        
        tree = new int[n+1][n+1];
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            tree[a][b] = 1;
            tree[b][a] = 1;
        }
        
        for (int[] wire : wires) {
            visited = new boolean[n+1];
            visited[wire[0]] = true;
            visited[wire[1]] = true;
            
            count = 0;
            dfs(wire[0], n);
            int net1 = count;
            
            count = 0;
            dfs(wire[1], n);
            int net2 = count;
            answer = Math.min(answer, Math.abs(net1 - net2));
        }
        return answer;
    }
                    
    static void dfs(int node, int n) {
        visited[node] = true;
        count++;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && tree[node][i] != 0) {
                dfs(i, n);
            }
        }
    }
}