import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[] curPos;
    static int[] dist;
    static int max = Integer.MIN_VALUE;

    static int calcScore() {
        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            if (curPos[i] + 1 >= m) cnt++;
        }

        return cnt;
    }

    static void move(int turn) {
        if (turn == n) {
            max = Math.max(max, calcScore());
            return;
        }

        for (int i = 1; i <= k; i++) {
            // i번 말이 이동한 경우
            curPos[i] += dist[turn];
            move(turn + 1);
            curPos[i] -= dist[turn];
        }
    }

    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        
        dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = sc.nextInt();

        // 각 말의 현재 위치를 저장할 배열
        curPos = new int[k+1];

        move(0);
        System.out.println(max);
    }
}