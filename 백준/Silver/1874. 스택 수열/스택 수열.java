
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> answer = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (stack.isEmpty() || stack.peek() < num) {
                while (cur < num) {
                    stack.add(++cur);
                    answer.add("+");
                }
                stack.pop();
                answer.add("-");
            } else {
                if (stack.peek() == num) {
                    stack.pop();
                    answer.add("-");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        for (String s : answer) {
            System.out.println(s);
        }
        br.close();
    }
}
