import java.util.*;
import java.io.*;

public class Main {

    static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        answer[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == n) {
                return;
            }
            int next = 0;
            for (int i = 0; i < 4; i++) {
                if (i < 2) next = cur + d[i];
                else next = cur * d[i];

                if (next < 1) continue;
                if (next > n * 3) continue;

                if (answer[next] == 0) {
                    q.add(next);
                    answer[next] = answer[cur] + 1;
                }
            }
        }

    }
    

    static int[] d = new int[] {1, -1, 2, 3};
    static int n;
    static int MAX_VALUE = 1000001 * 3;
    static int[] answer = new int[MAX_VALUE];
    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        // -1   +1  짝수 -> /2  홀수 -> /3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 역으로 1에서 시작해서 덧셈 뺄셈 곱셉하기...?
        n = Integer.parseInt(br.readLine());    

        BFS();

        System.out.println(answer[n]);
    }
}
