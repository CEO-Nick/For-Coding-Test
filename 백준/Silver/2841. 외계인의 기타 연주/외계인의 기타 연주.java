
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 프렛 한 번 누르거나 떼는 걸 한 번 움직인걸로 함
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]), P = Integer.parseInt(inputs[1]);
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();

        int count = 0;
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int line = Integer.parseInt(input[0]),  fret = Integer.parseInt(input[1]);

            if (!stackMap.containsKey(line)) {
                Stack<Integer> stack = new Stack<>();
                stack.add(fret);
                stackMap.put(line, stack);
                count++;
            } else {
                Stack<Integer> stack = stackMap.get(line);
                if (stack.peek() < fret) {
                    stack.add(fret);
                    count++;
                } else {
                    while (stack.peek() > fret) {
                        stack.pop();
                        count++;
                        if (stack.isEmpty()) break;
                    }
                    if (!stack.isEmpty() && stack.peek() == fret) continue;
                    stack.add(fret);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
