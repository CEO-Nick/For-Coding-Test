
import java.io.*;

public class Main {
    static int t;
    static int n;
    static int[] select;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        // 자기 자신 고르면 혼자 팀
        // 4 -> 7 -> 6 -> 4 : (4, 6, 7) 한 팀
        // 어느 팀에도 속하지 않는 학생들의 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            select = new int[n+1];
            String[] input = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) select[i] = Integer.parseInt(input[i-1]);

            visited = new int[n+1];

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    count += dfs(i);
                }
            }
            int ans = n - count;
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int i) {
        int next = select[i];
        int cycleCnt = 0;

        // 첫 방문
        if (visited[next] == 0) {
            visited[next] = visited[i] + 1;
            cycleCnt = dfs(next);
        }
        // 재방문 -> 사이클 형성
        else {
            cycleCnt = visited[i] - visited[next] + 1;
        }

        // 다음 탐색을 위해 노드 초기화
        visited[i] = 100001;

        // 사이클이 아니면 0을 리턴
        return Math.max(cycleCnt, 0);
    }
}
