
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        while (T-- > 0) {
            char[] brackets = br.readLine().toCharArray();
            for (char bra : brackets) {
                if (stack.isEmpty()) {
                    stack.add(bra);
                    continue;
                }
                if (stack.peek().equals('(') && bra == ')') {
                    stack.pop();
                } else stack.add(bra);
            }

            if (stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
            stack.clear();
        }

        System.out.println(sb);
    }
}
