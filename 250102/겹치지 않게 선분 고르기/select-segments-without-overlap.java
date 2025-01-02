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

        public int getLength() {
            return Math.abs(start - end);
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
        }

        recur(idx+1);
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

        // 선분들을 start로 오름차순 정렬(같은 경우, 길이가 짧은 순)
        lines.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.getLength() - o2.getLength();
            }
            return o1.start - o2.start;
        });

        recur(0);
        System.out.println(max);
    }
}