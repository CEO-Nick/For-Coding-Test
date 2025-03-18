import java.util.*;

class Solution {
    static boolean[][] visited;
    
    public int solution(String dirs) {
        int answer = 0;
        visited = new boolean[11][11];
        int x = 5, y = 5;
        visited[x][y] = true;
        
        char[] inputs = dirs.toCharArray();
        HashSet<String> set = new HashSet<>();
        StringBuilder sb;
        for (char cmd : inputs) {
            int d = direction(cmd);
            // 다음 이동할 좌표값 구하기
            int nx = x + dxs[d], ny = y + dys[d];
            
            // 범위 안에 있는 경우만 처리
            if (inRange(nx, ny)) {
                sb = new StringBuilder();
                String road1 = sb.append(x).append(y).append(nx).append(ny).toString();
                sb = new StringBuilder();
                String road2 = sb.append(nx).append(ny).append(x).append(y).toString();
                
                if (!set.contains(road1) && !set.contains(road2)) {
                    answer++;
                    set.add(road1);
                    set.add(road2);
                }
                x = nx; y = ny;
            }
            // System.out.println("(" + x + ", " + y + "): " + answer);
            // System.out.println(set);
        }
        return answer;
    }
    
    static int[] dxs = new int[] {1, 0 , -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};
    
    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx <= 10 && 0 <= ny && ny <= 10;
    }
    
    static int direction(char cmd) {
        switch (cmd) {
            case 'D':
                return 3;
            case 'L':
                return 2;
            case 'U':
                return 1;
            case 'R':
                return 0;
            default:
                return 0;
        }
    }
    
    
}