
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        // 커서 바로 앞에 글자가 존재하면 지운다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        LinkedList<Character> password = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int cursor = 0;

            char[] inputs = br.readLine().toCharArray();

            for (char input : inputs) {
                if (input == '<') {
                    cursor = Math.max(--cursor, 0);
                } else if (input == '>') {
                    cursor = Math.min(++cursor, password.size());
                } else if (input == '-') {
                    int temp = cursor - 1;
                    if (temp < password.size() && temp >= 0) { // 현재 cursor 앞에 글자가 존재한다면
                        password.remove(temp);
                        cursor = temp;
                    }
                } else {
                    password.add(cursor++, input);
                }
            }
            for (char pw : password) sb.append(pw);
            sb.append("\n");
            password.clear();
        }
        System.out.println(sb);
    }

}
