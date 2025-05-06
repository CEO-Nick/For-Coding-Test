import java.util.*;

class Solution {
    static int[][] packages;
    static int N;
    
    public int solution(int n, int w, int num) {
        int answer = 0;
        N = (n / w);
        N += (n % w != 0 ? 1 : 0);
        packages = new int[N][w];
        
        HashMap<Integer, Integer[]> map = new HashMap<>();
        
        int cur = 1;
        for (int i = 0; i < N; i++) {
            
            // 정순
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    if (cur > n) break;
                    map.put(cur, new Integer[]{i, j});
                    packages[i][j] = cur++;
                }
                continue;
            }
            
            // 역순
            for (int j = w - 1; j >= 0; j--) {
                if (cur > n) break;
                map.put(cur, new Integer[]{i, j});
                packages[i][j] = cur++;
            }
        }
        
        int x = map.get(num)[0];
        int y = map.get(num)[1];
        for (int i = x; i < N; i++) {
            if (packages[i][y] != 0) answer++;
        }
        return answer;
    }
}