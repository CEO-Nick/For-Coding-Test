import java.util.*;

class Solution {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    static HashMap<Integer, Point> pointMap;
    static ArrayList<Point>[] routeList;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        pointMap = new HashMap<>();
        
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0] - 1;
            int y = points[i][1] - 1;
            pointMap.put(i+1, new Point(x, y));
        }
        
        // idx: 로봇 번호 arraylist: 로봇의 방문 좌표 리스트
        routeList = new ArrayList[routes.length];
        for (int i = 0; i < routeList.length; i++) {
            routeList[i] = new ArrayList<Point>();
        }
        
        // 가장 긴 경로 기록
        int maxLen = -1;
        
        // 로봇 경로 기록
        for (int i = 0; i < routes.length; i++) {
            recordFullRoute(i, routes[i]);
            maxLen = Math.max(maxLen, routeList[i].size());
        }
        
        // 매 초마다 각 좌표에 있는 로봇 개수
        HashMap<Point, Integer> countMap = new HashMap<>();
        for (int j = 0; j < maxLen; j++) {
            countMap.clear();
            for (int i = 0; i < routeList.length; i++) {
                if (j >= routeList[i].size()) continue;
                Point p = routeList[i].get(j);
                countMap.put(p, countMap.getOrDefault(p, 0) + 1);
            }
            
            for (int count : countMap.values()) {
                if (count >= 2) answer++;
            }
        }
        
        return answer;
    }
    
    // 로봇의 path가 주어지면 최단거리 기록
    public static void recordFullRoute(int robotIdx, int[] path) {
        for (int i = 0; i < path.length - 1; i++) {
            int curP = path[i];
            int nextP = path[i+1];
            
            if (i == 0) {
                routeList[robotIdx].add(pointMap.get(curP));
            }
            
            recordRoute(robotIdx, curP, nextP);
        }
    }
    
    // 두 point 사이의 최단 거리 기록
    public static void recordRoute(int idx, int sp, int ep) {
        Point startPoint = pointMap.get(sp);
        Point endPoint = pointMap.get(ep);
        
        int startX = startPoint.x;
        int startY = startPoint.y;
        
        int endX = endPoint.x;
        int endY = endPoint.y;
        
        int curX = startX;
        int curY = startY;
        
        // r좌표 변하는 이동 먼저
        while (curX != endX) {
            int dx = endX > startX ? 1 : -1;
            curX += dx;
            routeList[idx].add(new Point(curX, curY));
        }
        
        while (curY != endY) {
            int dy = endY > startY ? 1 : -1;
            curY += dy;
            routeList[idx].add(new Point(curX, curY));
        }
    }
}