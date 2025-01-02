import java.util.*;
import java.io.*;

public class Main {
    static class Line {
        int start;
        int end; 

        Line(int s, int e) {
            start = s;
            end = e;
        }
    }

    static void recur(int idx) {
        if (idx == n) {
            max = Math.max(max, count);
            return;
        }

        Line curLine = lines.get(idx);
        int tmp = beforeEnd;

        if (beforeEnd < curLine.start) {
            beforeEnd = curLine.end;
            count++;

            recur(idx+1);

            count--;
            beforeEnd = tmp;
        } else {
            recur(idx+1);
        }
    }

    static int n;
    static ArrayList<Line> lines;
    static int beforeEnd = -1;
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            lines.add(new Line(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        recur(0);
        System.out.println(max);
    }
}