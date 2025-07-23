import java.util.*;

class Solution {
    // 이동거리가 k여야 함
    // 중복 방문 가능
    // 탈출 경로를 문자열로 나타내면 사전순 경로로 탈출
    // d -> l -> r -> u
    
    class Point {
        int x;
        int y;
        int cnt;
        String route;
        Point(int x, int y, int cnt, String route) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.route = route;
        }
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(x-r) + Math.abs(y-c);
        int diff = k - distance;
        
        if (diff < 0 || diff % 2 == 1) return "impossible";
        
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            // 범위에 벗어나지 않고, 해당 방향으로 움직였을 때 거리가 가까워진 거라면 이동하기
            if (x + 1 <= n && Math.abs(x+1 - r) + Math.abs(y-c) <= k) {
                x++;
                sb.append("d");
            } else if (y - 1 >= 1 && Math.abs(x-r) + Math.abs(y-1-c) <= k) {
                y--;
                sb.append("l");
            } else if (y+1 <= m && Math.abs(x-r) + Math.abs(y+1-c) <= k) {
                y++;
                sb.append("r");
            } else {
                x--;
                sb.append("u");
            }
        }
        
        return sb.toString();
    }
}