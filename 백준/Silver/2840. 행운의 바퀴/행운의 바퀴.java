
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] array = new char[N];
        int idx = 0;
        boolean wrong = false;
        boolean[] isUsed = new boolean[26];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            idx = (idx + s) % N;

            // 이미 해당 자리에 적어놓은 알파벳이 있고, 그 알파벳이 내가 지금 적으려는 알파벳과 다른 경우
            // 행운의 바퀴 없는 경우임
            if (array[idx] != 0 && array[idx] != (ch)) {
                bw.write('!');
                wrong = true;
                break;
            }
            // 같은 글자 2번 이상 등장 & 본인 자리가 아니라면 -> 행운의 바퀴 없는 경우
            if (isUsed[ch - 'A'] && array[idx] != ch) {
                bw.write('!');
                wrong = true;
                break;
            }
            array[idx] = ch;
            isUsed[ch-'A'] = true;
        }

        if (!wrong) {
            while (N-- > 0) {
                char temp = array[idx];
                if (temp == 0) {
                    bw.write('?');
                } else {
                    bw.write(temp);
                }
                idx--;

                if (idx < 0) {
                    idx = array.length - 1;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


