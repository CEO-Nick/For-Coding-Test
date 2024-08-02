
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int l;
    public static int c;
    public static int vowel;        // 모음
    public static int consonant;    // 자음

    public static int[] array;
    public static int[] answer;
    public static boolean[] check;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // 서로 다른 L개 소문자
        // 최소 1개 모음(a,e,i,o,u)
        // 최소 2개 자음
        // 알파벳 오름차순
        // 알파벳 주어지면 가능성있는 암호 만들기

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[c];
        for (int i = 0; i < c; i++) {
            array[i] = st.nextToken().charAt(0) - 'a';
        }
        Arrays.sort(array);
        answer = new int[c];
        check = new boolean[c];

        solution(0);
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void solution (int length) throws IOException {
        if (length == l && vowel >= 1 && consonant >= 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l; i++) {
                sb.append((char)(answer[i] + 'a'));
            }
            bw.write(sb + "\n");
            return;
        }

        for (int i = 0; i < c; i++) {
            int element = array[i];
            boolean isVowel = false;
            if (length > 0 && answer[length-1] > element) continue;
            if (!check[i]) {
                check[i] = true;

                if (element == 0 || element == 4 || element == 8 || element == 14 || element == 20) isVowel = true;
                if (isVowel) vowel++;
                else consonant++;
                answer[length] = element;

                solution(length + 1);

                check[i] = false;
                if (isVowel) vowel--;
                else consonant--;
            }
        }
    }

}
