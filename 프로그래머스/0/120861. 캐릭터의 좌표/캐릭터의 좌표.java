import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = board[0] / 2;
        int y = board[1] / 2;
        
        HashMap<String, int[]> moveMap = new HashMap<>();
        moveMap.put("left", new int[]{-1, 0});
        moveMap.put("right", new int[]{1, 0});
        moveMap.put("down", new int[]{0, -1});
        moveMap.put("up", new int[]{0, 1});
        
        int curX = 0, curY = 0;
        for (String input : keyinput) {
            int[] move = moveMap.get(input);
            
            int ny = curY + move[1];
            int nx = curX + move[0];
            
            // board 벗어난 입력 무시
            if (nx < -x || nx > x || ny < -y || ny > y) continue;
            
            curX = nx; curY = ny;
        }
        
        return new int[] {curX, curY};
    }
}