import java.util.*;

class Solution {
    
    static int[][] LAND;
    static int[][] oilMark;
    static int N;
    static int M;
    static int NUMBER = 1;
    static int count = 0;
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        // 시추관 1개로 최대로 뽑아먹기
        N = land.length;
        M = land[0].length;
        LAND = land;
        oilMark = new int[N][M];
        
        // key는 석유 덩어리 번호, value는 덩어리 크기
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);  // oilMark에서 0은 덩어리가 없는 경우인데 나중에 계산할 때 if 예외 처리하지말고 그냥 값을 0으로 추가해두기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 석유가 없거나 이미 체크한 경우
                if (land[i][j] == 0 || oilMark[i][j] != 0) continue;
                count = 0;
                DFS(i, j);
                map.put(NUMBER, count);
                NUMBER++;
            }
        }
        
        // 현재 열에서 뽑을 수 있는 석유 덩어리 번호
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list;
        for (int j = 0; j < M; j++) {
            set.clear();
            int result = 0;
            // 현재 열에서 시추할 수 있는 덩어리 번호 set에 추가
            for (int i = 0; i < N; i++) {
                set.add(oilMark[i][j]);
            }
            
            // set 돌면서 석유량 계산
            list = new ArrayList<>(set);
            for (int key : list) result += map.get(key);
            
            answer = Math.max(answer, result);
        }
        
        return answer;
    }
    
    // 현재 좌표에서 시작해서 석유 덩어리 체크하기
    public void DFS(int x, int y) {
        oilMark[x][y] = NUMBER;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];
            
            if (canGo(nx, ny)) DFS(nx, ny);
        }
    }
    
    public boolean canGo(int nx, int ny) {
        // N x M 범위 밖인 경우
        if (!inRange(nx, ny)) return false;
        
        // 이미 방문했거나 석유가 없는 경우
        if (oilMark[nx][ny] != 0 || LAND[nx][ny] == 0) return false;
        
        return true;
    }
    
    public boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}