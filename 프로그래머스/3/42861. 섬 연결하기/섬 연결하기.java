import java.util.Arrays;


class Solution {
    
    static private int[] parent;
    
    // x의 root 노드 찾기
    static int find(int x) {
        if (parent[x] == x) return x;
        
        // x의 부모를 루트로 설정 -> 경로 압축
        return parent[x] = find(parent[x]);
    }
    
    // 두 집합 하나의 집합으로 합치기
    static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        
        // parent 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int edges = 0;
        
        for (int[] edge : costs) {
            if (edges == n-1) break;
            
            // 두 섬이 연결되어 있는지 확인
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        return answer;
    }
}