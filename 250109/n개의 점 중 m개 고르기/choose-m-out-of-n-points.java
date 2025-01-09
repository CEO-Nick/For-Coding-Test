import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Integer> idxList;
    static int answer = Integer.MAX_VALUE;

    static void recur(int idx, int count) {
        if (count == m) {
            int res = calcMinDist();
            answer = Math.min(answer, res);
            return;
        }

        if (idx == n) return;

        recur(idx+1, count);

        idxList.add(idx);
        recur(idx+1, count+1);
        idxList.remove(idxList.size()-1);

    }

    static int calcMinDist() {
        int size = idxList.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i+1; j < size; j++) {
                max = Math.max(max, dist(points[idxList.get(i)], points[idxList.get(j)]));
            }
        }

        return max;
    }

    static int dist(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    static void print() {
        for (int i : idxList) {
            System.out.print(points[i] + " ");
        }
    }

    static int n;
    static int m;
    static Point[] points;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        // 점 m개 선택 -> 그 중 가장 먼 2개의 점 거리 구하기 -> 그게 최소 값이 되도록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        idxList = new ArrayList<>();

        recur(0, 0);

        System.out.println(answer);
    }
}