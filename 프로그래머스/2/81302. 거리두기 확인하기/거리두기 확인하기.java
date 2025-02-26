class Solution {
    public int[] solution(String[][] places) {
        // 맨해튼 거리 2이하 X (BUT 파티션 막혀 있으면 O)
        // P = 사람
        // O = 빈 테이블
        // X = 파티션
        // 대기실은 5개, 각 대기실 5 x 5
        // 각 대기실에서 모두 다 지켜야 1, 한명이라도 안지키면 그 대기실은 0
        int answer[] = new int[5];
        for (int k = 0; k < places.length; k++) {
            answer[k] = check(places[k]) ? 1 : 0;

        }
        return answer;
    }
    
    static boolean[][] visited;
    
    // 대기실 별 거리두기 확인
    static boolean check(String[] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i].charAt(j) == 'P') {
                    visited = new boolean[5][5];
                    visited[i][j] = true;
                    boolean res = possible(room, i, j);
                    // 한 사람이라도 거리두기 어기면 해당 대기실은 0
                    if (!res) return false;
                }
            }
        }
        return true;
    }
    
    static int[] dxs = new int[] {1, 0 , -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    
    // (x, y) 기준으로 맨해튼 거리 2이하 조사
    static boolean possible(String[] room, int x, int y) {
        for (int i = 0; i < 4; i++) {
            // 맨해튼 거리 1 조사
            int nx = x + dxs[i], ny = y + dys[i];
            if (inRange(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                char next = room[nx].charAt(ny);
                
                if (next == 'X') continue;
                else if (next == 'P') return false;
                else {
                    // 맨해튼 거리 2 조사
                    for (int j = 0; j < 4; j++) {
                        int nnx = nx + dxs[j], nny = ny + dys[j];
                        if (inRange(nnx, nny) && !visited[nnx][nny]) {
                            visited[nnx][nny] = true;
                            char nnext = room[nnx].charAt(nny);
                            if (nnext == 'P') return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < 5 && 0 <= ny && ny < 5;
    }
    
}