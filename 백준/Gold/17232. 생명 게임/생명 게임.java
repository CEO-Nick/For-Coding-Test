import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());   // 가로 길이
        int M = Integer.parseInt(st.nextToken());   // 세로 길이
        int T = Integer.parseInt(st.nextToken());

        char[][] array = new char[N + 1][M + 1];
        
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                array[i][j] = charArray[j - 1];
            }
        }

        int[][] sumArray = calculatePrefixSum(N, M, array);

        Set<Point> willDie = new HashSet<>();
        Set<Point> willBirth = new HashSet<>();
        while (T-- > 0) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // 현재 칸 생명 OK
                    int sum = countNearBy(i, K, j, N, M, sumArray);
                    if (array[i][j] == '*') {
                        sum--; // 자기 자신 제외
                        if (sum < a) {  // 고독
                            willDie.add(new Point(i, j));
                        } else if (sum > b) { // 과밀
                            willDie.add(new Point(i, j));
                        }
                        // 생존(할 거 없음)
                    } else {    // 현재 칸 생명 NO
                        if (a < sum && sum <= b) {
                            willBirth.add(new Point(i, j));
                        }
                    }
                }
            }
            
            // 다음 턴에 생명 생길 거 넣기
            if (!willBirth.isEmpty()) {
                willBirth.forEach(p -> array[p.x][p.y] = '*');
            }
            willBirth.clear();
            // 다음 턴에 죽을 얘들 죽이기
            if (!willDie.isEmpty()) {
                willDie.forEach(p -> array[p.x][p.y] = '.');
            }
            willDie.clear();
            // 누적합 다시 구하기
            sumArray = calculatePrefixSum(N, M, array);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                bw.write(array[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[][] calculatePrefixSum(int N, int M, char[][] array) {
        int[][] sumArray = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int live = array[i][j] == '*' ? 1 : 0;
                sumArray[i][j] =
                    sumArray[i][j - 1] + sumArray[i - 1][j] - sumArray[i - 1][j - 1] + live;
            }
        }
        return sumArray;
    }

    private static int countNearBy(int i, int K, int j, int N, int M, int[][] sumArray) {
        int startX = i - K;
        int startY = j - K;
        int endX = i + K;
        int endY = j + K;
        Point start = inRange(startX, startY, N, M);   // 정사각형 좌측 상단 모서리
        Point end = inRange(endX, endY, N, M);         // 정사각형 우측 하단 모서리
        return sumArray[end.x][end.y] - sumArray[start.x-1][end.y] - sumArray[end.x][start.y-1] + sumArray[start.x-1][start.y-1];
    }

    public static Point inRange(int x, int y, int N, int M) {
        if (x < 1) {
            x = 1;
        }
        if (x > N) {
            x = N;
        }
        if (y < 1) {
            y = 1;
        }
        if (y > M) {
            y = M;
        }
        return new Point(x, y);
    }

    static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
