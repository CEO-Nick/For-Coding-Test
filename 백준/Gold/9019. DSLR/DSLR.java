import java.io.*;
import java.util.*;

public class Main {
    static int t;

    static int a;
    static int b;

    static String[] visited;
    static char[] commands = new char[] {'D', 'S', 'L', 'R'};

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 레지스터에 0 ~ 9999 값 저장 가능
        // D : x 2 연산 (결과값이 9999보다 크면 10000으로 나눈 나머지 값으로 저장)
        // S : -1 연산 (0 -1 = 9999)
        // L : 1234 -> 2341 로 만들기
        // R : 1234 -> 4123 으로 만들기

        // A -> B로 만드는 최소한의 명령어들 나열하기

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            bfs();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() throws IOException {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);
        visited = new String[10001];
        visited[a] = "";

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int next = 0;
                switch (i) {
                    case 0:
                        next = D(cur);
                        break;
                    case 1:
                        next = S(cur);
                        break;
                    case 2:
                        next = L(cur);
                        break;
                    case 3:
                        next = R(cur);
                        break;
                }
                if (visited[next] == null) {
                    visited[next] = visited[cur] + commands[i];
                    q.add(next);
                }
                if (next == b) {
                    bw.write(visited[next] + "\n");
                    return;
                }
            }
        }
    }

    static int D(int number) {
        int answer = number * 2;
        return answer > 9999 ? answer % 10000 : answer;
    }

    static int S(int number) {
        int answer = number - 1;
        return answer == -1 ? 9999 : answer;
    }

    static int L(int number) {
        String s = make4LengthNumber(number);
        return Integer.parseInt(s.substring(1, 4) + s.charAt(0));
    }

    static int R(int number) {
        String s = make4LengthNumber(number);
        return Integer.parseInt(s.charAt(3) + s.substring(0, 3));
    }

    // 4자리 숫자로 만듦 (1 -> 0001)
    static String make4LengthNumber(int number) {
        String s;
        StringBuilder sb = new StringBuilder();

        if (0 <= number && number < 10) {
            s = sb.append("000").append(number).toString();
        } else if (10 <= number && number < 100) {
            s = sb.append("00").append(number).toString();
        } else if (100 <= number && number < 1000) {
            s = sb.append("0").append(number).toString();
        } else {
            s = String.valueOf(number);
        }
        return s;
    }
}