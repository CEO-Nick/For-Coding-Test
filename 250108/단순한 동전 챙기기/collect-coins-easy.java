import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;
        int value;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                '}';
        }
    }

    
    static ArrayList<Point> answer;
    static int min = Integer.MAX_VALUE;

    static void recur(int curIdx) {
        if (answer.size() == 3) {
            min =  Math.min(min, calculate());
            return;
        }

        if (curIdx == list.size()) return;

        recur(curIdx+1);

        Point cur = list.get(curIdx);

        answer.add(cur);
        recur(curIdx+1);
        answer.remove(answer.size()-1);
    }

    

    static int calculate() {
        Point cur = new Point(sx, sy, 0);
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            Point now = answer.get(i);
            sum += (Math.abs(cur.x - now.x) + Math.abs(cur.y - now.y));
            cur = now;
        }  

        sum += (Math.abs(cur.x - ex) + Math.abs(cur.y - ey));

        return sum;
    }

    static int n;
    static char[][] grid;
    // start x, y
    static int sx;
    static int sy;
    // end x, y
    static int ex;
    static int ey;

    static ArrayList<Point> list;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        list = new ArrayList<>();
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                char cur = input[j];
                if (cur == 'S') {
                    sx = i; sy = j;
                } else if (cur == 'E') {
                    ex = i; ey = j;
                } else if (cur != '.') {
                    list.add(new Point(i, j, cur - '0'));
                }
                grid[i][j] = cur;
            }
        }
       
        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.value - p2.value;
            }
        });

        recur(0);
        
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }
}