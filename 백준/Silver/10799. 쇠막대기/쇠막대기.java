
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] array = sc.next().toCharArray();

        int open = 0;
        int ans = 0;
        int idx = 0;
        while (idx < array.length) {
            char ch = array[idx];

            if (ch == '(' && array[idx+1] == ')') {
                ans += open;
                idx++;
            } else if (ch == '(') {
                open++;
            } else if (ch == ')') {
                ans++;
                open--;
            }
            idx++;
        }


        System.out.println(ans);
    }

}
