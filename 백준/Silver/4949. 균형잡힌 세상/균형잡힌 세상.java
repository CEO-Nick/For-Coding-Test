
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] array = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        while (!(array[0] == '.')) {
            for (int i = 0; i < array.length-1; i++) {
                char ch = array[i];
                if (Character.isAlphabetic(ch) || ch == ' ') continue;
                if (stack.isEmpty()) {
                    stack.add(ch);
                    continue;
                }
                if (ch == ')' && stack.peek().equals('(')) {
                    stack.pop();
                } else if (ch == ']' && stack.peek().equals('[')) {
                    stack.pop();
                } else {
                    stack.add(ch);
                }
            }

            if (stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
            array = br.readLine().toCharArray();
            stack.clear();
        }
        System.out.println(sb);
        br.close();
    }
}
