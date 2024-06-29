
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        Integer[] B = new Integer[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        int idxA = 0, idxB = 0;
        Integer[] ans = new Integer[N+M];
        int index = 0;
        while (true) {
            if (idxA == N) {
                while (idxB < M) {
                    ans[index++] = B[idxB++];
                }
                break;
            }
            if (idxB == M) {
                while (idxA < N) {
                    ans[index++] = A[idxA++];
                }
                break;
            }

            if (A[idxA] < B[idxB]) {
                ans[index++] = A[idxA++];
            } else if (A[idxA] > B[idxB]) {
                ans[index++] = B[idxB++];
            } else {
                ans[index++] = A[idxA++];
                ans[index++] = B[idxB++];
            }
        }

        for (int num : ans) {
            bw.write(num + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
