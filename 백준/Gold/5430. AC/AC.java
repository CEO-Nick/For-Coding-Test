
import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // R : 배열에 있는 수의 순서 뒤집기
        // D : 배열의 첫 번째 수 버리기 (배열 비어있는데 수행하면 에러 발생)

        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        while (T-- > 0) {
            char[] functions = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            char[] array = br.readLine().toCharArray();
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] == ',') {
                    q.add(Integer.parseInt(temp.toString()));
                    temp = new StringBuilder();
                } else {
                    temp.append(array[i]);
                }
            }
            if (!temp.toString().isEmpty()) {
                q.add(Integer.parseInt(temp.toString()));
            }

            int t = functions.length;
            int idx = 0;
            int isReversed = 0;
            boolean isError = false;

            while (t-- > 0) {
                char func = functions[idx++];
                if (func == 'R') {
                    isReversed = (isReversed + 1) % 2;
                } else {
                    if (q.isEmpty()) {
                        bw.write("error" + "\n");
                        isError = true;
                        break;
                    }
                    if (isReversed == 1) {
                        q.removeLast();
                    } else {
                        q.removeFirst();
                    }
                }
            }

            if (!isError) {
                bw.write("[");
                if (isReversed == 1) {
                    while (!q.isEmpty()) {
                        bw.write(q.removeLast().toString());
                        if (!q.isEmpty()) bw.write(",");
                    }
                } else {
                    while (!q.isEmpty()) {
                        bw.write(q.removeFirst().toString());
                        if (!q.isEmpty()) bw.write(",");
                    }
                }
                bw.write("]" + "\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
