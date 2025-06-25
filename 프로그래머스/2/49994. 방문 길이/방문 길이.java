import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        
        int answer = 0;
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('L', new int[]{-1, 0});
        map.put('R', new int[]{1, 0});
        map.put('D', new int[]{0, -1});
        
        int curX = 5; int curY = 5;
        
        // 지나간 경로 저장(왕복 경로 저장)
        HashSet<String> paths = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int dx = map.get(dir)[0];
            int dy = map.get(dir)[1];
            
            int nx = curX + dx;
            int ny = curY + dy;
            // 좌표 범위 넘어간 경우
            if (!inRange(nx, ny)) {
                continue;
            }
            
            paths.add(curX + " " + curY + " " + nx + " " + ny);
            paths.add(nx + " " + ny + " " + curX + " " + curY);
            curX = nx;
            curY = ny;
        }
        
        return paths.size() / 2;
    }
    
    public static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx <= 10 && 0 <= ny && ny <= 10;
    }
}