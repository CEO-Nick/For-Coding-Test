import java.util.*;

class Solution {
    static boolean[] visited;
    static int maxCount;
    
    class Dungeon {
        int mini;
        int use;
        
        Dungeon(int m, int u) {
            this.mini = m;
            this.use = u;
        }
    }
    
    static Dungeon[] arr;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        arr = new Dungeon[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            arr[i] = new Dungeon(dungeons[i][0], dungeons[i][1]);
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k) {
                maxCount = Integer.MIN_VALUE;
                visited = new boolean[dungeons.length];
                dfs(i, 1, k);
                answer = Math.max(answer, maxCount);
                
            }
        }
        return answer;
    }
    
    public int dfs(int start, int count, int fatigue) {
        
        visited[start] = true;
        fatigue -= arr[start].use;
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                if (fatigue >= arr[i].mini) {
                    // System.out.println("i" + i);
                    int c = dfs(i, count + 1, fatigue);
                    maxCount = Math.max(maxCount, c);
                }
            }
        }
        visited[start] = false;
        return count;
    }
    
}