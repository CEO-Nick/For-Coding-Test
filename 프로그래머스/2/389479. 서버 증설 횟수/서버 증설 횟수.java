import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        // m명 늘어날 때마다 1대 추가로 필요
        // m명 "미만" 증설 X
        // n x m <= < (n+1) x m -> 최소 n대 증설된 서버가 운영 중이어야 함
        // 한 번 증설한 서버는 k시간 동안 운영하고 그 이후에는 반납
        int[] servers = new int[24+k+1];
        int answer = 0;
        for (int i = 0; i < 24; i++) {
            if (players[i] < m) continue; 
            
            // 증설되어 있어야 하는 서버 수
            int need = players[i] / m;
            if (need > servers[i]) {
                // 더 필요한 서버 수
                int diff = need - servers[i];
                for (int j = i; j < i + k; j++) {
                    servers[j] += diff;
                }
                answer += diff;
            }
            
        }
        return answer;
    }
}