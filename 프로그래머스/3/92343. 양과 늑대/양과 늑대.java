import java.util.*;

class Solution {
    static class Info {
        int node, sheep, wolf;
        HashSet<Integer> canVisit;
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> canVisit) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.canVisit = canVisit;
        }
        
        @Override
public String toString() {
   return String.format("Info{node=%d, sheep=%d, wolf=%d, canVisit=%s}", 
                       node, sheep, wolf, canVisit);
}
    }
    
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        initTree(info, edges);
        
        ArrayDeque<Info> q = new ArrayDeque<>();
        q.add(new Info(0, 1, 0, new HashSet<>()));
        
        while (!q.isEmpty()) {
            Info cur = q.poll();
            answer = Math.max(answer, cur.sheep);
            
            // 현재 노드에서 방문 가능한 노드들 추가
            cur.canVisit.addAll(tree[cur.node]);
            
            for (int next : cur.canVisit) {
                HashSet<Integer> set = new HashSet<>(cur.canVisit);
                set.remove(next);
                
                // 다음 노드가 늑대인 경우
                if (info[next] == 1) {
                    // 갈 수 있는지 확인
                    if (cur.sheep != cur.wolf + 1) {
                        q.add(new Info(next, cur.sheep, cur.wolf+1, set));
                    }
                    continue;
                }
                
                q.add(new Info(next, cur.sheep+1, cur.wolf, set));
            } 
            
        }
        return answer;
    }
    
    private static ArrayList<Integer>[] tree;
    
    // 트리 초기화
    private static void initTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }
}