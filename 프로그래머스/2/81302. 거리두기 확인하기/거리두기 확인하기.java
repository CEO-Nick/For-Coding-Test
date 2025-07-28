import java.util.*;

class Solution {
    // 맨해튼 거리 2 이하로 앉지 말기
    // 파티션 있으면 ㄱㅊ
    // 모두 거리두기 O -> 1
    // 한명이라도 X -> 0
    
    static int[] answer;
    public int[] solution(String[][] places) {
        answer = new int[5];
        Arrays.fill(answer, 1);
        for (String[] place : places) {
            check(place);
        }
        return answer;
    }
    
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int idx = 0;
    
    public static void check(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) != 'P') continue;
                
                // 첫 칸 이동해보기
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                    
                    // 사람 있으면 끝
                    if (place[nx].charAt(ny) == 'P') {
                        answer[idx++] = 0;
                        System.out.println("(" + i+", "+j + ")" + "  " + "(" + nx+", "+ny + ")");
                        return;
                    }
                    // 파티션 있으면 pass
                    if (place[nx].charAt(ny) == 'X') continue;

                    // 빈 책상이면 한번더 가보기
                    for (int l = 0; l < 4; l++) {
                        int nnx = nx + dx[l];
                        int nny = ny + dy[l];

                        if (nnx < 0 || nnx >= 5 || nny < 0 || nny >= 5) continue;
                        if (nnx == i && nny == j) continue;
                        
                        // 사람 있으면 끝
                        if (place[nnx].charAt(nny) == 'P') {
                            answer[idx++] = 0;
                            System.out.println("(" + i+", "+j + ")" + "  " + "(" + nnx+", "+nny + ")");
                            
                            return;
                        }
                    }
                }
            }
        }
        
        answer[idx++] = 1;
        
    }
}