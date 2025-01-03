import java.util.*;

public class Main {

    static char[] input;
    static int size;
    static int max = Integer.MIN_VALUE;

    static void recur(int idx) {
        if (idx >= size) {
            int res = calculate();
            max = Math.max(max, res);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            char tmp = input[idx];
            input[idx] = (char)(i + 48);    // '0' = 48

            recur(idx + 2);

            input[idx] = tmp;
        }
    }

    static int calculate() {
        int cur = input[0] - '0';
        for (int i = 1; i < size - 1; i += 2) {
            switch (input[i]) {
                case '-':
                    cur -= input[i+1] - '0';
                    break;
                case '+':
                    cur += input[i+1] - '0';
                    break;
                case '*':
                    cur *= input[i+1] - '0';
                    break;
            }
        }

        return cur;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.next().toCharArray();
        size = input.length;

        recur(0);
        System.out.println(max);
    }
}