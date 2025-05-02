import java.util.*;

class Solution {
    static char[][] containers;
    static char[][] tmp;
    static int N;
    static int M;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        // 알파벳 하나 -> 지게차 = 외부와 맞닿아 있는 알파벳들
        // 알파벳 2개 -> 크레인 = 그냥 다 꺼냄
        // 내부 빈칸이랑 맞닿아 있는건 외부가 아님
        
        // 외부와 맞닿아서 꺼낸 경우 -> 문자 0 -> 이 좌표도 이제 외부임
        // 내부에 꺼낸 경우 -> 문자 1
        
        // 꺼낼 때 상하좌우 조사 
            // -> 문자 0이 하나라도 있으면 자기 자리도 문자 0
            // -> 문자 0이 하나도 없으면 자기 자리 문자 1
        
        N = storage.length;
        M = storage[0].length();
        containers = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                containers[i][j] = storage[i].charAt(j);
            }
        }
        
        tmp = new char[N][M];
        for (String req : requests) {
            toTmp();        // containers -> tmp로 복사
            action(req);
            toContainers(); // tmp -> containers로 복사
            while (checkArround() != 0); // 1인 좌표 주변에 0인 좌표있는지 체크
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (containers[i][j] == '0' || containers[i][j] == '1') continue;
                answer++;
            }
        }
        return answer;
    }
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    
    public static void action(String req) {
        char target = req.charAt(0);
        // 지게차
        if (req.length() == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (containers[i][j] == target) retrieveWithForklift(i, j);
                }
            }
            return;
        }

        // 크레인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (containers[i][j] == target) retrieveWithCrane(i, j);
            }
        }
    }
    
    // 지게차로 꺼내기 -> 비교는 containers로, 기록은 tmp로 -> 동시에 한번에 꺼내는거니까
    public static void retrieveWithForklift(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];
            
            // 외부와 맞닿은 경우
            if (!inRange(nx, ny) || containers[nx][ny] == '0') {
                tmp[x][y] = '0';
                return;
            }
        }
    }
    
    // 크레인으로 꺼내기
    public static void retrieveWithCrane(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i];
            int ny = y + dys[i];
            
            // 외부와 맞닿은 경우
            if (!inRange(nx, ny) || tmp[nx][ny] == '0') {
                tmp[x][y] = '0';
                return;
            }
        }
        
        // 내부에 있는 경우
        tmp[x][y] = '1';
    }
    
    // 마지막으로 모든 좌표 둘러보면서 0으로 바뀜으로 인해 인접한 1도 0으로 수정
    public static int checkArround() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (containers[i][j] != '1') continue;
                // 현재 좌표가 1일 때만 주변에 0 있는지 확인
                for (int k = 0; k < 4; k++) {
                    int nx = i + dxs[k];
                    int ny = j + dys[k];  
                    if (!inRange(nx, ny)) continue;
                    if (containers[nx][ny] == '0') {
                        containers[i][j] = '0';
                        cnt++;
                        break;
                    }
                }
            }
        }
        
        return cnt;
    }
    
    private static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
    
    private static void toTmp() {
        for (int i = 0; i < N; i++) {
            tmp[i] = containers[i].clone();
        }
    }
    
    private static void toContainers() {
        for (int i = 0; i < N; i++) {
            containers[i] = tmp[i].clone();
        }
    }
    
    private static void printContainers() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(containers[i]));
        }
        System.out.println();
    }
}