class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            boolean allRight = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    char cur = places[i][j].charAt(k);
                    if (cur == 'P') {
                        allRight = search(places[i], j, k);
                        if (!allRight) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
                if (!allRight) break;
            }
            if (allRight) {
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    public boolean search(String[] place, int x, int y) {
        boolean[][] visited = new boolean[5][5];
        int[] dxs = new int[]{-1, 0, 1, 0};
        int[] dys = new int[]{0, 1, 0, -1};
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];
            
            // 다음 칸이 5 x 5 범위 밖이거나 칸막이라면 더 조사할 필요 없음 -> 무조건 지킴
            if (notInRange(nx, ny) || place[nx].charAt(ny) == 'X') continue;
            
            // 바로 다음 칸에 사람이 있으면 -> 거리두기 안 지킴 -> 해당 대기실은 0
            if (place[nx].charAt(ny) == 'P') return false;
            
            visited[nx][ny] = true;
            
            // 다음 칸이 책상이라면 한 칸 더 조사해야 된다 
            for (int j = 0; j < 4; j++) {
                int nnx = nx + dxs[j];
                int nny = ny + dys[j];
                
                if (notInRange(nnx, nny)) continue;
                if (visited[nnx][nny]) continue;
                
                // 이전 칸은 책상이고 다음 칸은 사람이라면 거리 두기 안 지킴 -> 해당 대기실 0
                if (place[nnx].charAt(nny) == 'P') return false;
            }
        }
        return true;
    }
    
    public boolean notInRange(int nx, int ny) {
        return nx < 0 || nx >= 5 || ny < 0 || ny >= 5;
    }
}